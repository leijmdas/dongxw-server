package com.kunlong.dongxw.controller;


import app.support.query.PageResult;

import com.kunlong.dubbo.sys.model.SysUserDTO;
import com.kunlong.dubbo.api.service.AuthApiService;
import com.kunlong.dongxw.annotation.DateRewritable;
import com.kunlong.dongxw.consts.ApiConstants;
import com.kunlong.dongxw.consts.MoneyTypeConsts;
import com.kunlong.dongxw.data.domain.OrderMaster;
import com.kunlong.dongxw.data.service.OrderMasterService;
import com.kunlong.dongxw.util.WebFileUtil;
import com.kunlong.platform.utils.JsonResult;
import com.kunlong.dongxw.data.domain.Customer;
import com.kunlong.dongxw.data.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import com.alibaba.dubbo.config.annotation.Reference;
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

@Api(value = "Customer", description = "Customer")

@RestController
@RequestMapping(ApiConstants.AUTH_API_WEB_DONGXW + "/customer")
public final class CustomerController extends BaseController {
    @Autowired
    CustomerService customerService;
    @Autowired
    OrderMasterService orderMasterService;


    @Reference(lazy = true, version = "${dubbo.service.version}")
    AuthApiService authApiService;

    @ApiOperation(value = "findById", notes = "findById", authorizations = {@Authorization(value = ApiConstants.AUTH_API_WEB)})
    @RequestMapping("/findById/{id}")
    public JsonResult<Customer> findById(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException {
        return JsonResult.success(customerService.findById(id));
    }

    @RequestMapping("/deleteById/{id}")
    public JsonResult<Integer> deleteById(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException {
        OrderMaster.QueryParam queryParam=new OrderMaster.QueryParam();
        queryParam.setParam(new OrderMaster() );
        queryParam.getParam().setCustomerId(id);
        long count=orderMasterService.countByQueryParam(queryParam);
        if(count>0){
            throw new RuntimeException("客户有订单资料，不能删除！");
        }
        customerService.deleteById(id);
        return JsonResult.success();
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
        for(Customer customer:pageResult.getData()){
            SysUserDTO sysUserDTO=findUserById(customer.getCreateBy());
            customer.setCreateByName(sysUserDTO==null?null:sysUserDTO.getUsername());
        }
        //System.err.println(authApiService.checkExists("1111"));
        return pageResult;
    }

    @RequestMapping(value="exportMail",method = RequestMethod.POST)
    @ApiOperation(value = "exportMail", notes = "exportMail", authorizations = {@Authorization(value = ApiConstants.AUTH_API_WEB)})
    public  JsonResult<String> exportMail(@RequestBody @DateRewritable Customer.QueryParam queryParam ) throws IOException {

        if(queryParam.getParam() == null) {
            queryParam.setParam(new Customer());
        }
        queryParam.setLimit(-1);
        queryParam.setStart(0);
        queryParam.setSortBys("custNo|asc");
        WebFileUtil web = new WebFileUtil();
        List<Customer> customers = customerService.findByQueryParam(queryParam);

        File f = web.export2EasyExcelFile("客户名单", buildTitles(), buildRecords(customers));
        mailApiService.sendEmail("leijmdas_s@163.com", "客户名单", "客户名单", f.getPath());
        //System.err.println(f.getPath());
        return JsonResult.success(f.getName());
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
        strings.add("Email");
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
            r.add(customer.getEmail());
            r.add(transDate(customer.getCreateDate()));
            r.add(MoneyTypeConsts.getMoneyType(customer.getMoneyType()));

            records.add(r);
        }
        return records;
    }

}

