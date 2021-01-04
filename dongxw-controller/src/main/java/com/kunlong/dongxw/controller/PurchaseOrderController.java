package com.kunlong.dongxw.controller;


import app.support.query.PageResult;
import cn.afterturn.easypoi.entity.ImageEntity;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.kunlong.dongxw.annotation.DateRewritable;
import com.kunlong.dongxw.config.DongxwTransactional;
import com.kunlong.dongxw.consts.ApiConstants;
import com.kunlong.dongxw.consts.MoneyTypeConsts;
import com.kunlong.dongxw.data.domain.*;
import com.kunlong.dongxw.data.service.*;
import com.kunlong.dongxw.util.ConvertUpMoney;
import com.kunlong.dongxw.util.EasyExcelUtil;
import com.kunlong.dongxw.util.EasyPOIUtil;
import com.kunlong.dubbo.rpt.EasyPOIUtilApiService;
import com.kunlong.dubbo.sys.model.SysUserDTO;
import com.kunlong.platform.model.KunlongModel;
import com.kunlong.platform.utils.JsonResult;
import com.kunlong.platform.utils.KunlongUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * cust类
 * Package:
 * Author: cch/leijiming
 * Date: Created in 2018/8/23 16:50
 */
@RestController
@RequestMapping("/dongxw/purchaseorder")
public  class PurchaseOrderController extends BaseController {
    @Reference(lazy = true, version = "${dubbo.service.version}")
    EasyPOIUtilApiService easyPOIUtilApiService;

    @Autowired
    PoDaySeqService poDaySeqService;

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

    @Autowired
    PurchaseOrderItemService purchaseOrderItemService;


    /**检查有计划*/
    @PostMapping("/deleteById/{id}")
    public JsonResult<Integer> deleteById(@PathVariable("id") Integer id) throws IOException {
        PurchaseOrderItem.QueryParam queryParam=new PurchaseOrderItem.QueryParam();
        queryParam.setParam(new PurchaseOrderItem());
        queryParam.getParam().setPurchaseOrderId(id);
        if(purchaseOrderItemService.countByQueryParam(queryParam)>0){
            return JsonResult.failure(-1,"采购单有产品清单，不能直接删除！先删除产品清单！");
        }

        purchaseOrderService.deleteById(id);
        return JsonResult.success();
    }

    @RequestMapping("/findById/{id}")
    public JsonResult<PurchaseOrder> findById(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException {
        PurchaseOrder purchaseOrder = purchaseOrderService.findById(id);
        Supplier supplier = supplierService.findById(purchaseOrder.getSupplyId());
        if(supplier==null){
            supplier=new Supplier();
        }
        purchaseOrder.setSupplierName(supplier == null ? "-" : supplier.getName());
        purchaseOrder.setSupplier(supplier);
        //fillMakePlan(makeSheet);
        SysUserDTO sysUserDTO = sysUserApiService.findById(purchaseOrder.getCreateBy());
        purchaseOrder.setCreateByName(sysUserDTO == null ? "-" : sysUserDTO.getUsername());
        return JsonResult.success(purchaseOrder);

    }

    Integer buildSeq(PurchaseOrder purchaseOrder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String ymd = sdf.format(new Date());
        PoDaySeq poDaySeq = poDaySeqService.findById(Integer.valueOf(ymd));
        if (poDaySeq == null) {
            poDaySeq = new PoDaySeq();
            poDaySeq.setId(Integer.valueOf(ymd));
            poDaySeq.setYmd(Integer.valueOf(ymd));
            poDaySeq.setOutSeq(0);
            poDaySeq.setPoSeq(0);
            if (purchaseOrder.getPrdFlg() == 0) {
                poDaySeq.setOutSeq(1);
            } else {
                poDaySeq.setPoSeq(1);
            }
            poDaySeqService.save(poDaySeq);
            return 10001;
        }else{
            if (purchaseOrder.getPrdFlg() == 0) {
                poDaySeq.setOutSeq(poDaySeq.getOutSeq()+1);
            } else {
                poDaySeq.setPoSeq(poDaySeq.getPoSeq()+1);
            }
            poDaySeqService.update(poDaySeq);

        }

        if (purchaseOrder.getPrdFlg() == 0) {
            return poDaySeq.getOutSeq()+10000;
        }
        return poDaySeq.getPoSeq()+10000;

    }

    String buildPCode(PurchaseOrder purchaseOrder) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String ymd = sdf.format(new Date());
        String code = purchaseOrder.getPrdFlg() == 0 ? "EPP-" : "EP-";


        String seq = buildSeq(purchaseOrder) + "";

        return code + ymd + "-" + seq.substring(2, 5);


    }

    @RequestMapping("/save")
    @DongxwTransactional
    public JsonResult<Integer> save(@RequestBody PurchaseOrder purchaseOrder) {
        purchaseOrder.setCreateBy(this.getCurrentUserId());

        if (purchaseOrder.getId() == null) {
            purchaseOrder.setPurchaseOrderCode(buildPCode(purchaseOrder));
            purchaseOrderService.save(purchaseOrder);
        } else {
            purchaseOrderService.update(purchaseOrder);
        }

        return JsonResult.success(purchaseOrder.getId());
    }


    @PostMapping("/query")
    public PageResult<PurchaseOrder> query(@RequestBody PurchaseOrder.QueryParam queryParam) throws IOException {
        PageResult<PurchaseOrder> pageResult = new PageResult<>();
        PurchaseOrder p =  buildQueryLikeValue(queryParam.getParam(), PurchaseOrder.class);
        queryParam.setParam(p);

        queryParam.setSortBys("id|desc");
        pageResult.setTotal(purchaseOrderService.countByQueryParam(queryParam));
        pageResult.setData(purchaseOrderService.findByQueryParam(queryParam));
        for (PurchaseOrder order : pageResult.getData()) {
            SysUserDTO sysUserDTO = sysUserApiService.findById(order.getCreateBy());
            order.setCreateByName(sysUserDTO == null ? "-" : sysUserDTO.getUsername());

            Supplier supplier = supplierService.findById(order.getSupplyId());
            if(supplier==null){
                supplier=new Supplier();
            }
            order.setSupplierName(supplier == null ? "-" : supplier.getName());
            order.setSupplier(supplier);
            order.setOrderMaster(orderMasterService.findById(order.getOrderId()));

        }
        return pageResult;
    }

    String writePlan2File(String sheetName, PurchaseOrder purchaseOrder, String fileName) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("contact",purchaseOrder.getContact());
        map.put("tel",purchaseOrder.getTel());
        map.put("moneyType", MoneyTypeConsts.getMoneyType(purchaseOrder.getMoneyType()));
        map.put("openDate",KunlongUtils.transDate(purchaseOrder.getOpenDate()));
        map.put("issueDate",KunlongUtils.transDate(purchaseOrder.getIssueDate()));
        map.put("pkgRemark",purchaseOrder.getRemark());
        map.put("poCode",purchaseOrder.getPurchaseOrderCode());
        OrderMaster orderMaster=orderMasterService.findById(purchaseOrder.getOrderId());
        if (orderMaster != null) {
            sheetName = sheetName + orderMaster.getCustomerOrderCode();
            map.put("orderCode", orderMaster.getEpOrderCode() + "(" + orderMaster.getCustomerOrderCode() + ")");
        }
        Supplier supplier = supplierService.findById(purchaseOrder.getSupplyId());
        if (supplier != null) {
            map.put("supplyName", supplier.getName());
            map.put("supplyAddress", supplier.getAddr());
            map.put("supplyContact", supplier.getContact());
            map.put("supplyTel", supplier.getTel());

        }


        List<Map<String, Object>> mapList = new ArrayList<>();

        for (PurchaseOrderItem orderItem : purchaseOrder.getOrderItems()) {
            Map<String, Object> row = new LinkedHashMap<>();
            Product product=productService.findById(orderItem.getProductId());
            if(product!=null) {
                row.put("epCode", product.getEpCode());
                row.put("barCode", product.getBarCode());
                row.put("productRemark", product.getRemark());
                row.put("unit", product.getUnit());

                if (product.getPicUrl() != null && !product.getPicUrl().trim().isEmpty()) {
                    //ImageEntity image = new ImageEntity();
                    //image.setHeight(100);
                    //image.setWidth(120);
                    //image.setUrl("l:/3.png");
                    byte[] img = download(product.getPicUrl().trim());
                    ImageEntity image = new ImageEntity(img, 120, 100);
                    row.put("pic", image);
                }
            }
            row.put("qty", orderItem.getQty());
            row.put("price", orderItem.getPrice());
            row.put("money", orderItem.getMoney());
            row.put("remark", orderItem.getRemark());

            mapList.add(row);
        }
        map.put("list", mapList);

        return EasyPOIUtil.makeExcelSheet("pp_order_template.xlsx",fileName,sheetName,map);
    }

    //外发采购单
    @RequestMapping(value="export",method = RequestMethod.POST)
    @ApiOperation(value = "export", notes = "export", authorizations = {@Authorization(value = ApiConstants.AUTH_API_WEB)})
    public JsonResult<Integer> export(@RequestBody @DateRewritable PurchaseOrder.QueryParam queryParam, HttpServletRequest req, HttpServletResponse rsp) throws Exception {


        PurchaseOrder purchaseOrder = purchaseOrderService.findById(queryParam.getParam().getId());
        if(purchaseOrder==null){
            return JsonResult.failure(-1,"无外发采购订单！");
        }
        PurchaseOrderItem.QueryParam param = new PurchaseOrderItem.QueryParam();
        param.setParam(new PurchaseOrderItem());
        param.getParam().setPurchaseOrderId(queryParam.getParam().getId());
        param.setLimit(-1);
        List<PurchaseOrderItem> orderItems = purchaseOrderItemService.findByQueryParam(param);
        purchaseOrder.setOrderItems(orderItems);

        String fnNew = writePlan2File("外发采购订单", purchaseOrder, "外发采购订单.xlsx");
        OrderMaster orderMaster=orderMasterService.findById(purchaseOrder.getOrderId());

        EasyExcelUtil.writeExcel2Response("外发采购订单"+orderMaster.getEpOrderCode()+".xlsx", rsp, fnNew);
        return JsonResult.success();
    }


    //物料采购单
    @RequestMapping(value="exportRm",method = RequestMethod.POST)
    @ApiOperation(value = "exportRm", notes = "exportRm", authorizations = {@Authorization(value = ApiConstants.AUTH_API_WEB)})
    public JsonResult<Integer> exportRm(@RequestBody @DateRewritable PurchaseOrder.QueryParam queryParam, HttpServletRequest req, HttpServletResponse rsp) throws Exception {


        PurchaseOrder purchaseOrder = purchaseOrderService.findById(queryParam.getParam().getId());
        if(purchaseOrder==null){
            return JsonResult.failure(-1,"无物料采购订单！");
        }
        PurchaseOrderItem.QueryParam param = new PurchaseOrderItem.QueryParam();
        param.setParam(new PurchaseOrderItem());
        param.getParam().setPurchaseOrderId(queryParam.getParam().getId());
        param.setLimit(-1);
        List<PurchaseOrderItem> orderItems = purchaseOrderItemService.findByQueryParam(param);
        purchaseOrder.setOrderItems(orderItems);

        String fnNew = writePo2File("采购订单", purchaseOrder, "采购订单.xlsx");
        OrderMaster orderMaster = orderMasterService.findById(purchaseOrder.getOrderId());

        EasyExcelUtil.writeExcel2Response("采购订单" + purchaseOrder.getPurchaseOrderCode()  + ".xlsx", rsp, fnNew);
        return JsonResult.success();
    }

    String writePo2File(String sheetName, PurchaseOrder purchaseOrder, String fileName) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("poCode",purchaseOrder.getPurchaseOrderCode());
        map.put("orderDate", KunlongUtils.transDate(purchaseOrder.getOpenDate()));
        map.put("issueDate",KunlongUtils.transDate(purchaseOrder.getIssueDate()));


        Supplier supplier = supplierService.findById(purchaseOrder.getSupplyId());
        if (supplier != null) {
            map.put("supplyName", supplier.getName());
            map.put("addr", supplier.getAddr());
            map.put("contract", supplier.getContact()!=null?supplier.getContact():"");
            map.put("tel", supplier.getTel()!=null?supplier.getTel():"");
            map.put("fax", supplier.getFax()!=null?supplier.getFax():"");

        }

        BigDecimal sumQty = KunlongModel.newBigDecimal(2, 0);
        BigDecimal sumMoney = KunlongModel.newBigDecimal(2, 0);

        List<Map<String, Object>> mapList = new ArrayList<>();
        Integer i=0;
        for (PurchaseOrderItem orderItem : purchaseOrder.getOrderItems()) {
            Map<String, Object> row = new LinkedHashMap<>();
            row.put("seq", ++i);
            Product product = productService.findById(orderItem.getProductId());
            if (product != null) {
                row.put("code", product.getCode());
                row.put("name", product.getName());
                row.put("remark", product.getRemark());
                row.put("unit", product.getUnit());

            }
            row.put("qty", orderItem.getQty().toString());
            row.put("price", orderItem.getPrice().toString());
            row.put("money", orderItem.getMoney().toString());
            row.put("memo", orderItem.getRemark());
            sumQty = sumQty.add(orderItem.getQty());
            sumMoney = sumMoney.add(orderItem.getMoney());

            mapList.add(row);
        }
        map.put("sumQty", sumQty.toString());
        map.put("sumMoney", sumMoney.toString());
        // 大写
        map.put("sumMoneyChinese", ConvertUpMoney.toChinese(sumMoney.toString()));
        map.put("list", mapList);
        ;
        return easyPOIUtilApiService.makeExcelSheet("po_template.xlsx",fileName,sheetName, map);
     //   return EasyPOIUtil.makeExcelSheet("po_template.xlsx",fileName,sheetName,map);
    }
}
