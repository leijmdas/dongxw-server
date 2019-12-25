package com.kunlong.dongxw.controller;


import app.support.query.PageResult;
import com.kunlong.dongxw.annotation.DateRewritable;
import com.kunlong.dongxw.consts.ApiConstants;
import com.kunlong.dongxw.dongxw.domain.Customer;
import com.kunlong.dongxw.dongxw.service.CustomerService;
import com.kunlong.dongxw.util.WebFileUtil;
import com.kunlong.platform.utils.JsonResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * cust类
 * Package:
 * Author: cch/leijiming
 * Date: Created in 2018/8/23 16:50
 */
@Controller
@RequestMapping("/dongxw/export")
public final class DongxwExportController {
    @Autowired
    CustomerService customerService;




    @RequestMapping(value="/customer",method = RequestMethod.POST)
    @ApiOperation(value = "customer", notes = "customer", authorizations = {@Authorization(value = ApiConstants.AUTH_API_WEB)})
    public void exportCustomer(@RequestBody @DateRewritable Customer.QueryParam queryParam, HttpServletRequest req, HttpServletResponse rsp) throws FileNotFoundException, IOException {

        if(queryParam.getParam() == null) {
            queryParam.setParam(new Customer());
        }
        queryParam.setLimit(-1);
        queryParam.setStart(0);

        WebFileUtil web = new WebFileUtil(req,rsp);
        List<Customer> customers = this.customerService.findByQueryParam(queryParam);;
        web.export2EasyExcel2File("客户名单.xlsx", buildTitles(),buildRecords(customers));
        web.export2EasyExcel("客户名单.xlsx", buildTitles(),buildRecords(customers));

    }

    List<String> buildTitles(){
        List<String> strings=new ArrayList<>();
        strings.add("客户主键");
        strings.add("客户编号");
        strings.add("客户名称");
        strings.add("客户详细名称");
        strings.add("客户国家");
        strings.add("客户地址");
        strings.add("结算币种");
        strings.add("联系人");
        strings.add("联系人电话");

        return strings;
    }

    List<List<String>> buildRecords(List<Customer> customers ) {
        List<List<String>> records = new ArrayList<>();
        for (Customer customer : customers) {
            List<String> r = new ArrayList<>();
            r.add(customer.getId()+"");
            r.add(customer.getCustNo());
            r.add(customer.getCustName());
            r.add(customer.getCustSname());
            r.add(customer.getCountry());
            r.add(customer.getAddr());
            r.add(customer.getMoneyType()+"");
            r.add(customer.getContact());

            r.add(customer.getTel());
            //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //r.add(sdf.format(payOrder.getPayTime()));

            records.add(r);
        }
        return records;
    }

}

