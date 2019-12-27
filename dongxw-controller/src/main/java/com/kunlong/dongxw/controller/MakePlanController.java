package com.kunlong.dongxw.controller;


import app.support.query.PageResult;
import com.kunlong.api.service.AuthApiService;
import com.kunlong.dongxw.annotation.DateRewritable;
import com.kunlong.dongxw.consts.ApiConstants;
import com.kunlong.dongxw.consts.MoneyTypeConsts;
import com.kunlong.dongxw.dongxw.domain.Customer;
import com.kunlong.dongxw.dongxw.domain.MakePlan;
import com.kunlong.dongxw.dongxw.service.CustomerService;
import com.kunlong.dongxw.dongxw.service.MakePlanService;
import com.kunlong.dongxw.util.WebFileUtil;
import com.kunlong.platform.utils.JsonResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.apache.dubbo.config.annotation.Reference;
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
@RequestMapping("/dongxw/makeplan")
public final class MakePlanController {
    @Autowired
    MakePlanService makePlanService;


    @RequestMapping("/findById/{id}")
    public JsonResult<MakePlan> findById(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException {
         return   JsonResult.success(makePlanService.findById(id))    ;
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
        // Customer.QueryParam qp = BeanMapper.getInstance().map(pageResult, Customer.QueryParam.class);

        pageResult.setTotal(makePlanService.countByQueryParam(queryParam));
        pageResult.setData(makePlanService.findByQueryParam(queryParam));
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
        strings.add("颜色");

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
            r.add(makePlan.getColor());

            //r.add(transDate(customer.getCreateDate()));

            records.add(r);
        }
        return records;
    }

}

