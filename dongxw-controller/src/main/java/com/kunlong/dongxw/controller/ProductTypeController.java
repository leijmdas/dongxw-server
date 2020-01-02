package com.kunlong.dongxw.controller;


import app.support.query.PageResult;
import com.kunlong.dongxw.consts.MoneyTypeConsts;
import com.kunlong.dongxw.dongxw.domain.Customer;
import com.kunlong.dongxw.dongxw.domain.ProductType;
import com.kunlong.dongxw.dongxw.service.ProductTypeService;
import com.kunlong.platform.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/dongxw/producttype")
public final class ProductTypeController {
    @Autowired
    ProductTypeService productTypeService;
    @RequestMapping("/findById/{id}")
    public JsonResult<ProductType> findById(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException {

        return JsonResult.success(productTypeService.findById(id));
    }

    void checkSubType(int parentId) throws IOException {
        ProductType.QueryParam queryParam = new ProductType.QueryParam();
        queryParam.setParam(new ProductType());
        queryParam.getParam().setParentId(parentId);
        long num = productTypeService.countByQueryParam(queryParam);
        if (num > 0) {
            throw new RuntimeException("大类有小类不能删除!");
        }

    }

    @RequestMapping("/deleteById/{id}")
    public JsonResult<Integer> deleteById(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException {
        checkSubType(id);
        productTypeService.deleteById(id);
        return JsonResult.success();
    }

    @RequestMapping("/save")
    public JsonResult<Integer> save(@RequestBody ProductType productType) {

        if (productType.getId() == null) {
            productTypeService.save(productType);
        } else {
            productTypeService.update(productType);
        }

        return JsonResult.success(productType.getId());
    }



    @RequestMapping("/query")
    public PageResult<ProductType> query(@RequestBody ProductType.QueryParam queryParam) throws IOException {
        PageResult<ProductType> pageResult = new PageResult<ProductType>();
        // Customer.QueryParam qp = BeanMapper.getInstance().map(pageResult, Customer.QueryParam.class);

        pageResult.setTotal(productTypeService.countByQueryParam(queryParam));
        pageResult.setData(productTypeService.findByQueryParam(queryParam));
        return pageResult;
    }


//    @RequestMapping(value="export",method = RequestMethod.POST)
//    @ApiOperation(value = "export", notes = "export", authorizations = {@Authorization(value = ApiConstants.AUTH_API_WEB)})
//    public void exportCustomer(@RequestBody @DateRewritable Customer.QueryParam queryParam, HttpServletRequest req, HttpServletResponse rsp) throws FileNotFoundException, IOException {
//
//        if(queryParam.getParam() == null) {
//            queryParam.setParam(new Customer());
//        }
//        queryParam.setLimit(-1);
//        queryParam.setStart(0);
//
//        WebFileUtil web = new WebFileUtil(req,rsp);
//        List<Customer> customers = this.customerService.findByQueryParam(queryParam);;
//        //web.export2EasyExcel2File("客户名单.xlsx", buildTitles(),buildRecords(customers));
//        web.export2EasyExcelObject("客户名单.xlsx", buildTitles(),buildRecords(customers));
//        //rsp.getOutputStream().write("123".getBytes());
//        //rsp.getOutputStream().flush();
//    }

    List<String> buildTitles(){
        List<String> strings=new ArrayList<>();
        strings.add("客户编号");
        strings.add("客户名称");
        strings.add("客户详细名称");
        strings.add("客户国家");
        strings.add("客户地址");
        strings.add("结算币种");
        strings.add("联系人");
        strings.add("联系人电话");
        strings.add("建档日期");

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

            r.add(customer.getCustNo());
            r.add(customer.getCustName());
            r.add(customer.getCustSname());
            r.add(customer.getCountry());
            r.add(customer.getAddr());
            r.add(MoneyTypeConsts.getMoneyType(customer.getMoneyType()));
            r.add(customer.getContact());

            r.add(customer.getTel());
            r.add(transDate(customer.getCreateDate()));

            records.add(r);
        }
        return records;
    }

}

