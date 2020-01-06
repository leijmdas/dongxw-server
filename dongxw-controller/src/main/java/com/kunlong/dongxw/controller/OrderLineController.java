package com.kunlong.dongxw.controller;


import app.support.query.PageResult;
import com.kunlong.dongxw.annotation.DateRewritable;
import com.kunlong.dongxw.consts.ApiConstants;
import com.kunlong.dongxw.dongxw.domain.OrderLine;
import com.kunlong.dongxw.dongxw.service.*;
import com.kunlong.dongxw.util.WebFileUtil;
import com.kunlong.platform.utils.JsonResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * cust类
 * Package:
 * Author: cch/leijiming
 * Date: Created in 2018/8/23 16:50
 */
@RestController
@RequestMapping("/dongxw/orderline")
public final class OrderLineController extends BaseController {

    @Autowired
    OrderLineService orderLineService;
    @Autowired
    CustomerService customerService;
    @Autowired
    OrderMasterService orderMasterService;

    @Autowired
    ProductTypeService productTypeService;
    @Autowired
    ProductService productService;
//    @Autowired
//    SupplierService supplierService;

    @RequestMapping("/findById/{id}")
    public JsonResult<OrderLine> findById(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException {
         return   JsonResult.success(orderLineService.findById(id))    ;
    }

    @RequestMapping("/save")
    public JsonResult<Integer> save(@RequestBody OrderLine orderLine) {

        orderLine.setMoney(orderLine.getPrice().multiply(new BigDecimal(orderLine.getQty())));

        if (orderLine.getId() == null) {
            orderLine.setCreateBy(getCurrentUserId());
            orderLine.setCreateDate(new Date());
            orderLineService.save(orderLine);
        } else {
            orderLineService.update(orderLine);
        }

        return JsonResult.success(orderLine.getId());
    }

    @PostMapping("/deleteById/{id}")
    public JsonResult<Integer> deleteById(@PathVariable("id") Integer id) throws IOException {

        OrderLine orderLine=orderLineService.findById(id);
        if(orderLine!=null){
            orderLineService.deleteById(id) ;


        }

        return JsonResult.success();
    }

    @PostMapping("/query")
    public PageResult<OrderLine> query(@RequestBody OrderLine.QueryParam queryParam) throws IOException {
        PageResult<OrderLine> pageResult = new PageResult<>();

        pageResult.setTotal(orderLineService.countByQueryParam(queryParam));
        pageResult.setData(orderLineService.findByQueryParam(queryParam));

        for(OrderLine orderLine : pageResult.getData()){
            orderLine.setCustomer(customerService.findById(orderLine.getCustomerId()));
            orderLine.setOrderMaster(orderMasterService.findById(orderLine.getOrderId()));

            orderLine.setParentProductType (productTypeService.findById(orderLine.getParentId()));
            orderLine.setProductType (productTypeService.findById(orderLine.getProductTypeId()));
            orderLine.setProduct(productService.findById(orderLine.getProductId()));
            //orderLine.setSupplier (supplierService.findById(orderLine.getSupplierId()));
        }
        return pageResult;
    }


    @RequestMapping(value="export",method = RequestMethod.POST)
    @ApiOperation(value = "export", notes = "export", authorizations = {@Authorization(value = ApiConstants.AUTH_API_WEB)})
    public void export(@RequestBody @DateRewritable OrderLine.QueryParam queryParam, HttpServletRequest req, HttpServletResponse rsp) throws FileNotFoundException, IOException {

        if(queryParam.getParam() == null) {
            queryParam.setParam(new OrderLine());
        }
        queryParam.setLimit(-1);
        queryParam.setStart(0);

        WebFileUtil web = new WebFileUtil(req,rsp);
        PageResult<OrderLine> pageResult = query(queryParam);;
        web.export2EasyExcelObject("订单产品表.xlsx", buildTitles(),buildRecords(pageResult.getData()));

    }



    String transDatetime(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(d);
    }

    String transDate(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(d);
    }
    List<String> buildTitles() {
        List<String> strings = new ArrayList<>();

        //strings.add("主料");

        strings.add("产品");
        strings.add("数量");
        strings.add("单价");
        strings.add("金额");

        return strings;
    }
    List<List<Object>> buildRecords(List<OrderLine> orderMasters) {
        List<List<Object>> records = new ArrayList<>();
        for (OrderLine orderLine : orderMasters) {
            List<Object> r = new ArrayList<>();
//            if(orderLine.getMaterial()!=null) {
//                r.add(orderLine.getMaterial());
//            }else{
//                r.add("");
//            }

            r.add(orderLine.getProduct().getCode());
            r.add(orderLine.getQty());
            r.add(orderLine.getPrice());
            r.add(orderLine.getMoney());


            records.add(r);
        }
        return records;
    }

}

