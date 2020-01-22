package com.kunlong.dongxw.controller;


import app.support.query.PageResult;
import cn.kunlong.center.api.model.SysUserDTO;
import com.kunlong.dongxw.annotation.DateRewritable;
import com.kunlong.dongxw.consts.ApiConstants;
import com.kunlong.dongxw.dongxw.domain.Customer;
import com.kunlong.dongxw.dongxw.domain.OrderLine;
import com.kunlong.dongxw.dongxw.domain.Product;
import com.kunlong.dongxw.dongxw.domain.ProductType;
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
        SysUserDTO sysUserDTO = sysUserApiService.findById(result.getData().getCreateBy());

        result.getData().setCreateByName(sysUserDTO != null ? sysUserDTO.getUsername() : "-");
        return result;
    }

    @RequestMapping("/save")
    public JsonResult<Integer> save(@RequestBody Product product) {

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

    @PostMapping("/query")
    public PageResult<Product> query(@RequestBody Product.QueryParam queryParam) throws IOException {
        PageResult<Product> pageResult = new PageResult<>();

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


    @RequestMapping(value="export",method = RequestMethod.POST)
    @ApiOperation(value = "export", notes = "export", authorizations = {@Authorization(value = ApiConstants.AUTH_API_WEB)})
    public void export(@RequestBody @DateRewritable Product.QueryParam queryParam, HttpServletRequest req, HttpServletResponse rsp) throws FileNotFoundException, IOException {

        if(queryParam.getParam() == null) {
            queryParam.setParam(new Product());
        }
        queryParam.setLimit(-1);
        queryParam.setStart(0);

        WebFileUtil web = new WebFileUtil(req,rsp);
        List<Product> products = productService.findByQueryParam(queryParam);;
        web.export2EasyExcelObject("产品列表.xlsx", buildTitles(),buildRecords(products));

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

    List<String> buildTitles() {
        List<String> strings = new ArrayList<>();
        strings.add("客户名称");

        strings.add("EP款号");
        strings.add("客款码");
        strings.add("产品大类");
        strings.add("产品小类");
        strings.add("产品描述");
        strings.add("单位");
        strings.add("颜色");
        strings.add("尺寸");
        strings.add("条码");


        return strings;
    }

    List<List<Object>> buildRecords(List<Product> orderMasters) {
        List<List<Object>> records = new ArrayList<>();
        for (Product product : orderMasters) {
            List<Object> r = new ArrayList<>();
            Customer customer = customerService.findById(product.getCustomerId());
            r.add(customer == null ? "-" : customer.getCustName());

            r.add(product.getEpCode());
            r.add(product.getCode());

            ProductType productTypeP = productTypeService.findById(product.getParentId());
            r.add(productTypeP == null ? "-" : productTypeP.getCode());

            ProductType productType = productTypeService.findById(product.getProductTypeId());
            r.add(productType == null ? "-" : productType.getCode());
            r.add(product.getRemark());
            //strings.add("单位");
            r.add(product.getUnit());
            //strings.add("颜色");
            r.add(product.getColor());
            //strings.add("尺寸");
            r.add(product.getSize());

            //strings.add("条码");
            r.add(product.getBarCode());

            records.add(r);
        }


        return records;
    }

}

