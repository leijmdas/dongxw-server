package com.kunlong.dongxw.controller;


import app.support.query.PageResult;
import cn.kunlong.center.api.model.SysUserDTO;
import com.kunlong.api.service.AuthApiService;
import com.kunlong.dongxw.annotation.DateRewritable;
import com.kunlong.dongxw.consts.ApiConstants;
import com.kunlong.dongxw.consts.MakePlanConst;
import com.kunlong.dongxw.consts.MoneyTypeConsts;
import com.kunlong.dongxw.consts.OrderStatusConsts;
import com.kunlong.dongxw.dongxw.domain.Customer;
import com.kunlong.dongxw.dongxw.domain.MakePlan;
import com.kunlong.dongxw.dongxw.domain.OrderLine;
import com.kunlong.dongxw.dongxw.domain.OrderMaster;
import com.kunlong.dongxw.dongxw.service.*;
import com.kunlong.dongxw.util.WebFileUtil;
import com.kunlong.platform.utils.JsonResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
@RequestMapping("/dongxw/makeplan")
public  class MakePlanController extends BaseController {
    @Autowired
    MakePlanService makePlanService;

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

    @Transactional
    @RequestMapping("/makePlanByOrder/{orderId}")
    public JsonResult<String> makePlanByOrder(@PathVariable("orderId") Integer orderId) throws IOException {
        OrderMaster orderMaster = orderMasterService.findById(orderId);
        if (orderMaster.getStatus().equals(OrderStatusConsts.OrderStatus_DRAFT)) {

            return JsonResult.failure("订单在草稿状态，暂不能生成计划！");
        }

        OrderLine.QueryParam queryParam = new OrderLine.QueryParam();
        queryParam.setParam(new OrderLine());
        queryParam.getParam().setOrderId(orderId);
        queryParam.setLimit(-1);

        List<OrderLine> orderLines = orderLineService.findByQueryParam(queryParam);
        for (OrderLine orderLine : orderLines) {
            if (!checkExistsByOrderLine(orderLine.getId())) {
                MakePlan makePlan=new MakePlan();
                makePlan.setCustomerId(orderLine.getCustomerId());
                makePlan.setOrderId(orderLine.getOrderId());
                makePlan.setOrederLineId(orderLine.getId());
                makePlan.setCreateDate(new Date());
                makePlan.setCreateBy(this.getCurrentUserId());

                makePlan.setOrderDate(orderMaster != null ? orderMaster.getOrderDate() : null);
                makePlan.setIssueDate(orderMaster != null ? orderMaster.getFactroyIssueDate() : null);
                makePlan.setOutFlag(MakePlanConst.OUT_FLAG_SELF);
                makePlan.setFinishFlag(MakePlanConst.FINISH_FLAG_UN);
                makePlanService.save(makePlan);

            }
        }

        return JsonResult.success("成功！");
    }

    /*删除多余计费产品*/
    @Transactional
    @RequestMapping("/rmPlanByOrder/{orderId}")
    public JsonResult<String> rmPlanByOrder(@PathVariable("orderId") Integer orderId) throws IOException {
        OrderMaster orderMaster = orderMasterService.findById(orderId);


        OrderLine.QueryParam queryParam = new OrderLine.QueryParam();
        queryParam.setParam(new OrderLine());
        queryParam.getParam().setOrderId(orderId);
        queryParam.setLimit(-1);

        List<OrderLine> orderLines = orderLineService.findByQueryParam(queryParam);
        for (OrderLine orderLine : orderLines) {
            if (!checkExistsByOrderLine(orderLine.getId())) {
                MakePlan makePlan=new MakePlan();
                makePlan.setCustomerId(orderLine.getCustomerId());
                makePlan.setOrderId(orderLine.getOrderId());
                makePlan.setOrederLineId(orderLine.getId());
                makePlan.setCreateDate(new Date());
                makePlan.setCreateBy(this.getCurrentUserId());

                makePlan.setOrderDate(orderMaster != null ? orderMaster.getOrderDate() : null);
                makePlan.setIssueDate(orderMaster != null ? orderMaster.getFactroyIssueDate() : null);
                makePlan.setOutFlag(MakePlanConst.OUT_FLAG_SELF);
                makePlan.setFinishFlag(MakePlanConst.FINISH_FLAG_UN);
                makePlanService.save(makePlan);

            }
        }

        return JsonResult.success("成功！");
    }

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

    //检查有计划
    @PostMapping("/deleteById/{id}")
    public JsonResult<Integer> deleteById(@PathVariable("id") Integer id) throws IOException {

        makePlanService.deleteById(id);


        return JsonResult.success();
    }

    @RequestMapping("/findById/{id}")
    public JsonResult<MakePlan> findById(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException {
        MakePlan makePlan = makePlanService.findById(id);
//        OrderLine orderLine = orderLineService.findById(makePlan.getOrederLineId());
//        makePlan.setProduct(productService.findById(orderLine.getProductId()));
//        makePlan.setOrderLine(orderLine);
//        SysUserDTO sysUserDTO = sysUserApiService.findById(makePlan.getCreateBy());
//        makePlan.setCreateByName(sysUserDTO == null ? "-" : sysUserDTO.getUsername());
        fillMakePlan(makePlan);
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

    void fillMakePlan(MakePlan makePlan){
        OrderLine orderLine = orderLineService.findById(makePlan.getOrederLineId());
        if (orderLine != null) {
            makePlan.setCustomer(customerService.findById(orderLine.getCustomerId()));
            OrderMaster orderMaster=orderMasterService.findById(orderLine.getOrderId());
            makePlan.setOrderMaster(orderMaster);
            makePlan.setOrderLine(orderLine);
            makePlan.setProduct(productService.findById(orderLine.getProductId()));
        }
        SysUserDTO sysUserDTO = sysUserApiService.findById(makePlan.getCreateBy());
        makePlan.setCreateByName(sysUserDTO == null ? "-" : sysUserDTO.getUsername());
    }

    void fillMakePlans(List<MakePlan> makePlans){

        for (MakePlan makePlan : makePlans) {
            fillMakePlan(makePlan);
        }
    }
    @PostMapping("/query")
    public PageResult<MakePlan> query(@RequestBody MakePlan.QueryParam queryParam) throws IOException {
        PageResult<MakePlan> pageResult = new PageResult<MakePlan>();

        queryParam.setSortBys("id|desc");
        pageResult.setTotal(makePlanService.countByQueryParam(queryParam));
        pageResult.setData(makePlanService.findByQueryParam(queryParam));
        fillMakePlans(pageResult.getData());
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
        List<MakePlan> makePlans = this.makePlanService.findByQueryParam(queryParam);
        fillMakePlans(makePlans);
        rsp.setHeader("file",URLEncoder.encode(  "生产计划表.xlsx","UTF-8"));

        web.export2EasyExcelObject("生产计划表.xlsx", buildTitles(),buildRecords(makePlans));

    }

    List<String> buildTitles(){
        List<String> strings=new ArrayList<>();

        strings.add("发外标志");
        strings.add("客户名称");
        strings.add("客户订单号");
        strings.add("客款号");
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
            r.add(makePlan.getCustomer()==null?"-":makePlan.getCustomer().getCustName());
            //strings.add("客户订单号");
            r.add(makePlan.getOrderMaster()==null?"-":makePlan.getOrderMaster().getCustomerOrderCode());
            //strings.add("客款号");
            r.add(makePlan.getProduct()==null?"-":makePlan.getProduct().getCode());
            //strings.add("颜色");
            r.add(makePlan.getProduct()==null?"-":makePlan.getProduct().getColor());
            //strings.add("数量");
            r.add(makePlan.getOrderLine()==null?"-":makePlan.getOrderLine().getQty());

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
        if(d==null){
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(d);
    }

    String transDate(Date d) {
        if(d==null){
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(d);
    }



}

