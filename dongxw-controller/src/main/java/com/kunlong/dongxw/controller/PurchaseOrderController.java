package com.kunlong.dongxw.controller;


import app.support.query.PageResult;
import com.kunlong.dongxw.annotation.DateRewritable;
import com.kunlong.dongxw.config.DongxwTransactional;
import com.kunlong.dongxw.consts.ApiConstants;
import com.kunlong.dongxw.consts.MakePlanConst;
import com.kunlong.dongxw.data.domain.*;
import com.kunlong.dongxw.data.service.*;
import com.kunlong.dongxw.util.WebFileUtil;
import com.kunlong.dubbo.sys.model.SysUserDTO;
import com.kunlong.platform.utils.JsonResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
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
@RequestMapping("/dongxw/purchaseorder")
public  class PurchaseOrderController extends BaseController {


    @Autowired
    SupplierService supplierService;

    @Autowired
    OrderMasterService orderMasterService;

    @Autowired
    OrderLineService orderLineService;
    @Autowired
    ProductService productService;

    @Autowired
    ProductTypeService productTypeService;

    @Autowired
    PurchaseOrderService purchaseOrderService;



    /**检查有计划*/
    @PostMapping("/deleteById/{id}")
    public JsonResult<Integer> deleteById(@PathVariable("id") Integer id) throws IOException {

        purchaseOrderService.deleteById(id);


        return JsonResult.success();
    }

    @RequestMapping("/findById/{id}")
    public JsonResult<PurchaseOrder> findById(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException {
        PurchaseOrder purchaseOrder = purchaseOrderService.findById(id);
        //fillMakePlan(makeSheet);
        return JsonResult.success(purchaseOrder);

    }

    @RequestMapping("/save")
    public JsonResult<Integer> save(@RequestBody PurchaseOrder purchaseOrder) {
        purchaseOrder.setCreateBy(this.getCurrentUserId());

        if (purchaseOrder.getId() == null) {
            purchaseOrderService.save(purchaseOrder);
        } else {
            purchaseOrderService.update(purchaseOrder);
        }

        return JsonResult.success(purchaseOrder.getId());
    }


    @PostMapping("/query")
    public PageResult<PurchaseOrder> query(@RequestBody PurchaseOrder.QueryParam queryParam) throws IOException {
        PageResult<PurchaseOrder> pageResult = new PageResult<>();

        queryParam.setSortBys("id|desc");
        pageResult.setTotal(purchaseOrderService.countByQueryParam(queryParam));
        pageResult.setData(purchaseOrderService.findByQueryParam(queryParam));
        for (PurchaseOrder order : pageResult.getData()) {
            SysUserDTO sysUserDTO = sysUserApiService.findById(order.getCreateBy());
            order.setCreateByName(sysUserDTO == null ? "-" : sysUserDTO.getUsername());

            Supplier supplier=supplierService.findById(order.getSupplyId());
            order.setSupplierName(supplier == null ? "-" : supplier.getName());

            order.setOrderMaster(orderMasterService.findById(order.getOrderId()));
        }
        return pageResult;
    }


    @RequestMapping(value="export",method = RequestMethod.POST)
    @ApiOperation(value = "export", notes = "export", authorizations = {@Authorization(value = ApiConstants.AUTH_API_WEB)})
    public void export(@RequestBody @DateRewritable MakePlan.QueryParam queryParam, HttpServletRequest req, HttpServletResponse rsp) throws FileNotFoundException, IOException {

        if(queryParam.getParam() == null) {
            queryParam.setParam(new MakePlan());
        }
        queryParam.setLimit(3000);
        queryParam.setStart(0);
        queryParam.setSortBys("customerId|asc,orderId|asc");

        WebFileUtil web = new WebFileUtil(req,rsp);
//        List<MakePlan> makePlans = this.makePlanService.findByQueryParam(queryParam);
//        fillMakePlans(makePlans);
//        rsp.setHeader("file",URLEncoder.encode(  "生产计划表.xlsx","UTF-8"));
//
//        web.export2EasyExcelObject("生产计划表.xlsx", buildTitles(),buildRecords(makePlans));

    }



}

