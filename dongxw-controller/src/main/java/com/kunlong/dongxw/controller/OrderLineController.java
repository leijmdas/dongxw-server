package com.kunlong.dongxw.controller;


import app.support.query.PageResult;
import com.kunlong.dubbo.sys.model.SysUserDTO;
import com.kunlong.dongxw.annotation.DateRewritable;
import com.kunlong.dongxw.consts.ApiConstants;
import com.kunlong.dongxw.consts.MoneyTypeConsts;
import com.kunlong.dongxw.data.domain.OrderLine;
import com.kunlong.dongxw.data.domain.Product;
import com.kunlong.dongxw.data.service.*;
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
    CustomerService customerService;

    @Autowired
    OrderMasterService orderMasterService;

    @Autowired
    OrderLineService orderLineService;
    @Autowired
    ProductService productService;

    @Autowired
    ProductTypeService productTypeService;

    @RequestMapping("/findById/{id}")
    public JsonResult<OrderLine> findById(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException {
        OrderLine orderLine = orderLineService.findById(id);
        orderLine.setProduct(productService.findById(orderLine.getProductId()));

        return JsonResult.success(orderLine);
    }

    @RequestMapping("/save")
    public JsonResult<Integer> save(@RequestBody OrderLine orderLine) {

        orderLine.setMoney(orderLine.getPrice().multiply(new BigDecimal(orderLine.getQty())));
        orderLine.setMoney(orderLine.getMoney().setScale(2, BigDecimal.ROUND_HALF_UP));
        if (orderLine.getProductId() != null) {
            Product product = productService.findById(orderLine.getProductId());
            if (product != null) {
                orderLine.setParentId(product.getParentId());
                orderLine.setProductTypeId(product.getProductTypeId());
                orderLine.setCustomerId(product.getCustomerId());
            }
        }
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

        queryParam.setSortBys("id|desc");

        pageResult.setTotal(orderLineService.countByQueryParam(queryParam));
        pageResult.setData(orderLineService.findByQueryParam(queryParam));

        for(OrderLine orderLine : pageResult.getData()){
            orderLine.setCustomer(customerService.findById(orderLine.getCustomerId()));
            orderLine.setOrderMaster(orderMasterService.findById(orderLine.getOrderId()));

            orderLine.setParentProductType (productTypeService.findById(orderLine.getParentId()));
            orderLine.setProductType (productTypeService.findById(orderLine.getProductTypeId()));
            orderLine.setProduct(productService.findById(orderLine.getProductId()));
            SysUserDTO sysUserDTO=sysUserApiService.findById(orderLine.getCreateBy());
            orderLine.setCreateByName(sysUserDTO==null?"-":sysUserDTO.getUsername());
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

        strings.add("客户名称");
        strings.add("客订单号");
        strings.add("EP订单号");
        strings.add("大类");
        strings.add("小类");
        strings.add("客款号");
        strings.add("EP款号");
        strings.add("产品描述");
        strings.add("颜色");
        strings.add("尺寸");
        strings.add("数量");
        strings.add("单位");
        strings.add("单价");
        strings.add("金额");
        strings.add("币种");
        strings.add("条码");
        strings.add("备注");

        return strings;
    }
    List<List<Object>> buildRecords(List<OrderLine> orderMasters) {
        List<List<Object>> records = new ArrayList<>();
        for (OrderLine orderLine : orderMasters) {
            List<Object> r = new ArrayList<>();

            //strings.add("客户名称");
            r.add(orderLine.getCustomer().getCustName());
            //strings.add("客订单号");
            System.out.println(orderLine);
            System.out.println(orderLine.getOrderMaster());

            r.add(orderLine.getOrderMaster()==null?'-':orderLine.getOrderMaster().getCustomerOrderCode());
            //strings.add("EP订单号");
            r.add(orderLine.getOrderMaster()==null?'-':orderLine.getOrderMaster().getEpOrderCode());
            //strings.add("大类");
            r.add(orderLine.getParentProductType().getCode());
            //strings.add("小类");
            r.add(orderLine.getProductType().getCode());
            //strings.add("客款号");
            r.add(orderLine.getProduct().getCode());
            //strings.add("EP款号");
            r.add(orderLine.getProduct().getEpCode());
            //strings.add("产品描述");
            r.add(orderLine.getProduct().getRemark());
            //strings.add("颜色");
            r.add(orderLine.getProduct().getColor());
            //strings.add("尺寸");
            r.add(orderLine.getProduct().getSize());

            //strings.add("数量");
            r.add(orderLine.getQty());
            // strings.add("单位");
            r.add(orderLine.getProduct().getUnit());
            //strings.add("单价");
            r.add(orderLine.getPrice());
            //strings.add("金额");
            r.add(orderLine.getMoney());
            //strings.add("币种");
            //r.add(orderLine.getOrderMaster()==null?'-':orderLine.getOrderMaster().getMoneyType());
            r.add(MoneyTypeConsts.getMoneyType(orderLine.getOrderMaster() == null ? -1 : orderLine.getOrderMaster().getMoneyType()));

            //strings.add("条码");
            r.add(orderLine.getProduct().getBarCode());
            //strings.add("备注");
            r.add(orderLine.getRemark());

            records.add(r);
        }
        return records;
    }

}

