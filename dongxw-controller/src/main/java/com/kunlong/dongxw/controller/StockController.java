package com.kunlong.dongxw.controller;


import app.support.query.PageResult;
import com.kunlong.dongxw.annotation.DateRewritable;
import com.kunlong.dongxw.config.DongxwTransactional;
import com.kunlong.dongxw.consts.ApiConstants;
import com.kunlong.dongxw.data.domain.Bom;
import com.kunlong.dongxw.data.domain.MonthClose;
import com.kunlong.dongxw.data.domain.TradeMaster;
import com.kunlong.dongxw.data.domain.WhStock;
import com.kunlong.dongxw.data.service.MonthCloseService;
import com.kunlong.dongxw.data.service.TradeMasterService;
import com.kunlong.dongxw.data.service.WhStockService;
import com.kunlong.dongxw.data.service.WharehouseService;
import com.kunlong.platform.utils.JsonResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 库存
 * Package:
 * Author: cch/leijiming
 * Date: Created in 2018/8/23 16:50
 */
@RestController
@RequestMapping("/dongxw/whstock")
public  class StockController extends BaseController {
    @Autowired

    WhStockService whStockService;


    @PostMapping("/query")
    public PageResult<WhStock> query(@RequestBody WhStock.QueryParam queryParam) throws IOException {
        PageResult<WhStock> pageResult = new PageResult<>();

        pageResult.setTotal(whStockService.countByQueryParam(queryParam));
        pageResult.setData(whStockService.findByQueryParam(queryParam));

        return pageResult;
    }


    @PostMapping("/deleteById/{id}")
    public JsonResult<Integer> deleteById(@PathVariable("id") Integer id) throws IOException {

        whStockService.deleteById(id);
        return JsonResult.success(id);
    }

    @RequestMapping("/findById/{id}")
    public JsonResult<WhStock> findById(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException {
        WhStock whStock=whStockService.findById(id);
        return JsonResult.success(whStock );

    }



    @RequestMapping("/save")
    public JsonResult<Integer> save(@RequestBody WhStock whStock) {
        whStockService.save(whStock);
        return JsonResult.success( whStock.getId());

    }



    // JSON.parseObject(KunlongUtils.toJSONString(boms),             new TypeReference<List<BomExcelModel>>() {
    @RequestMapping(value = "export", method = RequestMethod.POST)
    @ApiOperation(value = "export", notes = "export", authorizations = {@Authorization(value = ApiConstants.AUTH_API_WEB)})
    public void export(@RequestBody @DateRewritable Bom.QueryParam queryParam, HttpServletRequest req, HttpServletResponse rsp) throws Exception {

    }

}

