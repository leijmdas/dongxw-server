package com.kunlong.dongxw.dongxw.service.impl;

import com.alibaba.fastjson.JSON;
import com.kunlong.dongxw.consts.MakePlanConst;
import com.kunlong.dongxw.dongxw.domain.*;
import com.kunlong.dongxw.dongxw.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class MakePlanJoinServiceImpl implements MakePlanJoinService {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

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


    public boolean checkExistsByOrderLine(Integer orderLineId) throws IOException {

        List<MakePlan> plans = findByOrderLine(orderLineId);
        return plans != null && plans.size() > 0;
    }

    public List<MakePlan> findByOrderLine(Integer orderLineId) throws IOException {
        MakePlan.QueryParam queryParam = new MakePlan.QueryParam();
        queryParam.setParam(new MakePlan());
        queryParam.getParam().setOrederLineId(orderLineId);
        queryParam.setLimit(1);

        return makePlanService.findByQueryParam(queryParam);
    }

    public List<MakeSheet> findSheetByPlan(Integer planId) throws IOException {
        MakeSheet.QueryParam queryParam = new MakeSheet.QueryParam();
        queryParam.setParam(new MakeSheet());
        queryParam.getParam().setPlanId(planId);
        queryParam.setLimit(-1);

        return makeSheetService.findByQueryParam(queryParam);
    }

    public List<MakeSheet> chkFindSheetByPlan(Integer planId,Integer rmId) throws IOException {
        MakeSheet.QueryParam queryParam = new MakeSheet.QueryParam();
        queryParam.setParam(new MakeSheet());
        queryParam.getParam().setPlanId(planId);
        queryParam.getParam().setRmId(rmId);
        queryParam.setLimit(1);

        return makeSheetService.findByQueryParam(queryParam);
    }

    /**productId
     * */
    public boolean checkExistsSheetByPlan(Integer planId,Integer rmId) throws IOException {

        List<MakeSheet> plans = chkFindSheetByPlan(planId,rmId);
        return plans != null && plans.size() > 0;
    }

    public void makeSheetByPlan(Integer planId, Integer sysUserId) throws IOException {

        MakePlan makePlan = makePlanService.findById(planId);
        if (makePlan != null) {
            OrderLine orderLine = orderLineService.findById(makePlan.getOrederLineId());
            if (orderLine != null) {
                List<Bom> boms = bomJoinService.queryBomByProduct(orderLine.getProductId());
                for (Bom bom : boms) {
                    logger.info(bom.toString());
                    if (!checkExistsSheetByPlan(makePlan.getId(),bom.getChildId())) {
                        logger.info(makePlan.toString());
                        MakeSheet makeSheet=copy2MakeSheet(makePlan,bom,sysUserId,orderLine);
                        makeSheetService.save(makeSheet);

                    }
                }
            }
        }
    }

    MakeSheet copy2MakeSheet(MakePlan makePlan,Bom bom,Integer sysUserId,OrderLine orderLine){
        MakeSheet makeSheet = JSON.parseObject(bom.toString(), MakeSheet.class);
        makeSheet.setId(null);
        makeSheet.setRmId(bom.getChildId());
        makeSheet.setOrderLineId(makePlan.getOrederLineId());
        makeSheet.setOrderId(makePlan.getOrderId());
        makeSheet.setPlanId(makePlan.getId());
        makeSheet.setCreateDate(new Date());
        makeSheet.setCreateBy(sysUserId);
        makeSheet.setLossQty(bom.getQty().multiply(bom.newBigDecimal(bom.getLossQty())).divide(bom.newBigDecimal(100)));
        makeSheet.setpQty(bom.getQty());
        makeSheet.setQty(makeSheet.getpQty().add(makeSheet.getLossQty()));
        makeSheet.setTotalQty(makeSheet.getQty().multiply(bom.newBigDecimal(orderLine.getQty())));
        return makeSheet;
    }
    public void makeSheetByPlanOrder( Integer orderId,Integer sysUserId) throws IOException {

        MakePlan.QueryParam queryParam = new MakePlan.QueryParam();
        queryParam.setParam(new MakePlan());
        queryParam.getParam().setOrderId(orderId);
        queryParam.setLimit(-1);

        List<MakePlan> makePlans = makePlanService.findByQueryParam(queryParam);
        for (MakePlan makePlan : makePlans) {
            if (makePlan.getOutFlag().equals(MakePlanConst.OUT_FLAG_SELF)) {
                OrderLine orderLine = orderLineService.findById(makePlan.getOrederLineId());
                if (orderLine != null) {
                    List<Bom> boms = bomJoinService.queryBomByProduct(orderLine.getProductId());
                    for (Bom bom : boms) {
                        logger.info("makeSheetByPlanOrder bom:{}",bom.toString());
                        if (!checkExistsSheetByPlan(makePlan.getId(), bom.getChildId())) {
                            logger.info("makeSheetByPlanOrder makePlan:{}",makePlan);
                            MakeSheet makeSheet=copy2MakeSheet(makePlan,bom,sysUserId,orderLine);
                            makeSheetService.save(makeSheet);

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
                makePlan.setOrederLineId(orderLine.getId());
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

    public void rmPlanByOrder(  Integer orderId) throws IOException {


    }
}

