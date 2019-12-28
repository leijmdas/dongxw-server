package com.kunlong.dongxw.controller;


import app.support.query.PageResult;
import com.kunlong.dongxw.annotation.DateRewritable;
import com.kunlong.dongxw.consts.ApiConstants;
import com.kunlong.dongxw.consts.OrderConsts;
import com.kunlong.dongxw.dongxw.domain.OrderMaster;
import com.kunlong.dongxw.dongxw.service.CustomerService;
import com.kunlong.dongxw.dongxw.service.OrderMasterService;
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
@RequestMapping("/dongxw/ordermaster")
public final class OrderMasterController {
    @Autowired
    OrderMasterService orderMasterService;

    @Autowired
    CustomerService customerService;

    @RequestMapping("/findById/{id}")
    public JsonResult<OrderMaster> findById(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException {
         return   JsonResult.success(orderMasterService.findById(id))    ;
    }

    @RequestMapping("/save")
    public JsonResult<Integer> save(@RequestBody OrderMaster orderMaster) {

        if (orderMaster.getId() == null) {
            orderMasterService.save(orderMaster);
        } else {
            orderMasterService.update(orderMaster);
        }

        return JsonResult.success(orderMaster.getId());
    }

    @PostMapping("/deleteById/{id}")
    public JsonResult<Integer> deleteById(@PathVariable("id") Integer id) throws IOException {

        OrderMaster orderMaster=orderMasterService.findById(id);
        if(orderMaster!=null){
            if(orderMaster.getStatus().compareTo(OrderConsts.ORDER_STATUS_DRAFT)>0){
                throw new RuntimeException("非草稿不能删除！");
            }else{
                orderMasterService.deleteById(id) ;
            }

        }

        return JsonResult.success();
    }

    @PostMapping("/query")
    public PageResult<OrderMaster> query(@RequestBody OrderMaster.QueryParam queryParam) throws IOException {
        PageResult<OrderMaster> pageResult = new PageResult<>();
        // Customer.QueryParam qp = BeanMapper.getInstance().map(pageResult, Customer.QueryParam.class);

        pageResult.setTotal(orderMasterService.countByQueryParam(queryParam));
        pageResult.setData(orderMasterService.findByQueryParam(queryParam));

        for(OrderMaster orderMaster : pageResult.getData()){
            orderMaster.setCustomer(customerService.findById(orderMaster.getCustomerId()));
        }
        return pageResult;
    }


    @RequestMapping(value="export",method = RequestMethod.POST)
    @ApiOperation(value = "export", notes = "export", authorizations = {@Authorization(value = ApiConstants.AUTH_API_WEB)})
    public void export(@RequestBody @DateRewritable OrderMaster.QueryParam queryParam, HttpServletRequest req, HttpServletResponse rsp) throws FileNotFoundException, IOException {

        if(queryParam.getParam() == null) {
            queryParam.setParam(new OrderMaster());
        }
        queryParam.setLimit(-1);
        queryParam.setStart(0);

        WebFileUtil web = new WebFileUtil(req,rsp);
        List<OrderMaster> orderMasters = orderMasterService.findByQueryParam(queryParam);;
        web.export2EasyExcelObject("客户订单.xlsx", buildTitles(),buildRecords(orderMasters));

    }

    List<String> buildTitles() {
        List<String> strings = new ArrayList<>();

        strings.add("日期");
        strings.add("业务员");

        return strings;
    }

    //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //r.add(sdf.format(payOrder.getPayTime()));
    String transDatetime(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(d);
    }

    String transDate(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(d);
    }

    List<List<Object>> buildRecords(List<OrderMaster> orderMasters) {
        List<List<Object>> records = new ArrayList<>();
        for (OrderMaster orderMaster : orderMasters) {
            List<Object> r = new ArrayList<>();

            r.add(transDate(orderMaster.getCheckDate()));
            r.add(orderMaster.getBusinessBy());


            records.add(r);
        }
        return records;
    }

}

