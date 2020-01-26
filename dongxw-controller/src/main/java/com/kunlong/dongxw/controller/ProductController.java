package com.kunlong.dongxw.controller;


import app.support.query.PageResult;
import cn.kunlong.center.api.model.SysUserDTO;
import com.kunlong.api.dto.ExportResultDTO;
import com.kunlong.dongxw.annotation.DateRewritable;
import com.kunlong.dongxw.consts.ApiConstants;
import com.kunlong.dongxw.consts.ProductTypeConst;
import com.kunlong.dongxw.dongxw.domain.*;
import com.kunlong.dongxw.dongxw.service.CustomerService;
import com.kunlong.dongxw.dongxw.service.OrderLineService;
import com.kunlong.dongxw.dongxw.service.ProductService;
import com.kunlong.dongxw.dongxw.service.ProductTypeService;
import com.kunlong.dongxw.util.WebFileUtil;
import com.kunlong.platform.utils.JsonResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
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
@RestController
@RequestMapping("/dongxw/product")
public final class ProductController extends BaseController{
    @Autowired
    ProductService productService;

    @Autowired
    ProductTypeService productTypeService;

    @Autowired
    CustomerService customerService;
    @Autowired
    OrderLineService orderLineService;

    @RequestMapping("/findById/{id}")
    public JsonResult<Product> findById(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException {
        JsonResult<Product> result = JsonResult.success(productService.findById(id));
        Product product=result.getData();
        SysUserDTO sysUserDTO = sysUserApiService.findById(product.getCreateBy());

        product.setProductSubType(productTypeService.findById(product.getProductTypeId()));
        product.setProductType(productTypeService.findById(product.getParentId()));
        if(product.getCustomerId()!=null) {
            product.setCustomer(customerService.findById(product.getCustomerId()));
        }
        product.setCreateByName(sysUserDTO != null ? sysUserDTO.getUsername() : "-");
        return result;
    }

    @RequestMapping("/save")
    public JsonResult<Integer> save(@RequestBody Product product) {
        ProductType productType  = productTypeService.findById(product.getProductTypeId()) ;
        if(productType!=null){
            product.setPrdFlag(productType.getPrdFlag().shortValue());
        }
        if (product.getId() == null) {
            product.setCreateBy(getCurrentUserId());
            product.setCreateDate(new Date());

            productService.save(product);
        } else {

            productService.update(product);
        }

        return JsonResult.success(product.getId());
    }

    @PostMapping("/deleteById/{id}")
    public JsonResult<Integer> deleteById(@PathVariable("id") Integer id) throws IOException {
        productService.deleteById(id);
        OrderLine.QueryParam queryParam = new OrderLine.QueryParam();
        queryParam.setParam(new OrderLine());
        queryParam.getParam().setProductId(id);
        queryParam.setLimit(1);
        long count = orderLineService.countByQueryParam(queryParam);
        if (count > 0) {
            throw new RuntimeException("产品已经有订单使用不能删除!");
        }
        //有BOM使用不能使用


        return JsonResult.success();
    }

    @PostMapping("/query")
    public PageResult<Product> query(@RequestBody Product.QueryParam queryParam) throws IOException {
        PageResult<Product> pageResult = new PageResult<>();
        queryParam.setSortBys("id|desc");

        pageResult.setTotal(productService.countByQueryParam(queryParam));
        pageResult.setData(productService.findByQueryParam(queryParam));

        for(Product product : pageResult.getData()){
            product.setProductSubType(productTypeService.findById(product.getProductTypeId()));
            product.setProductType(productTypeService.findById(product.getParentId()));
            if(product.getCustomerId()!=null) {
                product.setCustomer(customerService.findById(product.getCustomerId()));
            }
            SysUserDTO sysUserDTO=sysUserApiService.findById(product.getCreateBy());
            product.setCreateByName(sysUserDTO!=null?sysUserDTO.getUsername():"-");

        }
        return pageResult;
    }


    @RequestMapping(value = "export", method = RequestMethod.POST)
    @ApiOperation(value = "export", notes = "export", authorizations = {@Authorization(value = ApiConstants.AUTH_API_WEB)})
    public void export(@RequestBody @DateRewritable Product.QueryParam queryParam, HttpServletRequest req, HttpServletResponse rsp) throws FileNotFoundException, IOException {

        if (queryParam.getParam() == null) {
            queryParam.setParam(new Product());
        }
        queryParam.getParam().setPrdFlag(ProductTypeConst.PT_PRD.shortValue());
        queryParam.setLimit(-1);
        queryParam.setStart(0);
        queryParam.setSortBys("customerId|asc,code|asc");

        WebFileUtil web = new WebFileUtil(req, rsp);
        List<Product> products = productService.findByQueryParam(queryParam);

        Integer custid = queryParam.getParam().getCustomerId();
        web.export2EasyExcelObject("产品清单.xlsx", buildTitles(), buildRecords(products));

    }

    @RequestMapping(value="exportMail",method = RequestMethod.POST)
    @ApiOperation(value = "exportMail", notes = "exportMail", authorizations = {@Authorization(value = ApiConstants.AUTH_API_WEB)})
    public  JsonResult<ExportResultDTO> exportMail(@RequestBody @DateRewritable Product.QueryParam queryParam ) throws IOException {

        if(queryParam.getParam() == null) {
            queryParam.setParam(new Product());
        }
        queryParam.getParam().setPrdFlag(ProductTypeConst.PT_PRD.shortValue());
        queryParam.setLimit(-1);
        queryParam.setStart(0);
        queryParam.setSortBys("customerId|asc,code|asc");

        WebFileUtil web = new WebFileUtil();
        List<Product> products = productService.findByQueryParam(queryParam);

        File f = web.export2EasyExcelFile("产品清单", buildTitles(), buildRecords(products));
        mailApiService.sendEmail("leijmdas_s@163.com", "产品清单", "产品清单", f.getPath());
        ExportResultDTO exportResultDTO=new ExportResultDTO();
        exportResultDTO.setFilename(f.getName());
        exportResultDTO.setRecordNumber(products.size());
        return JsonResult.success(exportResultDTO);
    }

    @RequestMapping(value = "exportRm", method = RequestMethod.POST)
    @ApiOperation(value = "exportRm", notes = "exportRm", authorizations = {@Authorization(value = ApiConstants.AUTH_API_WEB)})
    public void exportRm(@RequestBody @DateRewritable Product.QueryParam queryParam, HttpServletRequest req, HttpServletResponse rsp) throws FileNotFoundException, IOException {

        if (queryParam.getParam() == null) {
            queryParam.setParam(new Product());
        }
        //queryParam.getParam().setPrdFlag(ProductTypeConst.PT_PRD.shortValue());
        queryParam.setLimit(-1);
        queryParam.setStart(0);
        queryParam.setSortBys("parentId|asc,id|asc");

        WebFileUtil web = new WebFileUtil(req, rsp);
        List<Product> products = productService.findByQueryParam(queryParam);
        web.export2EasyExcelObject("物料清单.xlsx", rmBuildTitles(), rmBuildRecords(products));

    }

    String transDatetime(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(d);
    }

    String transDate(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(d);
    }

    List<String> buildTitles() {
        List<String> strings = new ArrayList<>();
        strings.add("客户名称");
        strings.add("客款号");
        strings.add("EP款号");
        strings.add("产品大类");
        strings.add("产品小类");
        strings.add("产品描述");
        strings.add("颜色");
        strings.add("尺寸");
        strings.add("单位");
        strings.add("条码");
        return strings;
    }

    List<List<Object>> buildRecords(List<Product> orderMasters) {
        List<List<Object>> records = new ArrayList<>();
        for (Product product : orderMasters) {
            List<Object> r = new ArrayList<>();
            Customer customer = customerService.findById(product.getCustomerId());
            r.add(customer == null ? "-" : customer.getCustName());
            r.add(product.getCode());

            r.add(product.getEpCode());

            ProductType productTypeP = productTypeService.findById(product.getParentId());
            r.add(productTypeP == null ? "-" : productTypeP.getCode());

            ProductType productType = productTypeService.findById(product.getProductTypeId());
            r.add(productType == null ? "-" : productType.getCode());
            r.add(product.getRemark());
             //strings.add("颜色");
            r.add(product.getColor());
            //strings.add("尺寸");
            r.add(product.getSize());
            //strings.add("单位");
            r.add(product.getUnit());

            //strings.add("条码");
            r.add(product.getBarCode());

            records.add(r);
        }


        return records;
    }
    List<String> rmBuildTitles() {
        List<String> strings = new ArrayList<>();
        strings.add("存货分类");
        strings.add("物料代号");
        strings.add("物料名称");
        strings.add("大类");
        strings.add("小类");
        strings.add("规格型号");
        strings.add("颜色");
        strings.add("单位");
        strings.add("备注");

//        strings.add("尺寸");
        return strings;
    }

    List<List<Object>> rmBuildRecords(List<Product> orderMasters) {
        List<List<Object>> records = new ArrayList<>();
        for (Product product : orderMasters) {
            List<Object> r = new ArrayList<>();
            // Customer customer = customerService.findById(product.getCustomerId());
            //r.add(customer == null ? "-" : customer.getCustName());
            //r.add(product.getCode());
            ProductType productTypeP = productTypeService.findById(product.getParentId());
            r.add(productTypeP == null ? "-" : ProductTypeConst.getStoreType(productTypeP.getPrdFlag()));

            r.add(product.getCode());
            r.add(product.getName());

            r.add(productTypeP == null ? "-" : productTypeP.getName());

            ProductType productType = productTypeService.findById(product.getProductTypeId());
            r.add(productType == null ? "-" : productType.getName());
            r.add(product.getRemark());
            //strings.add("颜色");
            r.add(product.getColor());
            //strings.add("单位");
            r.add(product.getUnit());
            r.add(product.getRemark());
            //strings.add("尺寸");
            //r.add(product.getSize());


            records.add(r);
        }


        return records;
    }

}

