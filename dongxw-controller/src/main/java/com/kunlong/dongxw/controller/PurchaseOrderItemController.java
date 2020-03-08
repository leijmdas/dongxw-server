package com.kunlong.dongxw.controller;


import app.support.query.PageResult;
import com.kunlong.dongxw.annotation.DateRewritable;
import com.kunlong.dongxw.config.DongxwTransactional;
import com.kunlong.dongxw.consts.ApiConstants;
import com.kunlong.dongxw.data.domain.MakePlan;
import com.kunlong.dongxw.data.domain.OrderLine;
import com.kunlong.dongxw.data.domain.PurchaseOrderItem;
import com.kunlong.dongxw.data.service.*;
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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * cust类
 * Package:
 * Author: cch/leijiming
 * Date: Created in 2020/3/7 22:50
 */
@RestController
@RequestMapping("/dongxw/purchaseorderitem")
public  class PurchaseOrderItemController extends BaseController {

    @Autowired
    MakePlanService makePlanService;
    @Autowired
    OrderLineService orderLineService;

    @Autowired
    PurchaseOrderService purchaseOrderService;

    @Autowired
    PurchaseOrderItemService purchaseOrderItemService;

    @Autowired
    ProductService productService;


    /**检查有计划*/
    @PostMapping("/deleteById/{id}")
    public JsonResult<Integer> deleteById(@PathVariable("id") Integer id) throws IOException {

        purchaseOrderItemService.deleteById(id);


        return JsonResult.success();
    }

    @RequestMapping("/findById/{id}")
    public JsonResult<PurchaseOrderItem> findById(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException {
        PurchaseOrderItem purchaseOrder = purchaseOrderItemService.findById(id);
        //fillMakePlan(makeSheet);
        return JsonResult.success(purchaseOrder);

    }

    @RequestMapping("/saveMulti")
    @DongxwTransactional
    public JsonResult<List<Integer>> saveMulti(@RequestBody PurchaseOrderItem purchaseOrderItem) {
        PurchaseOrderItem orderItem = new PurchaseOrderItem();
        orderItem.setCreateBy(this.getCurrentUserId());
        orderItem.setCreateDate(new Date());
        orderItem.setRemark(" ");
        orderItem.setPurchaseOrderId(purchaseOrderItem.getPurchaseOrderId());

        String[] makePlanIds = purchaseOrderItem.getMakePlanIds().trim().split(",");
        List<Integer> list = new ArrayList<>();
        for (String smakePlanId : makePlanIds) {
            Integer  makePlanId=Integer.valueOf(smakePlanId.trim());
            orderItem.setMakePlanId(makePlanId);
            orderItem.setId(null);
            MakePlan makePlan = makePlanService.findById(makePlanId);
            if (makePlan != null) {
                orderItem.setOrderLineId(makePlan.getOrderLineId());
                OrderLine orderLine = orderLineService.findById(orderItem.getOrderLineId());
                if(orderLine!=null) {
                    orderItem.setQty(BigDecimal.valueOf(orderLine.getQty()));
                    orderItem.setPrice(orderLine.getPrice());
                    orderItem.setMoney(orderLine.getMoney());
                    orderItem.setProductId(orderLine.getProductId());
                    purchaseOrderItemService.save(orderItem);
                    list.add(orderItem.getId());
                }
            }

        }


        return JsonResult.success(list);
    }

    @RequestMapping("/save")
    public JsonResult<Integer> save(@RequestBody PurchaseOrderItem purchaseOrder) {
        purchaseOrder.setCreateBy(this.getCurrentUserId());

        if (purchaseOrder.getId() == null) {
            purchaseOrderItemService.save(purchaseOrder);
        } else {
            purchaseOrderItemService.update(purchaseOrder);
        }

        return JsonResult.success(purchaseOrder.getId());
    }


    @PostMapping("/query")
    public PageResult<PurchaseOrderItem> query(@RequestBody PurchaseOrderItem.QueryParam queryParam) throws IOException {
        PageResult<PurchaseOrderItem> pageResult = new PageResult<>();

        queryParam.setSortBys("id|desc");
        pageResult.setTotal(purchaseOrderItemService.countByQueryParam(queryParam));
        pageResult.setData(purchaseOrderItemService.findByQueryParam(queryParam));
        for (PurchaseOrderItem order : pageResult.getData()) {
            SysUserDTO sysUserDTO = sysUserApiService.findById(order.getCreateBy());
            order.setCreateByName(sysUserDTO == null ? "-" : sysUserDTO.getUsername());
            order.setProduct(productService.findById(order.getProductId()));

        }
        return pageResult;
    }


    @RequestMapping(value="export",method = RequestMethod.POST)
    @ApiOperation(value = "export", notes = "export", authorizations = {@Authorization(value = ApiConstants.AUTH_API_WEB)})
    public void export(@RequestBody @DateRewritable MakePlan.QueryParam queryParam, HttpServletRequest req, HttpServletResponse rsp) throws FileNotFoundException, IOException {



    }



}

