package com.kunlong.dongxw.controller;


import app.support.query.PageResult;
import com.kunlong.api.service.AuthApiService;
import com.kunlong.dongxw.annotation.DateRewritable;
import com.kunlong.dongxw.consts.ApiConstants;
import com.kunlong.dongxw.consts.MoneyTypeConsts;
import com.kunlong.dongxw.util.WebFileUtil;
import com.kunlong.platform.utils.JsonResult;
import com.kunlong.dongxw.dongxw.domain.Customer;
import com.kunlong.dongxw.dongxw.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import io.swagger.models.auth.In;
import org.apache.dubbo.config.annotation.Reference;
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
@RequestMapping(ApiConstants.AUTH_API_WEB_DONGXW+"/customer")
public final class CustomerController extends BaseController{
    @Autowired
    CustomerService customerService;

     @Reference(lazy = true, version = "${dubbo.service.version}")
     AuthApiService authApiService;

    @RequestMapping("/findById/{id}")
    public JsonResult<Customer> findById(@PathVariable("id") Integer id,HttpServletResponse response) throws IOException {
       return   JsonResult.success(customerService.findById(id))    ;
    }
    @RequestMapping("/deleteById/{id}")
    public JsonResult<Integer> deleteById(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException {
        customerService.deleteById(id);
        return   JsonResult.success()    ;
    }

    @RequestMapping("/save")
    public JsonResult<Integer> save(@RequestBody Customer customer) {

        if (customer.getId() == null) {
            customer.setCreateBy(getCurrentUserId());
            customer.setCreateDate(new Date());
            customerService.save(customer);
        } else {
            customerService.update(customer);
        }

        return JsonResult.success(customer.getId());
    }


    @RequestMapping("/query")
    public PageResult<Customer> query(@RequestBody Customer.QueryParam queryParam) throws IOException {
        PageResult<Customer> pageResult = new PageResult<Customer>();
        // Customer.QueryParam qp = BeanMapper.getInstance().map(pageResult, Customer.QueryParam.class);

        pageResult.setTotal(customerService.countByQueryParam(queryParam));
        pageResult.setData(customerService.findByQueryParam(queryParam));
        //System.err.println(authApiService.checkExists("1111"));
        return pageResult;
    }


    @RequestMapping(value="export",method = RequestMethod.POST)
    @ApiOperation(value = "export", notes = "export", authorizations = {@Authorization(value = ApiConstants.AUTH_API_WEB)})
    public void exportCustomer(@RequestBody @DateRewritable Customer.QueryParam queryParam, HttpServletRequest req, HttpServletResponse rsp) throws FileNotFoundException, IOException {

        if(queryParam.getParam() == null) {
            queryParam.setParam(new Customer());
        }
        queryParam.setLimit(-1);
        queryParam.setStart(0);

        WebFileUtil web = new WebFileUtil(req,rsp);
        List<Customer> customers = this.customerService.findByQueryParam(queryParam);;
        //web.export2EasyExcel2File("客户名单.xlsx", buildTitles(),buildRecords(customers));
        web.export2EasyExcelObject("客户名单.xlsx", buildTitles(),buildRecords(customers));
        //rsp.getOutputStream().write("123".getBytes());
        //rsp.getOutputStream().flush();
    }

    List<String> buildTitles(){
        List<String> strings=new ArrayList<>();
        //strings.add("客户主键");
        strings.add("客户编码");
        strings.add("客户名称");
        strings.add("客户详细名称");
        strings.add("客户国家");
        strings.add("客户地址");
        strings.add("联系人");
        strings.add("联系人电话");
        strings.add("传真");
        strings.add("建档日期");
        strings.add("结算币种");

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

    List<List<Object>> buildRecords(List<Customer> customers) {
        List<List<Object>> records = new ArrayList<>();
        for (Customer customer : customers) {
            List<Object> r = new ArrayList<>();
            //r.add(customer.getId());
            r.add(customer.getCustNo());
            r.add(customer.getCustName());
            r.add(customer.getCustSname());
            r.add(customer.getCountry());
            r.add(customer.getAddr());
            r.add(customer.getContact());

            r.add(customer.getTel());
            r.add(customer.getFax());
            r.add(transDate(customer.getCreateDate()));
            r.add(MoneyTypeConsts.getMoneyType(customer.getMoneyType()));

            records.add(r);
        }
        return records;
    }

}

