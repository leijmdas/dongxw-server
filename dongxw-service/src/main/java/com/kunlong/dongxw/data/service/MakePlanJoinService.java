package com.kunlong.dongxw.data.service;

import com.kunlong.dongxw.data.domain.MakePlan;
import com.kunlong.dongxw.data.domain.MakeSheet;
import com.kunlong.dongxw.data.domain.OrderMaster;

import java.io.IOException;
import java.util.List;

public interface MakePlanJoinService {
    boolean checkExistsByOrderLine(Integer orderLineId) throws IOException;

    List<MakePlan> findByOrderLine(Integer orderLineId) throws IOException;

    boolean checkExistsSheetByPlan(Integer planId, Integer productId) throws IOException;

    List<MakeSheet> findSheetByPlan(Integer id) throws IOException;

    void makeSheetByPlanOrder(Integer orderId, Integer sysUserId) throws IOException;

    void makeSheetByPlan(Integer planId, Integer sysUserId) throws IOException;

    void makePlanByOrder(Integer orderId, OrderMaster orderMaster, Integer sysUserId) throws IOException;

    void rmPlanByOrder(Integer orderId) throws IOException;

    void makePurchasePlanByOrder(Integer orderId, Integer sysUserId) throws IOException;


}
