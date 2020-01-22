package com.kunlong.dongxw.controller;


import app.support.query.PageResult;
import cn.kunlong.center.api.model.SysUserDTO;
import com.kunlong.api.service.AuthApiService;
import com.kunlong.dongxw.annotation.DateRewritable;
import com.kunlong.dongxw.consts.ApiConstants;
import com.kunlong.dongxw.consts.MakePlanConst;
import com.kunlong.dongxw.consts.MoneyTypeConsts;
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

    @Transactional
    @RequestMapping("/makePlanByOrder/{orderId}")
    public JsonResult<Integer> makePlanByOrder(@PathVariable("orderId") Integer orderId) throws IOException {
        OrderLine.QueryParam queryParam=new OrderLine.QueryParam();
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
                OrderMaster orderMaster = orderMasterService.findById(orderLine.getOrderId());

                makePlan.setOrderDate(orderMaster != null ? orderMaster.getOrderDate() : null);
                makePlan.setIssueDate(orderMaster != null ? orderMaster.getFactroyIssueDate() : null);
                makePlan.setOutFlag(MakePlanConst.OUT_FLAG_SELF);
                makePlan.setFinishFlag(MakePlanConst.FINISH_FLAG_UN);
                makePlanService.save(makePlan);

            }
        }

        return JsonResult.success(0);
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

    @PostMapping("/deleteById/{id}")
    public JsonResult<Integer> deleteById(@PathVariable("id") Integer id) throws IOException {

        makePlanService.deleteById(id);


        return JsonResult.success();
    }

    @RequestMapping("/findById/{id}")
    public JsonResult<MakePlan> findById(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException {
        MakePlan makePlan = makePlanService.findById(id);
        OrderLine orderLine = orderLineService.findById(makePlan.getOrederLineId());
        makePlan.setProduct(productService.findById(orderLine.getProductId()));
        makePlan.setOrderLine(orderLine);
        SysUserDTO sysUserDTO = sysUserApiService.findById(makePlan.getCreateBy());
        makePlan.setCreateByName(sysUserDTO == null ? "-" : sysUserDTO.getUsername());

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


    @PostMapping("/query")
    public PageResult<MakePlan> query(@RequestBody MakePlan.QueryParam queryParam) throws IOException {
        PageResult<MakePlan> pageResult = new PageResult<MakePlan>();

        pageResult.setTotal(makePlanService.countByQueryParam(queryParam));
        pageResult.setData(makePlanService.findByQueryParam(queryParam));

        for (MakePlan makePlan : pageResult.getData()) {
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
        return pageResult;
    }


    @RequestMapping(value="export",method = RequestMethod.POST)
    @ApiOperation(value = "export", notes = "export", authorizations = {@Authorization(value = ApiConstants.AUTH_API_WEB)})
    public void export(@RequestBody @DateRewritable MakePlan.QueryParam queryParam, HttpServletRequest req, HttpServletResponse rsp) throws FileNotFoundException, IOException {

        if(queryParam.getParam() == null) {
            queryParam.setParam(new MakePlan());
        }
        queryParam.setLimit(-1);
        queryParam.setStart(0);

        WebFileUtil web = new WebFileUtil(req,rsp);
        List<MakePlan> makePlans = this.makePlanService.findByQueryParam(queryParam);;
        web.export2EasyExcelObject("生产计划表.xlsx", buildTitles(),buildRecords(makePlans));

    }

    List<String> buildTitles(){
        List<String> strings=new ArrayList<>();

        strings.add("日期");
        //strings.add("颜色");

        return strings;
    }

    //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //r.add(sdf.format(payOrder.getPayTime()));
    String transDatetime(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(d);
    }

    String transDate(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(d);
    }

    List<List<Object>> buildRecords(List<MakePlan> makePlans) {
        List<List<Object>> records = new ArrayList<>();
        for (MakePlan makePlan : makePlans) {
            List<Object> r = new ArrayList<>();

            r.add(transDate(makePlan.getIssueDate()));
            //r.add(makePlan.getColor());

            //r.add(transDate(customer.getCreateDate()));

            records.add(r);
        }
        return records;
    }

}

