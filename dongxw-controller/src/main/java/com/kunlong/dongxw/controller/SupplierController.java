package com.kunlong.dongxw.controller;


import app.support.query.PageResult;
import com.kunlong.api.service.AuthApiService;
import com.kunlong.dongxw.annotation.DateRewritable;
import com.kunlong.dongxw.consts.ApiConstants;
import com.kunlong.dongxw.consts.MoneyTypeConsts;
import com.kunlong.dongxw.dongxw.domain.Supplier;
import com.kunlong.dongxw.dongxw.service.SupplierService;
import com.kunlong.dongxw.util.WebFileUtil;
import com.kunlong.platform.utils.JsonResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
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
 * supplier
 * Package:
 * Author: cch/leijiming
 * Date: Created in 2019/8/23 16:50
 */
@RestController
@RequestMapping(ApiConstants.AUTH_API_WEB_DONGXW+"/supplier")
public final class SupplierController {
    @Autowired
    SupplierService supplierService;

     @Reference(lazy = true, version = "${dubbo.service.version}")
     AuthApiService authApiService;

    @RequestMapping("/findById/{id}")
    public JsonResult<Supplier> findById(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException {
     return   JsonResult.success(supplierService.findById(id))    ;
    }

    @RequestMapping("/save")
    public JsonResult<Integer> save(@RequestBody Supplier supplier) {

        if (supplier.getId() == null) {
            supplierService.save(supplier);
        } else {
            supplierService.update(supplier);
        }

        return JsonResult.success(supplier.getId());
    }


    @RequestMapping("/query")
    public PageResult<Supplier> query(@RequestBody Supplier.QueryParam queryParam) throws IOException {
        PageResult<Supplier> pageResult = new PageResult<Supplier>();
        // Customer.QueryParam qp = BeanMapper.getInstance().map(pageResult, Customer.QueryParam.class);

        pageResult.setTotal(supplierService.countByQueryParam(queryParam));
        pageResult.setData(supplierService.findByQueryParam(queryParam));
        //System.err.println(authApiService.checkExists("1111"));
        return pageResult;
    }

    @PostMapping("/deleteById/{id}")
    public JsonResult<Integer> deleteById(@PathVariable("id") Integer id) throws IOException {
        supplierService.deleteById(id) ;

//        Product product=productService.findById(id);
//        if(product!=null){
//            if(product.getStatus().compareTo(OrderConsts.ORDER_STATUS_DRAFT)>0){
//                throw new RuntimeException("非草稿不能删除！");
//            }else{
//                productService.deleteById(id) ;
//            }
//
//        }

        return JsonResult.success();
    }
    @RequestMapping(value="export",method = RequestMethod.POST)
    @ApiOperation(value = "export", notes = "export", authorizations = {@Authorization(value = ApiConstants.AUTH_API_WEB)})
    public void export(@RequestBody @DateRewritable Supplier.QueryParam queryParam, HttpServletRequest req, HttpServletResponse rsp) throws FileNotFoundException, IOException {

        if(queryParam.getParam() == null) {
            queryParam.setParam(new Supplier());
        }
        queryParam.setLimit(-1);
        queryParam.setStart(0);

        WebFileUtil web = new WebFileUtil(req,rsp);
        List<Supplier> suppliers = this.supplierService.findByQueryParam(queryParam);;
        //web.export2EasyExcel2File("客户名单.xlsx", buildTitles(),buildRecords(customers));
        web.export2EasyExcelObject("供应商名单.xlsx", buildTitles(),buildRecords(suppliers));

    }

    List<String> buildTitles(){
        List<String> strings=new ArrayList<>();
        strings.add("编号");
        strings.add("名称");
        strings.add("详细名称");
        strings.add("国家");
        strings.add("地址");
        strings.add("结算币种");
        strings.add("联系人");
        strings.add("联系人电话");
        strings.add("建档日期");

        return strings;
    }

    String transDatetime(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(d);
    }

    String transDate(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(d);
    }

    List<List<Object>> buildRecords(List<Supplier> suppliers) {
        List<List<Object>> records = new ArrayList<>();
        for (Supplier supplier : suppliers) {
            List<Object> r = new ArrayList<>();
            //r.add(customer.getId());
            r.add(supplier.getCode());
            r.add(supplier.getName());
            r.add(supplier.getSname());
            r.add(supplier.getCountry());
            r.add(supplier.getAddr());
            r.add(MoneyTypeConsts.getMoneyType(Integer.valueOf(supplier.getMoneyType())));
            r.add(supplier.getContact());

            r.add(supplier.getTel());
            r.add(transDate(supplier.getCreateDate()));

            records.add(r);
        }
        return records;
    }

}

