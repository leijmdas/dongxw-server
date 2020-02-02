package com.kunlong.dongxw.controller;


import app.support.query.PageResult;
import cn.kunlong.center.api.model.SysUserDTO;
import com.kunlong.dongxw.annotation.DateRewritable;
import com.kunlong.dongxw.consts.ApiConstants;
import com.kunlong.dongxw.consts.MakePlanConst;
import com.kunlong.dongxw.dongxw.domain.Bom;
import com.kunlong.dongxw.dongxw.domain.BomCost;
import com.kunlong.dongxw.dongxw.domain.MakePlan;
import com.kunlong.dongxw.dongxw.domain.Product;
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
@RequestMapping("/dongxw/bomcost")
public  class BomCostController extends BaseController {
    @Autowired
    BomCostService bomCostService;


    //检查有计划
    @PostMapping("/deleteById/{id}")
    public JsonResult<Integer> deleteById(@PathVariable("id") Integer id) throws IOException {

        bomCostService.deleteById(id);

        return JsonResult.success();
    }

    @RequestMapping("/findById/{id}")
    public JsonResult<BomCost> findById(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException {
        BomCost bom = bomCostService.findById(id);

        return JsonResult.success(bom);

}

    @RequestMapping("/save")
    public JsonResult<Integer> save(@RequestBody BomCost bom) {

        // bom.setMoney(bom.getPrice().multiply(bom.getQty()));
        bom.setTotalFee(bom.getRmFee().add(bom.getCutRm()).add(bom.getShippingFee())
                .add(bom.getKnifeModel()).add(bom.getLossRm()).add(bom.getWorkFee()));
        if (bom.getId() == null) {
            bom.setCreateBy(getCurrentUserId());
            bom.setCreateDate(new Date());
            bomCostService.save(bom);
        } else {
            bomCostService.update(bom);
        }

        return JsonResult.success(bom.getId());
    }


    @PostMapping("/query")
    public PageResult<BomCost> query(@RequestBody BomCost.QueryParam queryParam) throws IOException {
        PageResult<BomCost> pageResult = new PageResult<BomCost>();

        queryParam.setSortBys("id|desc");
        pageResult.setTotal(bomCostService.countByQueryParam(queryParam));
        pageResult.setData(bomCostService.findByQueryParam(queryParam));
        for(BomCost bom:pageResult.getData()){

            SysUserDTO sysUserDTO = sysUserApiService.findById(bom.getCreateBy());
            //bom.setCreateByName(sysUserDTO==null?"-":sysUserDTO.getUsername());
        }
        return pageResult;
    }





}

