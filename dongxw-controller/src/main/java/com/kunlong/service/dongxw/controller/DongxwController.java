package com.kunlong.service.dongxw.controller;


import com.kunlong.platform.utils.JsonResult;
import com.kunlong.service.dongxw.domain.Customer;
import com.kunlong.service.dongxw.service.CustomerService;
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
@RequestMapping("/dongxw")
public final class DongxwController     {
    @Autowired
    CustomerService customerService;



    @RequestMapping("/customer/findById/{id}")
    public JsonResult<Customer> findById(@PathVariable("id") Integer id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        return   JsonResult.success(customerService.findById(id))    ;
    }



}

