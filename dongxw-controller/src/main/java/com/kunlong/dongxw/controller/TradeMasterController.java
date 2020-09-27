package com.kunlong.dongxw.controller;


import app.support.query.PageResult;
import com.kunlong.dongxw.annotation.DateRewritable;
import com.kunlong.dongxw.config.DongxwTransactional;
import com.kunlong.dongxw.consts.ApiConstants;
import com.kunlong.dongxw.consts.MakePlanConst;
import com.kunlong.dongxw.data.domain.*;
import com.kunlong.dongxw.data.service.*;
import com.kunlong.dongxw.util.EasyExcelUtil;
import com.kunlong.dongxw.util.EasyPOIUtil;
import com.kunlong.dongxw.util.SimpleSequenceGenerator;
import com.kunlong.platform.utils.JsonResult;
import com.kunlong.platform.utils.KunlongUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 交易主表
 * Package:
 * Author: cch/leijiming
 * Date: Created in 2018/8/23 16:50
 */
@RestController
@RequestMapping("/dongxw/master")
public  class TradeMasterController extends BaseController {
    @Autowired
    TradeMasterService tradeMasterService;
    @Autowired
    ProductService productService;

    @Autowired
    TradeService tradeService;

    @PostMapping("/query")
    public PageResult<TradeMaster> query(@RequestBody TradeMaster.QueryParam queryParam) throws IOException {
        PageResult<TradeMaster> pageResult = new PageResult<>();
        queryParam.setSortBys(queryParam.getOrderBys());
        pageResult.setTotal(tradeMasterService.countByQueryParam(queryParam));
        pageResult.setData(tradeMasterService.findByQueryParam(queryParam));

        return pageResult;
    }


    @PostMapping("/deleteById/{id}")
    @DongxwTransactional
    public JsonResult<Integer> deleteById(@PathVariable("id") Integer id) throws IOException {

        List<Trade> trades = tradeService.findByMaster(id);
        if (trades != null && trades.size() > 0) {
            List<Integer> pks = trades.stream().map(item -> item.getId()).collect(Collectors.toList());
            tradeService.deleteByPKS(pks);
        }

        tradeMasterService.deleteById(id);
        return JsonResult.success(id);
    }

    @RequestMapping("/findById/{id}")
    public JsonResult<TradeMaster> findById(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException {
        TradeMaster tradeMaster=tradeMasterService.findById(id);
        return JsonResult.success(tradeMaster );

    }


    @RequestMapping("/save")
    public JsonResult<Integer> save(@RequestBody TradeMaster tradeMaster) {

        if (tradeMaster.getId() == null) {
            String code = "EP" + transDate(new Date()) + "-" + SimpleSequenceGenerator.generateIssueCode("P");
            tradeMaster.setCode(code);
            tradeMaster.setTradeCount(Short.valueOf("0"));
            tradeMasterService.save(tradeMaster);
        } else {
            tradeMasterService.update(tradeMaster);
        }

        return JsonResult.success(tradeMaster.getId());

    }

    // 采购订单号	物料代码	规格描述	订单数量	已发货量	订单余数	单位	备品	备注

    public String writeTradeIssue2File(TradeMaster tradeMaster,String sheetName, List<Trade> trades, String fileName) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        Map <String, Object> info=new LinkedHashMap();
        map.put("info",info);
        info.put("tradeTime",KunlongUtils.transDate(tradeMaster.getTradeTime()));
        info.put("custName", tradeMaster.getCustName());
        info.put("issueAddr",tradeMaster.getIssueAddr());
        info.put("code",tradeMaster.getCode());
        info.put("issueWh",tradeMaster.getIssueWh());

        info.put("contact",tradeMaster.getContact());
        info.put("tel",tradeMaster.getTel());

        info.put("payMode",tradeMaster.getPayMode());

        List<Map<String, Object>> mapList = new ArrayList<>();
        for (Trade trade : trades) {
            sheetName = tradeMaster.getCustName()+"送货单"+tradeMaster.getCode();
            Map<String, Object> row = new LinkedHashMap<>();

            row.put("orderCode", trade.getOrderCode());
            row.put("unit", trade.getProduct().getUnit());

            row.put("code", trade.getProduct().getCode());
            row.put("remark", trade.getProduct().getRemark());
            //row.put("color", trade.getProduct().getColor());
            row.put("memo", trade.getRemark());
            row.put("qty", trade.getQty().longValue());
            row.put("qtyOrder", trade.getQtyOrder().longValue());
            row.put("qtyFinish", trade.getQtyFinish().longValue());
            row.put("qtyBackup", trade.getQtyBackup().longValue());

            mapList.add(row);
        }
        info.put("list", mapList);
        //System.out.println(KunlongUtils.toJSONStringPretty(info));

        return EasyPOIUtil.makeExcelSheet("issue_template.xlsx",fileName,sheetName,map);
    }

    @RequestMapping(value = "export", method = RequestMethod.POST)
    @ApiOperation(value = "export", notes = "export", authorizations = {@Authorization(value = ApiConstants.AUTH_API_WEB)})
    public void export(@RequestBody @DateRewritable TradeMaster.QueryParam queryParam, HttpServletRequest req, HttpServletResponse rsp) throws Exception {
        TradeMaster tradeMaster = tradeMasterService.findById(queryParam.getParam().getId());
        if (tradeMaster == null) {
            throw new RuntimeException("送货单不存在！");

        }
        List<Trade> trades = tradeService.findByMaster(tradeMaster.getId());
        for (Trade trade : trades) {
            Product product = productService.findById(trade.getProductId());
            trade.setProduct(product == null ? new Product() : product);
        }

        String fn= tradeMaster.getCustName()+"送货单"+tradeMaster.getCode()+".xlsx";
        String fnNew = writeTradeIssue2File(tradeMaster,"送货单"+tradeMaster.getCode(), trades, fn);

        EasyExcelUtil.writeExcel2Response(fn, rsp, fnNew);

    }

}

