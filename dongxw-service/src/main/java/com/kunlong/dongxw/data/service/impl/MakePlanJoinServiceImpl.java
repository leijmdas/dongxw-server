package com.kunlong.dongxw.data.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.alibaba.fastjson.JSON;
import com.kunlong.dongxw.config.DongxwTransactional;
import com.kunlong.dongxw.consts.MakePlanConst;
import com.kunlong.dongxw.consts.PathConsts;
import com.kunlong.dongxw.data.domain.*;
import com.kunlong.dongxw.data.service.*;
import com.kunlong.dongxw.util.EasyPOIUtil;
import com.kunlong.dongxw.util.FileUtil;
import com.kunlong.dongxw.util.SimpleSequenceGenerator;
import com.kunlong.dubbo.sys.model.SysUserDTO;
import com.kunlong.dubbo.sys.service.SysUserApiService;
import com.kunlong.platform.utils.KunlongUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

@Service
public class MakePlanJoinServiceImpl    implements MakePlanJoinService {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Reference(lazy = true, version = "${dubbo.service.version}")
    SysUserApiService sysUserApiService;
    @Autowired
    ProductService productService;

    @Autowired
    BomJoinService bomJoinService;

    @Autowired
    OrderMasterService orderMasterService;
    @Autowired
    OrderLineService orderLineService;
    @Autowired
    MakePlanService makePlanService;
    @Autowired
    MakeSheetService makeSheetService;
    @Autowired
    CustomerService customerService;

    @Autowired
    PurchasePlanService purchasePlanService;


    public boolean checkExistsByOrderLine(Integer orderLineId) throws IOException {

        List<MakePlan> plans = findOneByOrderLine(orderLineId);
        return plans != null && plans.size() > 0;
    }
    public List<MakePlan> findOneByOrderLine(Integer orderLineId) throws IOException {
        MakePlan.QueryParam queryParam = new MakePlan.QueryParam();
        queryParam.setParam(new MakePlan());
        queryParam.getParam().setOrderLineId(orderLineId);
        queryParam.setLimit(1);

        return makePlanService.findByQueryParam(queryParam);
    }

    @Override
    public List<MakePlan> findByOrder (Integer orderId) throws IOException {
        MakePlan.QueryParam queryParam = new MakePlan.QueryParam();
        queryParam.setParam(new MakePlan());
        queryParam.getParam().setOrderId(orderId);
        queryParam.setLimit(-1);

        return makePlanService.findByQueryParam(queryParam);
    }

    public List<MakeSheet> findSheetByPlan(Integer planId) throws IOException {
        MakeSheet.QueryParam queryParam = new MakeSheet.QueryParam();
        queryParam.setParam(new MakeSheet());
        queryParam.getParam().setPlanId(planId);
        queryParam.setLimit(-1);

        return makeSheetService.findByQueryParam(queryParam);
    }

    public List<MakeSheet> chkFindSheetByPlan(Integer planId, Integer bomId) throws IOException {
        MakeSheet.QueryParam queryParam = new MakeSheet.QueryParam();
        queryParam.setParam(new MakeSheet());
        queryParam.getParam().setPlanId(planId);
        queryParam.getParam().setBomId(bomId);
        queryParam.setLimit(1);

        return makeSheetService.findByQueryParam(queryParam);
    }

    /**productId
     * */
    public boolean checkExistsSheetByPlan(Integer planId,Integer bomId ) throws IOException {

        List<MakeSheet> sheets = chkFindSheetByPlan(planId,bomId);
        return sheets != null && sheets.size() > 0;
    }
    //采购计划
    public boolean checkExistsPpByPlan(Integer planId,Integer rmId) throws IOException {

        List<PurchasePlan> plans = chkFindPpByOrderPlan(planId,rmId);
        return plans != null && plans.size() > 0;
    }
    public List<PurchasePlan> chkFindPpByOrderPlan(Integer planId,Integer rmId) throws IOException {
        PurchasePlan.QueryParam queryParam = new PurchasePlan.QueryParam();
        queryParam.setParam(new PurchasePlan());
        queryParam.getParam().setPlanId(planId);
        queryParam.getParam().setRmId(rmId);
        queryParam.setLimit(1);

        return purchasePlanService.findByQueryParam(queryParam);
    }

    public void makeSheetByPlan(Integer planId, Integer sysUserId) throws IOException {

        MakePlan makePlan = makePlanService.findById(planId);
        if (makePlan != null) {
            OrderLine orderLine = orderLineService.findById(makePlan.getOrderLineId());
            if (orderLine != null) {
                List<Bom> boms = bomJoinService.queryBomByProduct(orderLine.getProductId());
                for (Bom bom : boms) {
                    logger.info(bom.toString());
                    //if (!checkExistsSheetByPlan(makePlan.getId(), bom.getChildId(),bom.getCutPartName())) {
                        if (!checkExistsSheetByPlan(makePlan.getId(), bom.getId() )) {
                            logger.info(makePlan.toString());
                        MakeSheet makeSheet = copy2MakeSheet(makePlan, bom, sysUserId, orderLine);
                        makeSheetService.save(makeSheet);

                    }
                }
            }
        }
    }
    //purchasePlanService
    PurchasePlan copy2PurchasePlan(MakePlan makePlan, Bom bom, Integer sysUserId, OrderLine orderLine) {
        PurchasePlan purchasePlan = JSON.parseObject(bom.toString(), PurchasePlan.class);
        purchasePlan.setId(null);
        purchasePlan.setRmId(bom.getChildId());
        purchasePlan.setOrderLineId(makePlan.getOrderLineId());
        purchasePlan.setOrderId(makePlan.getOrderId());
        purchasePlan.setPlanId(makePlan.getId());
        purchasePlan.setCreateDate(new Date());
        purchasePlan.setCreateBy(sysUserId);
        // pkg rm
        if(bom.getBigType().equals(300)){
            purchasePlan.setRmDate(makePlan.getPkgDate());
        }else {
            purchasePlan.setRmDate(makePlan.getRmDate());
        }
        purchasePlan.setLossQty(bom.getQty().multiply(Bom.newBigDecimal(bom.getLossQty())).divide(bom.newBigDecimal(100)));
        purchasePlan.setpQty(bom.getQty());
        purchasePlan.setQty(purchasePlan.getpQty().add(purchasePlan.getLossQty()));
        purchasePlan.setTotalQty(purchasePlan.getQty().multiply(Bom.newBigDecimal(orderLine.getQty())));
        return purchasePlan;
    }

    MakeSheet copy2MakeSheet(MakePlan makePlan,Bom bom,Integer sysUserId,OrderLine orderLine){
        MakeSheet makeSheet = JSON.parseObject(bom.toString(), MakeSheet.class);

        makeSheet.setTotalQty(makeSheet.getQty().multiply(Bom.newBigDecimal(4,orderLine.getQty())));

        makeSheet.setId(null);
        makeSheet.setOrderLineId(makePlan.getOrderLineId());
        makeSheet.setOrderId(makePlan.getOrderId());
        makeSheet.setPlanId(makePlan.getId());
        makeSheet.setBomId(bom.getId());
        makeSheet.setCreateDate(new Date());
        makeSheet.setCreateBy(sysUserId);
        if(makeSheet.getStatus()==null)
        {
            makeSheet.setStatus(0);
        }
        return makeSheet;
    }

    @DongxwTransactional
    public int makeSheetByPlanOrder(Integer orderId, Integer sysUserId) throws IOException {

        MakePlan.QueryParam queryParam = new MakePlan.QueryParam();
        queryParam.setParam(new MakePlan());
        queryParam.getParam().setOrderId(orderId);
        queryParam.setLimit(-1);

        int i=0;
        List<MakePlan> makePlans = makePlanService.findByQueryParam(queryParam);
        for (MakePlan makePlan : makePlans) {
            if (makePlan.getOutFlag().equals(MakePlanConst.OUT_FLAG_SELF)) {
                OrderLine orderLine = orderLineService.findById(makePlan.getOrderLineId());
                if (orderLine != null) {
                    List<Bom> boms = bomJoinService.queryBomByProduct(orderLine.getProductId());
                    for (Bom bom : boms) {
                        System.out.print(boms.size());
                        if (!checkExistsSheetByPlan(makePlan.getId(), bom.getId())) {
                            MakeSheet makeSheet = copy2MakeSheet(makePlan, bom, sysUserId, orderLine);
                            makeSheetService.save(makeSheet);
                            i++;
                        }
                    }
                }
            }
        }
        return i;
    }

    public void makePurchasePlanByOrder(Integer orderId, Integer sysUserId) throws IOException {

        MakePlan.QueryParam queryParam = new MakePlan.QueryParam();
        queryParam.setParam(new MakePlan());
        queryParam.getParam().setOrderId(orderId);
        queryParam.setLimit(-1);

        List<MakePlan> makePlans = makePlanService.findByQueryParam(queryParam);
        for (MakePlan makePlan : makePlans) {
            if (makePlan.getOutFlag().equals(MakePlanConst.OUT_FLAG_SELF)) {
                OrderLine orderLine = orderLineService.findById(makePlan.getOrderLineId());
                if (orderLine != null) {
                    List<Bom> boms = bomJoinService.queryBomByProduct(orderLine.getProductId());
                    for (Bom bom : boms) {
                        logger.debug("makePurchasePlanByOrder bom:{}", bom.toString());
                        if (!checkExistsPpByPlan(makePlan.getId(), bom.getChildId())) {
                            logger.debug("makePurchasePlanByOrder makePlan:{}", makePlan);
                            PurchasePlan purchasePlan = copy2PurchasePlan(makePlan, bom, sysUserId, orderLine);
                            purchasePlanService.save(purchasePlan);

                        }
                    }
                }
            }
        }
    }


    public void makePlanByOrder( Integer orderId, OrderMaster orderMaster,Integer sysUserId) throws IOException {


        OrderLine.QueryParam queryParam = new OrderLine.QueryParam();
        queryParam.setParam(new OrderLine());
        queryParam.getParam().setOrderId(orderId);
        queryParam.setLimit(-1);

        List<OrderLine> orderLines = orderLineService.findByQueryParam(queryParam);
        for (OrderLine orderLine : orderLines) {
            if (!checkExistsByOrderLine(orderLine.getId())) {
                MakePlan makePlan = new MakePlan();
                makePlan.setCustomerId(orderLine.getCustomerId());
                makePlan.setOrderId(orderLine.getOrderId());
                makePlan.setOrderLineId(orderLine.getId());
                makePlan.setCreateDate(new Date());
                makePlan.setCreateBy(sysUserId);

                makePlan.setOrderDate(orderMaster != null ? orderMaster.getOrderDate() : null);
                makePlan.setIssueDate(orderMaster != null ? orderMaster.getFactroyIssueDate() : null);
                makePlan.setOutFlag(MakePlanConst.OUT_FLAG_SELF);
                makePlan.setOutPrepareRm(Short.valueOf((short) 0));
                makePlan.setFinishFlag(MakePlanConst.FINISH_FLAG_UN);
                makePlan.setStatus(0);
                makePlanService.save(makePlan);

            }
        }
    }

    @Override
    public void rmPlanByOrder(  Integer orderId) throws IOException {


    }
//    protected String makeExcelSheet(String templateName, String fileName, String sheetName, Map<String, Object> map) throws IOException {
//
//        TemplateExportParams exportParams = new TemplateExportParams("templates/"+templateName);
//        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, map);
//        exportParams.setSheetName( sheetName );
//        File newFile= FileUtil.makeTmpFile(sheetName,fileName);
//        FileOutputStream fos = new FileOutputStream(newFile);
//        try {
//            workbook.write(fos);
//        } finally {
//            fos.flush();
//            fos.close();
//        }
//
//        return newFile.getAbsolutePath();
//    }


    @Override
    public String writePlan2File(String sheetName, List<MakePlan> makePlans, String fileName) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        Map <String, Object> info=new LinkedHashMap();
        map.put("info",info);
        info.put("makeDate",KunlongUtils.transDate(new Date()));
        info.put("makeBy","石头");
        List<Map<String, Object>> mapList = new ArrayList<>();
        for (MakePlan makePlan : makePlans) {
            sheetName = makePlan.getOrderMaster().getCustomerOrderCode();
            Map<String, Object> row = new LinkedHashMap<>();
            row.put("customerName", makePlan.getCustomer().getCustName());
            row.put("orderCode", makePlan.getOrderMaster().getCustomerOrderCode());
            row.put("epCode", makePlan.getOrderMaster().getEpOrderCode());
            row.put("qty", makePlan.getOrderLine().getQty());
            row.put("color", makePlan.getProduct().getColor());
            row.put("orderDate", KunlongUtils.transDate(makePlan.getOrderDate()));
            row.put("issueDate", KunlongUtils.transDate(makePlan.getIssueDate()));
            row.put("rmDate", KunlongUtils.transDate(makePlan.getRmDate()));
            row.put("pkgDate", KunlongUtils.transDate(makePlan.getPkgDate()));
            row.put("planStart", KunlongUtils.transDate(makePlan.getPlanStart()));
            row.put("planFinish", KunlongUtils.transDate(makePlan.getPlanEnd()));
            row.put("realFinish", KunlongUtils.transDate(makePlan.getRealEnd()));
            row.put("outFlag",MakePlanConst.getOutFlag(makePlan.getOutFlag()));

            row.put("memo", makePlan.getRemark());

            mapList.add(row);
        }
        info.put("list", mapList);

       return EasyPOIUtil.makeExcelSheet("workplan_template.xlsx",fileName,sheetName,map);
    }

    public void fillMakePlan(MakePlan makePlan) {
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

    public void fillMakePlans(List<MakePlan> makePlans){

        for (MakePlan makePlan : makePlans) {
            fillMakePlan(makePlan);
        }
    }
}

