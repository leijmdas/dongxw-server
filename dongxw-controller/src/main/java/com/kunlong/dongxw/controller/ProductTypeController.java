package com.kunlong.dongxw.controller;


import app.support.query.PageResult;
import com.kunlong.dongxw.annotation.DateRewritable;
import com.kunlong.dongxw.consts.ApiConstants;
import com.kunlong.dongxw.data.domain.OrderMaster;
import com.kunlong.dongxw.data.domain.Product;
import com.kunlong.dongxw.data.domain.ProductType;
import com.kunlong.dongxw.data.service.ProductService;
import com.kunlong.dongxw.data.service.ProductTypeService;
import com.kunlong.dongxw.util.WebFileUtil;
import com.kunlong.platform.utils.JsonResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
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
@RequestMapping("/dongxw/producttype")
public final class ProductTypeController extends BaseController {
    @Autowired
    ProductTypeService productTypeService;

    @Autowired
    ProductService productService;

    @RequestMapping("/findById/{id}")
    public JsonResult<ProductType> findById(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException {

        return JsonResult.success(productTypeService.findById(id));
    }

    long checkSubType(int parentId) throws IOException {
        ProductType.QueryParam queryParam = new ProductType.QueryParam();
        queryParam.setParam(new ProductType());
        queryParam.getParam().setParentId(parentId);
        long num = productTypeService.countByQueryParam(queryParam);
        return num;
    }

    long checkPrdUseType(int id) throws IOException {
        Product.QueryParam queryParam = new Product.QueryParam();
        queryParam.setParam(new Product());
        queryParam.getParam().setProductTypeId(id);
        queryParam.setLimit(1);
        return productService.countByQueryParam(queryParam);
    }
    long checkPrdUseParentType(int id) throws IOException {
        Product.QueryParam queryParam = new Product.QueryParam();
        queryParam.setParam(new Product());
        queryParam.getParam().setParentId(id);
        queryParam.setLimit(1);
        return productService.countByQueryParam(queryParam);
    }
    @RequestMapping("/deleteById/{id}")
    public JsonResult<String> deleteById(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException {
        if (id != null && id > 0 && checkSubType(id) > 0) {
            return JsonResult.failure("大类有小类不能删除!");
        }
        if (checkPrdUseType(id) > 0) {
            return JsonResult.failure("小类有产品不能删除!");
        }

        if (checkPrdUseParentType(id) > 0) {
            return JsonResult.failure("大类有产品不能删除!");
        }
        productTypeService.deleteById(id);
        return JsonResult.success("ok");
    }

    @RequestMapping("/save")
    public JsonResult<Integer> save(@RequestBody ProductType productType) {
        if (productType.getPrdFlag() == null) {
            productType.setPrdFlag(0);
        }
        //如果是子类型，根据父类添加存货类型
        if(productType.getParentId()>0){
            ProductType pp = productTypeService.findById(productType.getParentId());
            if(pp!=null){
                productType.setPrdFlag(pp.getPrdFlag());
            }
        }
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
        queryParam.setSortBys(queryParam.getOrderBys());
        ProductType p =  buildQueryLikeValue(queryParam.getParam(), ProductType.class);
        queryParam.setParam(p);


        pageResult.setTotal(productTypeService.countByQueryParam(queryParam));
        pageResult.setData(productTypeService.findByQueryParam(queryParam));
        for(ProductType productType:pageResult.getData()){
            if(productType.getParentId()!=null&&productType.getParentId()>0) {
                productType.setpProductType(productTypeService.findById(productType.getParentId()));
            }
        }
        return pageResult;
    }


    @RequestMapping(value="export",method = RequestMethod.POST)
    @ApiOperation(value = "export", notes = "export", authorizations = {@Authorization(value = ApiConstants.AUTH_API_WEB)})
    public void export(@RequestBody @DateRewritable ProductType.QueryParam queryParam, HttpServletRequest req, HttpServletResponse rsp) throws FileNotFoundException, IOException {

        if(queryParam.getParam() == null) {
            queryParam.setParam(new ProductType());
        }
        queryParam.setLimit(-1);
        queryParam.setStart(0);
        queryParam.setSortBys("parentId|asc,id|asc");

        WebFileUtil web = new WebFileUtil(req,rsp);
        List<ProductType> productTypes = productTypeService.findByQueryParam(queryParam);;
        web.export2EasyExcelObject("产品类型.xlsx", buildTitles(),buildRecords(productTypes));

    }

    List<String> buildTitles(){
        List<String> strings=new ArrayList<>();
        strings.add("类型级别");
        strings.add("父类");

        strings.add("类型编码");
        strings.add("类型名称");
        strings.add("描述");

        return strings;
    }

    List<List<Object>> buildRecords(List<ProductType> productTypes) {
        List<List<Object>> records = new ArrayList<>();
        for (ProductType productType : productTypes) {
            List<Object> r = new ArrayList<>();

            r.add(productType.getParentId()==0?"1":"2");
            ProductType p=productTypeService.findById(productType.getParentId());
            r.add(p==null?productType.getParentId():p.getCode());

            r.add(productType.getCode());
            r.add(productType.getName());
            r.add(productType.getRemark());

            records.add(r);
        }
        return records;
    }

    String transDatetime(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(d);
    }

    String transDate(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(d);
    }



}

