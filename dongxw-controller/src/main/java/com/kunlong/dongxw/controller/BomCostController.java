package com.kunlong.dongxw.controller;


import app.support.query.PageResult;
import com.kunlong.dubbo.sys.model.SysUserDTO;
import com.kunlong.dongxw.data.domain.BomCost;
import com.kunlong.dongxw.data.service.*;
import com.kunlong.platform.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

    @Autowired
    BomService bomService;
    @Autowired
    BomJoinService bomJoinService;

    //检查有计划
    @PostMapping("/deleteById/{id}")
    public JsonResult<Integer> deleteById(@PathVariable("id") Integer id) throws IOException {

        bomCostService.deleteById(id);

        return JsonResult.success();
    }

    @RequestMapping("/findByByProduct/{id}")
    public JsonResult<BomCost> findByByProduct(@PathVariable("id") Integer productId) throws IOException {

        return bomJoinService.findBomCostByProduct(productId);

    }

    @RequestMapping("/findById/{id}")
    public JsonResult<BomCost> findById(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException {
        BomCost bom = bomCostService.findById(id);

        return JsonResult.success(bom);

    }

    @RequestMapping("/save")
    public JsonResult<Integer> save(@RequestBody BomCost bom) {
        bom.setCreateBy(getCurrentUserId());
        Integer id = bomJoinService.save(bom);

        return JsonResult.success(id);
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

