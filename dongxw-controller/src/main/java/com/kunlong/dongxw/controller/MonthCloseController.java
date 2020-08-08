package com.kunlong.dongxw.controller;


import app.support.query.PageResult;
import com.kunlong.dongxw.annotation.DateRewritable;
import com.kunlong.dongxw.config.DongxwTransactional;
import com.kunlong.dongxw.consts.ApiConstants;
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
@RequestMapping("/dongxw/monthclose")
public  class MonthCloseController extends BaseController {
    @Autowired

    MonthCloseService monthCloseService;

    @PostMapping("/query")
    public PageResult<MonthClose> query(@RequestBody MonthClose.QueryParam queryParam) throws IOException {
        PageResult<MonthClose> pageResult = new PageResult<>();
          queryParam.setSortBys("ym|desc");
        //queryParam.setParam(new MonthClose());

        pageResult.setTotal(monthCloseService.countByQueryParam(queryParam));
        pageResult.setData(monthCloseService.findByQueryParam(queryParam));

        return pageResult;
    }

    @PostMapping("/balance/{id}")
    @DongxwTransactional
    public JsonResult<Integer> balance(@PathVariable("id") Integer id) throws IOException {

        return JsonResult.success();
    }

    int findLastYm(){
        MonthClose.QueryParam queryParam = new MonthClose.QueryParam();
        queryParam.setSortBys("ym|desc");
        queryParam.setLimit(1);

        List<MonthClose> monthCloseList =  monthCloseService.findByQueryParam(queryParam);
        if(monthCloseList.size()==0){
            return -1;
        }
        return monthCloseList.get(0).getYm();
    }

    int nextYm(int ym) {
        int y = ym / 100;
        int m = ym % 100;
        if (m < 12) {
            m++;
        } else {
            y++;
            m = 1;
        }
        return y * 100 + m;
    }


    @PostMapping("/mc/{id}")
    @DongxwTransactional
    public JsonResult<Integer> mc(@PathVariable("id") Integer id) throws IOException {
        PageResult<MonthClose> pageResult = new PageResult<>();
        MonthClose.QueryParam queryParam = new MonthClose.QueryParam();
        queryParam.setSortBys("ym|desc");
        queryParam.setLimit(1);

        MonthClose monthClose = monthCloseService.findById(id);//monthCloseService.findByQueryParam(queryParam);
        if (monthClose != null && !monthClose.getCloseFlag() ) {
            monthClose.setCloseFlag(true);
            monthCloseService.update(monthClose);

            monthClose.setId(null);
            int ym = monthClose.getYm();
            monthClose.setYm(nextYm(ym));
            monthClose.setCloseFlag(false);
            monthCloseService.save(monthClose);
            return JsonResult.success(monthClose.getYm());
        }

        return JsonResult.success();
    }



    @RequestMapping("/findById/{id}")
    public JsonResult<Bom> findById(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException {

        return JsonResult.success( );

    }

    @RequestMapping("/saveByIds")
    @DongxwTransactional
    public JsonResult<List<Integer>> saveByIds(@RequestBody Bom bom) {

        return JsonResult.success( );
    }

    @RequestMapping("/save")
    public JsonResult<Integer> save(@RequestBody Bom bom) {

        return JsonResult.success( );

    }



    // JSON.parseObject(KunlongUtils.toJSONString(boms),             new TypeReference<List<BomExcelModel>>() {
    @RequestMapping(value = "export", method = RequestMethod.POST)
    @ApiOperation(value = "export", notes = "export", authorizations = {@Authorization(value = ApiConstants.AUTH_API_WEB)})
    public void export(@RequestBody @DateRewritable Bom.QueryParam queryParam, HttpServletRequest req, HttpServletResponse rsp) throws Exception {

    }


}

