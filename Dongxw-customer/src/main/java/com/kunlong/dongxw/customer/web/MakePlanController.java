package com.kunlong.dongxw.customer.web;


import app.support.query.PageResult;
import com.kunlong.dongxw.customer.annotation.DateRewritable;
import com.kunlong.dongxw.customer.consts.ApiConstants;
import com.kunlong.dongxw.customer.consts.MakePlanConst;
import com.kunlong.dongxw.customer.controller.BaseController;
import com.kunlong.dongxw.dongxw.domain.MakePlan;
import com.kunlong.dongxw.dongxw.domain.OrderLine;
import com.kunlong.dongxw.dongxw.domain.OrderMaster;
import com.kunlong.dongxw.dongxw.service.*;
import com.kunlong.dongxw.util.WebFileUtil;
import com.kunlong.platform.utils.JsonResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(ApiConstants.AUTH_API_WEB_CUSTOMER+"/makeplan")
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



    public boolean checkExistsByOrderLine(Integer orderLineId) throws IOException {

        List<MakePlan> plans = findByOrderLine(orderLineId);
        return plans != null && plans.size() > 0;
    }

    public List<MakePlan> findByOrderLine(Integer orderLineId) throws IOException {
        MakePlan.QueryParam queryParam = new MakePlan.QueryParam();
        queryParam.setParam(new MakePlan());
        queryParam.getParam().setOrderLineId(orderLineId);
        queryParam.setLimit(1);

        return makePlanService.findByQueryParam(queryParam);
    }



    @PostMapping("/findById/{id}")
    public JsonResult<MakePlan> findById(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException {
        MakePlan makePlan = makePlanService.findById(id);

        fillMakePlan(makePlan);
        return JsonResult.success(makePlan);

    }

    void fillMakePlan(MakePlan makePlan){
        OrderLine orderLine = orderLineService.findById(makePlan.getOrderLineId());
        if (orderLine != null) {
            makePlan.setCustomer(customerService.findById(orderLine.getCustomerId()));
            OrderMaster orderMaster=orderMasterService.findById(orderLine.getOrderId());
            makePlan.setOrderMaster(orderMaster);
            makePlan.setOrderLine(orderLine);
            makePlan.setProduct(productService.findById(orderLine.getProductId()));
        }
        //SysUserDTO sysUserDTO = sysUserApiService.findById(makePlan.getCreateBy());
        //makePlan.setCreateByName(sysUserDTO == null ? "-" : sysUserDTO.getUsername());
    }

    void fillMakePlans(List<MakePlan> makePlans){

        for (MakePlan makePlan : makePlans) {
            fillMakePlan(makePlan);
        }
    }
    @PostMapping("/query")
    public PageResult<MakePlan> query(@RequestBody MakePlan.QueryParam queryParam) throws IOException {
        if(queryParam.getParam() == null) {
            queryParam.setParam(new MakePlan());
        }
        queryParam.getParam().setCustomerId(this.getCustomer().getId());

        PageResult<MakePlan> pageResult = new PageResult<MakePlan>();

        pageResult.setTotal(makePlanService.countByQueryParam(queryParam));
        pageResult.setData(makePlanService.findByQueryParam(queryParam));
        fillMakePlans(pageResult.getData());
        return pageResult;
    }


    @PostMapping(value = "export")
    @ApiOperation(value = "export", notes = "export", authorizations = {@Authorization(value = ApiConstants.AUTH_API_WEB)})
    public void export(@RequestBody @DateRewritable MakePlan.QueryParam queryParam, HttpServletRequest req, HttpServletResponse rsp) throws FileNotFoundException, IOException {

        if(queryParam.getParam() == null) {
            queryParam.setParam(new MakePlan());
        }
        queryParam.setLimit(3000);
        queryParam.setStart(0);
        queryParam.getParam().setCustomerId(this.getCustomer().getId());

        WebFileUtil web = new WebFileUtil(req,rsp);
        List<MakePlan> makePlans = this.makePlanService.findByQueryParam(queryParam);
        fillMakePlans(makePlans);
        rsp.setHeader("file","生产计划表.xlsx");
        web.export2EasyExcelObject("生产计划表.xlsx", buildTitles(),buildRecords(makePlans));

    }

    List<String> buildTitles(){
        List<String> strings=new ArrayList<>();

        //strings.add("发外标志");
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
            //r.add(MakePlanConst.getOutFlag(makePlan.getOutFlag()));
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

