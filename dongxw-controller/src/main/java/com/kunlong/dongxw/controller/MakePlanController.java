package com.kunlong.dongxw.controller;


import app.support.query.PageResult;
import com.kunlong.dongxw.config.DongxwTransactional;
import com.kunlong.dongxw.util.EasyExcelUtil;
import com.kunlong.dongxw.annotation.DateRewritable;
import com.kunlong.dongxw.consts.ApiConstants;
import com.kunlong.dongxw.consts.OrderStatusConsts;
import com.kunlong.dongxw.data.domain.*;
import com.kunlong.dongxw.data.service.*;
import com.kunlong.platform.utils.JsonResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * cust类
 * Package:
 * Author: cch/leijiming
 * Date: Created in 2018/8/23 16:50
 */
@RestController
@RequestMapping("/dongxw/makeplan")
public  class MakePlanController extends BaseController {
    @Autowired
    VOrderPlanService vOrderPlanService;

    @Autowired
    MakePlanJoinService makePlanJoinService;
    @Autowired
    MakePlanService makePlanService;
    @Autowired
    MakeSheetService makeSheetService;

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

    @RequestMapping("/checkPlanByOrder/{orderId}")
    public JsonResult<Integer> checkPlanByOrder(@PathVariable("orderId") Integer orderId) throws IOException {
        OrderMaster orderMaster = orderMasterService.findById(orderId);

        OrderLine.QueryParam queryParam = new OrderLine.QueryParam();
        queryParam.setParam(new OrderLine());
        queryParam.getParam().setOrderId(orderId);
        queryParam.setLimit(-1);
        long total = orderLineService.countByQueryParam(queryParam);
        MakePlan.QueryParam param = new MakePlan.QueryParam();
        param.setParam(new MakePlan());
        param.getParam().setOrderId(orderId);
        long t = makePlanService.countByQueryParam(param);
        if (total == t) {
            return JsonResult.success(0,"订单产品数与计划产品数相等！");
        } else if (total > t) {
            return JsonResult.failure(1,"订单产品数>计划产品数！");
        } else if (total < t) {
            return JsonResult.failure(-1,"订单产品数<计划产品数！");
        }
        return JsonResult.failure(-2,"订单产品数与计划产品数不等");
    }

    @DongxwTransactional
    @RequestMapping("/makeSheetByPlan/{orderId}")
    public JsonResult<String> makeSheetByPlan(@PathVariable("orderId") Integer orderId) throws IOException {

        makePlanJoinService.makeSheetByPlan(orderId,getCurrentUserId());
        return JsonResult.success("成功！");
    }

    @DongxwTransactional
    @RequestMapping("/makePlanByOrder/{orderId}")
    public JsonResult<String> makePlanByOrder(@PathVariable("orderId") Integer orderId) throws IOException {
        OrderMaster orderMaster = orderMasterService.findById(orderId);
        if (orderMaster.getStatus().equals(OrderStatusConsts.OrderStatus_DRAFT)) {

            return JsonResult.failure("订单在草稿状态，暂不能生成计划！");
        }
        makePlanJoinService.makePlanByOrder(orderId,orderMaster,getCurrentUserId());


        return JsonResult.success("成功！");
    }
    /*删除多余计费产品*/
    @DongxwTransactional
    @RequestMapping("/rmPlanByOrder/{orderId}")
    public JsonResult<String> rmPlanByOrder(@PathVariable("orderId") Integer orderId) throws IOException {
        makePlanJoinService.rmPlanByOrder(orderId);

        return JsonResult.success("成功！");
    }


    //检查有计划
    @PostMapping("/deleteById/{id}")
    public JsonResult<Integer> deleteById(@PathVariable("id") Integer id) throws IOException {

        makePlanService.deleteById(id);


        return JsonResult.success();
    }

    @RequestMapping("/findById/{id}")
    public JsonResult<MakePlan> findById(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException {
        MakePlan makePlan = makePlanService.findById(id);
        makePlanJoinService.fillMakePlan(makePlan);
        return JsonResult.success(makePlan);

    }

    @RequestMapping("/save")
    public JsonResult<Integer> save(@RequestBody MakePlan makePlan) {

        if (makePlan.getId() == null) {
            makePlanService.save(makePlan);
        } else {
            makePlanService.update(makePlan);
        }

        return JsonResult.success(makePlan.getId());
    }

    @PostMapping("/queryOrderPlan")
    public PageResult<VOrderPlan> queryOrderPlan(@RequestBody VOrderPlan.QueryParam queryParam) throws IOException {
        PageResult<VOrderPlan> pageResult = new PageResult<VOrderPlan>();

        queryParam.setSortBys("id|desc");
        pageResult.setTotal(vOrderPlanService.countByQueryParam(queryParam));
        pageResult.setData(vOrderPlanService.findByQueryParam(queryParam));
        makePlanJoinService.fillVMakePlans(pageResult.getData());
        return pageResult;
    }

    @PostMapping("/query")
    public PageResult<MakePlan> query(@RequestBody MakePlan.QueryParam queryParam) throws IOException {
        PageResult<MakePlan> pageResult = new PageResult<MakePlan>();

        queryParam.setSortBys("id|desc");
        pageResult.setTotal(makePlanService.countByQueryParam(queryParam));
        pageResult.setData(makePlanService.findByQueryParam(queryParam));
        makePlanJoinService.fillMakePlans(pageResult.getData());
        return pageResult;
    }
    //https://opensource.afterturn.cn/doc/easypoi.html

    @RequestMapping(value="export",method = RequestMethod.POST)
    @ApiOperation(value = "export", notes = "export", authorizations = {@Authorization(value = ApiConstants.AUTH_API_WEB)})
    public JsonResult<Integer> export(@RequestBody @DateRewritable MakePlan.QueryParam queryParam, HttpServletRequest req, HttpServletResponse rsp) throws Exception {


        List<MakePlan> makePlans = makePlanJoinService.findByOrder(queryParam.getParam().getOrderId());
        makePlanJoinService.fillMakePlans(makePlans);
        String fnNew = makePlanJoinService.writePlan2File("生产计划表", makePlans, "生产计划表.xlsx");

        EasyExcelUtil.writeExcel2Response( "生产计划表.xlsx", rsp, fnNew);
        return JsonResult.success(makePlans.size());


    }




}

