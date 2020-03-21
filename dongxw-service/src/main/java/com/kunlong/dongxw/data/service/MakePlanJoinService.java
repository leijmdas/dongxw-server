package com.kunlong.dongxw.data.service;

import com.kunlong.dongxw.data.domain.*;
import com.kunlong.dubbo.sys.model.SysUserDTO;

import java.io.IOException;
import java.util.List;

public interface MakePlanJoinService {
    String writePlan2File(String sheetName, List<MakePlan> makePlans, String fileName) throws IOException;

    boolean checkExistsByOrderLine(Integer orderLineId) throws IOException;

    List<MakePlan> findByOrder (Integer orderId) throws IOException;

    boolean checkExistsSheetByPlan(Integer planId, Integer bomId) throws IOException;

    List<MakeSheet> findSheetByPlan(Integer id) throws IOException;

    int makeSheetByPlanOrder(Integer orderId, Integer sysUserId) throws IOException;

    void makeSheetByPlan(Integer planId, Integer sysUserId) throws IOException;

    void makePlanByOrder(Integer orderId, OrderMaster orderMaster, Integer sysUserId) throws IOException;

    void rmPlanByOrder(Integer orderId) throws IOException;

    void makePurchasePlanByOrder(Integer orderId, Integer sysUserId) throws IOException;

    void fillMakePlan(MakePlan makePlan);

    void fillMakePlans(List<MakePlan> makePlans);
    void fillVMakePlans(List<VOrderPlan> makePlans);

}
