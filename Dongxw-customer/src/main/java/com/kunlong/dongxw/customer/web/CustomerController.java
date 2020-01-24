package com.kunlong.dongxw.customer.web;


import app.support.query.PageResult;
//import com.kunlong.dongxw.annotation.DateRewritable;
import com.kunlong.dongxw.customer.consts.ApiConstants;
import com.kunlong.dongxw.customer.controller.BaseController;
import com.kunlong.dongxw.dongxw.domain.Customer;
import com.kunlong.dongxw.dongxw.service.CustomerService;
import com.kunlong.platform.support.service.AuthService;
import com.kunlong.platform.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.SessionHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * cust类
 * Package:
 * Author: cch/leijiming
 * Date: Created in 2018/8/23 16:50
 */
@RestController
@RequestMapping(ApiConstants.AUTH_API_WEB_CUSTOMER)
public final class CustomerController  extends BaseController {

    @Autowired
    CustomerService customerService;


    @PostMapping("/findById/{id}")
    public JsonResult<Customer> findById() throws IOException {
       return   JsonResult.success(this.getCustomer())    ;
    }


    @PostMapping("/query")
    public PageResult<Customer> query(@RequestBody Customer.QueryParam queryParam) throws IOException {
        if(queryParam.getParam()==null) {
            queryParam.setParam(new Customer());
        }
        queryParam.getParam().setId(this.getCustomer().getId());

        PageResult<Customer> pageResult = new PageResult<Customer>();

        pageResult.setTotal(customerService.countByQueryParam(queryParam));
        if(pageResult.getTotal()>0) {
            pageResult.setData(customerService.findByQueryParam(queryParam));
        }
        return pageResult;
    }





}

