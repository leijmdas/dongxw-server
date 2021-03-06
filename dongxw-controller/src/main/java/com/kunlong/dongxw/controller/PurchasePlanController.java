package com.kunlong.dongxw.controller;


import app.support.query.PageResult;
import com.kunlong.dongxw.config.DongxwTransactional;
import com.kunlong.dongxw.report.service.PurchaseUseSumService;
import com.kunlong.dubbo.sys.model.SysUserDTO;
import com.kunlong.dongxw.annotation.DateRewritable;
import com.kunlong.dongxw.consts.ApiConstants;
import com.kunlong.dongxw.consts.MakePlanConst;
import com.kunlong.dongxw.data.domain.*;
import com.kunlong.dongxw.data.service.*;
import com.kunlong.dongxw.util.WebFileUtil;
import com.kunlong.platform.utils.JsonResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * cust类
 * Package:
 * Author: cch/leijiming
 * Date: Created in 2018/8/23 16:50
 */
@RestController
@RequestMapping("/dongxw/purchaseplan")
public  class PurchasePlanController extends BaseController {
    @Autowired
    PurchaseUseSumService purchaseUseSumService;

    @Autowired
    MakePlanJoinService makePlanJoinService;
    @Autowired
    MakePlanService makePlanService;
    @Autowired
    PurchasePlanService purchasePlanService;

    @Autowired
    BomJoinService bomJoinService;

    @Autowired
    CustomerService customerService;

    @Autowired
    OrderMasterService orderMasterService;

    @Autowired
    OrderLineService orderLineService;
    @Autowired
    ProductService productService;

    @Autowired
    ProductTypeService productTypeService;
//    @DongxwTransactional
//    @RequestMapping("/makeSheetByPlan/{planId}")
//    public JsonResult<String> makeSheetByPlan(@PathVariable("planId") Integer planId) throws IOException {
//
//        makePlanJoinService.makeSheetByPlan(planId,getCurrentUserId());
//        return JsonResult.success("成功！");
//    }

    @DongxwTransactional
    @RequestMapping("/makePurchasePlanByOrder/{orderId}")
    public JsonResult<String> makePurchasePlanByOrder(@PathVariable("orderId") Integer orderId) throws IOException {

        makePlanJoinService.makePurchasePlanByOrder(orderId, getCurrentUserId());
        return JsonResult.success("成功！");
    }

    /**
     * 检查有计划
     */
    @PostMapping("/deleteById/{id}")
    public JsonResult<Integer> deleteById(@PathVariable("id") Integer id) throws IOException {

        purchasePlanService.deleteById(id);


        return JsonResult.success();
    }

    @RequestMapping("/findById/{id}")
    public JsonResult<PurchasePlan> findById(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException {
        PurchasePlan purchasePlan = purchasePlanService.findById(id);
        //fillMakePlan(makeSheet);
        return JsonResult.success(purchasePlan);

    }

    @RequestMapping("/save")
    public JsonResult<Integer> save(@RequestBody PurchasePlan purchasePlan) {

        if (purchasePlan.getId() == null) {
            purchasePlanService.save(purchasePlan);
        } else {
            purchasePlanService.update(purchasePlan);
        }

        return JsonResult.success(purchasePlan.getId());
    }

    void fillMakePlan(MakePlan makePlan) {
        OrderLine orderLine = orderLineService.findById(makePlan.getOrderLineId());
        if (orderLine != null) {
            makePlan.setCustomer(customerService.findById(orderLine.getCustomerId()));
            OrderMaster orderMaster = orderMasterService.findById(orderLine.getOrderId());
            makePlan.setOrderMaster(orderMaster);
            makePlan.setOrderLine(orderLine);
            makePlan.setProduct(productService.findById(orderLine.getProductId()));
        }
        SysUserDTO sysUserDTO = sysUserApiService.findById(makePlan.getCreateBy());
        makePlan.setCreateByName(sysUserDTO == null ? "-" : sysUserDTO.getUsername());
    }

    void fillMakePlans(List<MakePlan> makePlans) {

        for (MakePlan makePlan : makePlans) {
            fillMakePlan(makePlan);
        }
    }

    //queryParam.setSortBys("id|desc");
    @PostMapping("/query")
    public PageResult<PurchasePlan> query(@RequestBody PurchasePlan.QueryParam queryParam) throws IOException {
        PageResult<PurchasePlan> pageResult = new PageResult<PurchasePlan>();


        pageResult.setTotal(purchasePlanService.countByQueryParam(queryParam));
        pageResult.setData(purchasePlanService.findByQueryParam(queryParam));
        for (PurchasePlan sheet : pageResult.getData()) {
            sheet.setChildRm(productService.findById(sheet.getChildId()));
            sheet.setProduct(productService.findById(sheet.getProductId()));
            if (sheet.getChildRm() != null) {
                sheet.getChildRm().setProductSubType(productTypeService.findById(sheet.getChildRm().getProductTypeId()));
                sheet.getChildRm().setProductType(productTypeService.findById(sheet.getChildRm().getParentId()));

            }
            SysUserDTO sysUserDTO = sysUserApiService.findById(sheet.getCreateBy());
            sheet.setCreateByName(sysUserDTO == null ? "-" : sysUserDTO.getUsername());
        }
        if(queryParam.getOrderBys()!=null&&queryParam.getOrderBys().contains("code")) {
            Collections.sort(pageResult.getData(), new Comparator<PurchasePlan>() {
                @Override
                public int compare(PurchasePlan a, PurchasePlan b) {
                    if (a.getChildRm() != null && b.getChildRm() != null) {
                        return a.getChildRm().getCode().compareTo(b.getChildRm().getCode());
                    }

                    return a.getId().compareTo(b.getId());
                }
            });
        }
        else
        if(queryParam.getOrderBys()!=null&&queryParam.getOrderBys().contains("productId")) {
            Collections.sort(pageResult.getData(), new Comparator<PurchasePlan>() {
                @Override
                public int compare(PurchasePlan a, PurchasePlan b) {
                    if (a.getProduct() != null && b.getProduct() != null) {
                        return a.getProduct().getCode().compareTo(b.getProduct().getCode());
                    }

                    return a.getId().compareTo(b.getId());
                }
            });
        }
        return pageResult;
    }


    @RequestMapping(value = "export", method = RequestMethod.POST)
    @ApiOperation(value = "export", notes = "export", authorizations = {@Authorization(value = ApiConstants.AUTH_API_WEB)})
    public void export(@RequestBody @DateRewritable MakePlan.QueryParam queryParam, HttpServletRequest req, HttpServletResponse rsp) throws FileNotFoundException, IOException {

        if (queryParam.getParam() == null) {
            queryParam.setParam(new MakePlan());
        }
        queryParam.setLimit(3000);
        queryParam.setStart(0);
        queryParam.setSortBys("customerId|asc,orderId|asc");

        WebFileUtil web = new WebFileUtil(req, rsp);
        List<MakePlan> makePlans = this.makePlanService.findByQueryParam(queryParam);
        fillMakePlans(makePlans);
        rsp.setHeader("file", URLEncoder.encode("生产计划表.xlsx", "UTF-8"));

        web.export2EasyExcelObject("生产计划表.xlsx", buildTitles(), buildRecords(makePlans));

    }

    List<String> buildTitles() {
        List<String> strings = new ArrayList<>();

        strings.add("发外标志");
        strings.add("客户名称");
        strings.add("客户订单号");
        strings.add("客款号");
        strings.add("产品描述");
        strings.add("颜色");
        strings.add("数量");

        strings.add("接单日期");
        strings.add("要求交期");
        strings.add("物料到位日期");
        strings.add("包材到位日期");
        strings.add("计划上线日期");
        strings.add("计划完成日期");
        strings.add("是否完成");
        strings.add("实际完成日期");
        strings.add("备注");
        return strings;
    }

    List<List<Object>> buildRecords(List<MakePlan> makePlans) {
        List<List<Object>> records = new ArrayList<>();
        for (MakePlan makePlan : makePlans) {
            List<Object> r = new ArrayList<>();
            //strings.add("发外标志");
            r.add(MakePlanConst.getOutFlag(makePlan.getOutFlag()));
            // strings.add("客户名称");
            r.add(makePlan.getCustomer() == null ? "-" : makePlan.getCustomer().getCustName());
            //strings.add("客户订单号");
            r.add(makePlan.getOrderMaster() == null ? "-" : makePlan.getOrderMaster().getCustomerOrderCode());
            //strings.add("客款号");
            r.add(makePlan.getProduct() == null ? "-" : makePlan.getProduct().getCode());
            //strings.add("产品描述");
            r.add(makePlan.getProduct() == null ? "-" : makePlan.getProduct().getRemark());
            //strings.add("颜色");
            r.add(makePlan.getProduct() == null ? "-" : makePlan.getProduct().getColor());
            //strings.add("数量");
            r.add(makePlan.getOrderLine() == null ? "-" : makePlan.getOrderLine().getQty());

            //strings.add("接单日期");
            r.add(transDate(makePlan.getOrderDate()));
            //strings.add("要求交期");
            r.add(transDate(makePlan.getIssueDate()));
            //strings.add("物料到位日期");
            r.add(transDate(makePlan.getRmDate()));
            //strings.add("包材到位日期");
            r.add(transDate(makePlan.getPkgDate()));
            //strings.add("计划上线日期");
            r.add(transDate(makePlan.getPlanStart()));
            //strings.add("计划完成日期");
            r.add(transDate(makePlan.getPlanEnd()));
            //strings.add("是否完成");
            r.add(MakePlanConst.getFinishFlag(makePlan.getFinishFlag()));

            //strings.add("实际完成日期");
            r.add(transDate(makePlan.getRealEnd()));
            //strings.add("备注");
            r.add(makePlan.getRemark());

            records.add(r);
        }
        return records;
    }

    String transDatetime(Date d) {
        if (d == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(d);
    }

    String transDate(Date d) {
        if (d == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(d);
    }

    @RequestMapping(value = "/exportUseSum/{orderId}", method = RequestMethod.POST)
    @ApiOperation(value = "/exportUseSum/{orderId}", notes = "用量汇总", authorizations = {@Authorization(value = ApiConstants.AUTH_API_WEB)})
    public void exportUseSum(@PathVariable("orderId") Integer orderId, HttpServletResponse rsp) throws FileNotFoundException, IOException, InvocationTargetException, IllegalAccessException {

        String fileName = purchaseUseSumService.export(rsp  , orderId);

    }

}

