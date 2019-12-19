package com.kunlong.dongxw.controller;


import com.kunlong.dongxw.dongxw.domain.Customer;
import com.kunlong.dongxw.dongxw.service.CustomerService;
import com.kunlong.dongxw.manager.domain.DictDatatype;
import com.kunlong.dongxw.manager.service.DictDatatypeService;
import com.kunlong.platform.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/dongxw/manager")
public final class ManagerController {
    @Autowired
    DictDatatypeService dictDatatypeService;


    @RequestMapping("/findById/{id}")
    public JsonResult<DictDatatype> findById(@PathVariable("id") Integer id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        return   JsonResult.success(dictDatatypeService.findById(id))    ;
    }



}

