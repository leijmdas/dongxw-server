package com.kunlong.dongxw.controller;


import app.support.query.PageResult;
import com.alibaba.dubbo.config.annotation.Reference;
import com.kunlong.dongxw.annotation.DateRewritable;
import com.kunlong.dongxw.config.DongxwTransactional;
import com.kunlong.dongxw.consts.ApiConstants;
import com.kunlong.dongxw.consts.MoneyTypeConsts;
import com.kunlong.dongxw.data.domain.*;
import com.kunlong.dongxw.data.service.*;
import com.kunlong.dongxw.data.service.selfdef.TradeServiceSelf;
import com.kunlong.dongxw.util.EasyExcelUtil;
import com.kunlong.dongxw.util.EasyPOIUtil;
import com.kunlong.dongxw.util.SimpleSequenceGenerator;
import com.kunlong.dubbo.rpt.EasyPOIUtilApiService;
import com.kunlong.platform.utils.JsonResult;
import com.kunlong.platform.utils.KunlongUtils;
//import com.kunlong.report.EasyPOI41Util;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
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

    @Reference(lazy = true, version = "${dubbo.service.version}")
    EasyPOIUtilApiService easyPOIUtilApiService;

    @Autowired
    CustomerService customerService;
    @Autowired
    OrderMasterService  orderMasterService;

    @Autowired
    TradeMasterService tradeMasterService;
    @Autowired
    ProductService productService;

    @Autowired
    TradeServiceSelf tradeService;

    @PostMapping("/selectCustomerByYm")
    public PageResult<TradeMaster> selectCustomerByYm(@RequestBody TradeMaster.QueryParam queryParam) throws IOException {
        PageResult<TradeMaster> pageResult = new PageResult<>();
        if(queryParam.getParam().getYm()==null){
            queryParam.getParam().setYm(-1);
        }
        List<TradeMaster> tradeMasters = tradeMasterService.selectCustomerByYm(queryParam.getParam().getYm());

        pageResult.setTotal(tradeMasters.size());
        pageResult.setData(tradeMasters);

        return pageResult;
    }
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
            Integer  i=tradeMaster.getId()+10000;
            String s=StringUtils.reverse(i.toString()).substring(0,4);
            tradeMaster.setCode( "EP" + transDateShort(new Date())+StringUtils.reverse(s));
            tradeMasterService.update(tradeMaster);

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

        //return easyPOIUtilApiService.makeExcelSheet("issue_template.xlsx",fileName,sheetName,JSON.toJSONString(map));
        return EasyPOIUtil.makeExcelSheet("issue_template.xlsx",fileName,sheetName,map);
    }

    public String writeCheckSheet2File(TradeMaster tradeMaster, String sheetName, List<Trade> trades, String fileName) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> info = new LinkedHashMap();
        map.put("info", info);
        info.put("includeTax","含税");
        info.put("custName", tradeMaster.getCustName());
        info.put("ym", tradeMaster.getYm());
        info.put("sum", "0.0");
        info.put("ymStart", KunlongUtils.transDate(getFirstDayOfMonth(tradeMaster.getTradeTime())));
        info.put("ymEnd", KunlongUtils.transDate(getLastDayOfMonth(tradeMaster.getTradeTime())));
        info.put("toDay", KunlongUtils.transDate(new Date()));

        // 送货日期	单号	 产品名称	规格	 单位	数量	单价	金额	备注

        List<Map<String, Object>> mapList = new ArrayList<>();
        BigDecimal sum = KunlongUtils.newBigDecimal(0);
        Map<Integer,OrderMaster> masterMap=new LinkedHashMap<>();

        for (Trade trade : trades) {
            if (!masterMap.containsKey(trade.getOrderId())) {
                orderMasterService.computeTotal(trade.getOrderId());
                OrderMaster orderMaster = orderMasterService.findById(trade.getOrderId());
                masterMap.put(trade.getOrderId(), orderMaster);
            }
            sheetName = tradeMaster.getCustName()+tradeMaster.getYm()+"对帐单" ;
            Map<String, Object> row = new LinkedHashMap<>();

            row.put("tradeTime", KunlongUtils.transDate(trade.getTradeMaster().getTradeTime()));
            row.put("tradeCode", trade.getTradeMaster().getCode());
            row.put("orderCode", trade.getOrderCode());

            row.put("code", trade.getProduct().getCode());
            row.put("remark", trade.getProduct().getRemark());
            row.put("size", trade.getProduct().getSize());
            row.put("unit", trade.getProduct().getUnit());
            row.put("qty", trade.getQty().longValue());
            row.put("price", trade.getPrice().toString());
            row.put("money", trade.getMoney().toString());
            row.put("orderCode",masterMap.get(trade.getOrderId()).getCustomerOrderCode());
            row.put("code",trade.getProduct().getCode());
            row.put("includeTax",masterMap.get(trade.getOrderId()).getIncludeTax()?"含税":"不含税");
            row.put("moneyType", MoneyTypeConsts.getMoneyType(masterMap.get(trade.getOrderId()).getMoneyType()));
            row.put("orderMoney", masterMap.get(trade.getOrderId()).getOrderMoney());
            BigDecimal leftMoney = masterMap.get(trade.getOrderId()).getTotalMoney().subtract(masterMap.get(trade.getOrderId()).getOrderMoney());
            row.put("leftMoney", leftMoney);

            row.put("memo", trade.getRemark());
            mapList.add(row);
            sum= sum.add(trade.getMoney());
        }
        info.put("sum", sum.toString());
        info.put("list", mapList);
        //System.out.println(KunlongUtils.toJSONStringPretty(info));

        return EasyPOIUtil.makeExcelSheet("checksheet_template.xlsx",fileName,sheetName,map);
    }
    @RequestMapping(value = "exportCheckSheet", method = RequestMethod.POST)
    @ApiOperation(value = "exportCheckSheet", notes = "exportCheckSheet", authorizations = {@Authorization(value = ApiConstants.AUTH_API_WEB)})
    public void exportCheckSheet(@RequestBody @DateRewritable TradeMaster.QueryParam queryParam, HttpServletRequest req, HttpServletResponse rsp) throws Exception {

        List<TradeMaster> tradeMasters=tradeMasterService.findByQueryParam(queryParam);

        TradeMaster master = tradeMasters.get(0);//radeMasterService.findById(tradeMasters.get(0).getId());
        List<Trade> result = tradeService.findByMaster(-1);

        for(TradeMaster tradeMaster:tradeMasters) {
            List<Trade>  trades = tradeService.findByMaster(tradeMaster.getId());
            for (Trade trade : trades) {
                Product product = productService.findById(trade.getProductId());
                trade.setProduct(product == null ? new Product() : product);
                trade.setTradeMaster(tradeMaster);
            }
            result.addAll(trades);
        }
        String fn = master.getCustName() +"-"+ master.getYm() + "对帐单" + ".xlsx";
        String fnNew = writeCheckSheet2File(master, "对帐单", result, fn);

        EasyExcelUtil.writeExcel2Response(fn, rsp, fnNew);

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
            trade.setQtyFinish(tradeService.sumFinish(trade));

        }

        String fn= tradeMaster.getCustName()+"送货单"+tradeMaster.getCode()+".xlsx";
        String fnNew = writeTradeIssue2File(tradeMaster,"送货单"+tradeMaster.getCode(), trades, fn);

        EasyExcelUtil.writeExcel2Response(fn, rsp, fnNew);

    }
}

