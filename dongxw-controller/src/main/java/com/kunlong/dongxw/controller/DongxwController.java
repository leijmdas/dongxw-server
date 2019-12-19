package com.kunlong.dongxw.controller;


import com.kunlong.platform.utils.JsonResult;
import com.kunlong.dongxw.dongxw.domain.Customer;
import com.kunlong.dongxw.dongxw.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * cust类
 * Package:
 * Author: cch/leijiming
 * Date: Created in 2018/8/23 16:50
 */
@RestController
@RequestMapping("/dongxw/customer")
public final class DongxwController     {
    @Autowired
    CustomerService customerService;



    @RequestMapping("/findById/{id}")
    public JsonResult<Customer> findById(@PathVariable("id") Integer id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        return   JsonResult.success(customerService.findById(id))    ;
    }



}

