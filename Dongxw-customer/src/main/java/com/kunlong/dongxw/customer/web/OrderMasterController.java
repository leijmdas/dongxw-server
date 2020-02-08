package com.kunlong.dongxw.customer.web;


import app.support.query.PageResult;
import com.kunlong.dubbo.api.service.MailApiService;
import com.kunlong.dongxw.customer.annotation.DateRewritable;
import com.kunlong.dongxw.customer.consts.ApiConstants;
import com.kunlong.dongxw.customer.consts.MoneyTypeConsts;
import com.kunlong.dongxw.customer.consts.OrderStatusConsts;
import com.kunlong.dongxw.customer.consts.OrderTypeConsts;
import com.kunlong.dongxw.customer.controller.BaseController;
import com.kunlong.dongxw.data.domain.Customer;
import com.kunlong.dongxw.data.domain.OrderMaster;
import com.kunlong.dongxw.data.service.CustomerService;
import com.kunlong.dongxw.data.service.OrderMasterService;
import com.kunlong.dongxw.util.WebFileUtil;
import com.kunlong.platform.utils.JsonResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
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
@RequestMapping(ApiConstants.AUTH_API_WEB_CUSTOMER+"/ordermaster")

public final class OrderMasterController extends BaseController {
    @Autowired
    OrderMasterService orderMasterService;

    @Autowired
    CustomerService customerService;

    @Reference(lazy = true, version = "${dubbo.service.version}")
    MailApiService mailApiService;

    @PostMapping("/findById/{id}")
    public JsonResult<OrderMaster> findById(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException {
        OrderMaster orderMaster = orderMasterService.findById(id);
//        SysUserDTO sysUserDTO = sysUserApiService.findById(orderMaster.getCreateBy());
//        orderMaster.setCreateByName(sysUserDTO == null ? "-" : sysUserDTO.getUsername());
        if(!orderMaster.getCustomerId().equals(getCustomer().getId()))
        {
            return null;
        }
        return JsonResult.success(orderMaster);

    }




    @PostMapping("/query")
    public PageResult<OrderMaster> query(@RequestBody OrderMaster.QueryParam queryParam) throws IOException {
        PageResult<OrderMaster> pageResult = new PageResult<>();
        // Customer.QueryParam qp = BeanMapper.getInstance().map(pageResult, Customer.QueryParam.class);
        if(queryParam.getParam() == null) {
            queryParam.setParam(new OrderMaster());
        }
        queryParam.getParam().setCustomerId(this.getCustomer().getId());

        pageResult.setTotal(orderMasterService.countByQueryParam(queryParam));
        pageResult.setData(orderMasterService.findByQueryParam(queryParam));

        for (OrderMaster orderMaster : pageResult.getData()) {
            orderMaster.setCustomer(customerService.findById(orderMaster.getCustomerId()));
            if (orderMaster.getOrderType() == 200 && orderMaster.getParentId() > 0) {
                orderMaster.setOrderMasterParent(orderMasterService.findById(orderMaster.getParentId()));
            }
//            SysUserDTO sysUserDTO = sysUserApiService.findById(orderMaster.getCreateBy());
//            if (sysUserDTO != null) {
//                orderMaster.setCreateByName(sysUserDTO.getUsername());
//            }
        }
        return pageResult;
    }


    @PostMapping(value="export")
    @ApiOperation(value = "export", notes = "export", authorizations = {@Authorization(value = ApiConstants.AUTH_API_WEB)})
    public void export(@RequestBody @DateRewritable OrderMaster.QueryParam queryParam, HttpServletRequest req, HttpServletResponse rsp) throws FileNotFoundException, IOException {

        if(queryParam.getParam() == null) {
            queryParam.setParam(new OrderMaster());
        }
        queryParam.setLimit(-1);
        queryParam.setStart(0);
        queryParam.getParam().setCustomerId(this.getCustomer().getId());
        WebFileUtil web = new WebFileUtil(req,rsp);
        List<OrderMaster> orderMasters = orderMasterService.findByQueryParam(queryParam);;
        web.export2EasyExcelObject("客户订单.xlsx", buildTitles(),buildRecords(orderMasters));
    }

    @PostMapping(value="exportMail")
    @ApiOperation(value = "exportMail", notes = "exportMail", authorizations = {@Authorization(value = ApiConstants.AUTH_API_WEB)})
    public  JsonResult<String> exportMail(@RequestBody @DateRewritable OrderMaster.QueryParam queryParam ) throws IOException {

        if(queryParam.getParam() == null) {
            queryParam.setParam(new OrderMaster());
        }
        queryParam.setLimit(-1);
        queryParam.setStart(0);
        queryParam.getParam().setCustomerId(this.getCustomer().getId());

        WebFileUtil web = new WebFileUtil();
        List<OrderMaster> orderMasters = orderMasterService.findByQueryParam(queryParam);

        File f = web.export2EasyExcelFile("客户订单", buildTitles(), buildRecords(orderMasters));
        mailApiService.sendEmail("leijmdas_s@163.com", "客户订单", "客户订单", f.getPath());

        return JsonResult.success(f.getName());
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

    List<String> buildTitles() {
        List<String> strings = new ArrayList<>();

        strings.add("订单类型");
        strings.add("父订单");
        strings.add("客户代码");
        strings.add("客户名称");
        strings.add("客户订单号");
        strings.add("EP订单号");

        strings.add("订单状态");
        strings.add("结算币种");
        strings.add("业务员");
        strings.add("下单日期");
        strings.add("客户交货日期");
        strings.add("验货日期");
        strings.add("工厂交货日期");
        strings.add("预收发票编号");
        strings.add("正式发票编号");
        strings.add("备注");

        return strings;
    }

    List<List<Object>> buildRecords(List<OrderMaster> orderMasters) {
        List<List<Object>> records = new ArrayList<>();
        for (OrderMaster orderMaster : orderMasters) {
            List<Object> r = new ArrayList<>();
            r.add(OrderTypeConsts.getType(orderMaster.getOrderType()));
            if (orderMaster.getOrderType().equals(OrderTypeConsts.TYPE_SUB) && orderMaster.getParentId() > 0) {
                OrderMaster p = orderMasterService.findById(orderMaster.getParentId());
                r.add(p == null ? '-' : p.getEpOrderCode());
            }
            r.add("");
            Customer customer = customerService.findById(orderMaster.getCustomerId());
            //  strings.add("客户代码");
            r.add(customer==null?"-":customer.getCustNo());
            //strings.add("客户名称");
            r.add(customer==null?"-":customer.getCustName());

            r.add(orderMaster.getCustomerOrderCode());
            r.add(orderMaster.getEpOrderCode());


            //strings.add("订单状态");
            r.add(OrderStatusConsts.getStatus(orderMaster.getStatus()));
            // strings.add("结算币种");
            r.add(MoneyTypeConsts.getMoneyType(orderMaster.getMoneyType()));

            //strings.add("业务员");
            r.add(orderMaster.getBusinessBy());
            //strings.add("下单日期");
            r.add(orderMaster.getOrderDate() == null ? "" : transDate(orderMaster.getOrderDate()));

            //strings.add("客户交货日期");
            r.add(orderMaster.getCustomerIssueDate() == null ? "" : transDate(orderMaster.getCustomerIssueDate()));

            //strings.add("验货日期");
            r.add(orderMaster.getCheckDate() == null ? "" : transDate(orderMaster.getCheckDate()));

            //strings.add("工厂交货日期");
            r.add(orderMaster.getFactroyIssueDate() == null ? "" : transDate(orderMaster.getFactroyIssueDate()));

            //strings.add("预收发票编号");
            r.add(orderMaster.getInvoiceIdIni());
            //strings.add("正式发票编号");
            r.add(orderMaster.getInvoiceId());
            //strings.add("备注");
            r.add(orderMaster.getRemark());

            records.add(r);
        }
        return records;
    }

}

