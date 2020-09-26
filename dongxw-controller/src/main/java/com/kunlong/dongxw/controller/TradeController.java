package com.kunlong.dongxw.controller;


import app.support.query.PageQueryParam;
import app.support.query.PageResult;
import com.kunlong.dongxw.annotation.DateRewritable;
import com.kunlong.dongxw.consts.ApiConstants;
import com.kunlong.dongxw.data.dao.TradeMapper;
import com.kunlong.dongxw.data.domain.*;
import com.kunlong.dongxw.data.service.*;
import com.kunlong.dongxw.util.EasyExcelUtil;
import com.kunlong.platform.utils.JsonResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 交易主表
 * Package:
 * Author: cch/leijiming
 * Date: Created in 2018/8/23 16:50
 */
@RestController
@RequestMapping("/dongxw/trade")
public  class TradeController extends BaseController {
    @Autowired
    TradeMasterService tradeMasterService;

    @Autowired
    TradeService tradeService;
    @Autowired
    ProductService productService;
    @Autowired
    OrderMasterService orderMasterService;


    @PostMapping("/query")
    public PageResult<Trade> query(@RequestBody Trade.QueryParam queryParam) throws IOException {
        long total = tradeService.countByQueryParam(queryParam);
        //demo data
        PageQueryParam<Trade> pageQueryParam = new PageQueryParam();
        pageQueryParam.setParam(new Trade());
        PageResult<Trade> pageResult = total > 0 ? new PageResult<>() : new PageResult<>(pageQueryParam);

        pageResult.setTotal(total);
        pageResult.setData(tradeService.findByQueryParam(queryParam));

        for(Trade trade:pageResult.getData()) {
            Product product = productService.findById(trade.getProductId());
            trade.setProduct(product==null?new Product():product);
        }
        return pageResult;
    }


    @RequestMapping("/findById/{id}")
    public JsonResult<Trade> findById(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException {

        Trade trade = tradeService.findById(id);
        Product product = productService.findById(trade.getProductId());
        trade.setProduct(product==null?new Product():product);
        return JsonResult.success(trade);

    }

    void updateMasterCount(Integer masterId,Short count){
        TradeMaster tradeMaster=new TradeMaster();
        tradeMaster.setId(masterId);
        tradeMaster.setTradeCount(count);
        tradeMasterService.updateNotNullPropsById(tradeMaster);
    }

    @Autowired
    TradeMapper tradeMapper;
    @PostMapping("/deleteById/{id}")
    public JsonResult<Long> deleteById(@PathVariable("id") Integer id) throws IOException {
        Trade trade = tradeService.findById(id);
        tradeService.deleteById(id);
        if (trade != null) {
            Long c = tradeService.countByMaster(trade.getMasterId());
            updateMasterCount(trade.getMasterId(),c.shortValue());

            return JsonResult.success(c);
        }
        return JsonResult.success(0L);
    }


    public static class BatchTrade{
        public TradeMaster getTradeMaster() {
            return tradeMaster;
        }

        public void setTradeMaster(TradeMaster tradeMaster) {
            this.tradeMaster = tradeMaster;
        }

        public List<Integer> getProducts() {
            return products;
        }

        public void setProducts(List<Integer> products) {
            this.products = products;
        }

        public Integer getOrderId() {
            return orderId;
        }

        public void setOrderId(Integer orderId) {
            this.orderId = orderId;
        }

        private Integer orderId;

        private TradeMaster tradeMaster;
        private List<Integer> products;

        public List<OrderLine> getOrderLines() {
            return orderLines;
        }

        public void setOrderLines(List<OrderLine> orderLines) {
            this.orderLines = orderLines;
        }

        private List<OrderLine> orderLines;
    }

    @RequestMapping("/batchInsert")
    public JsonResult<Long> batchInsert(@RequestBody BatchTrade batchTrade) {

       List<Trade> trades = new ArrayList<>();

        for (OrderLine orderLine : batchTrade.getOrderLines()) {
            Trade trade = new Trade();
            trade.setMasterId(batchTrade.getTradeMaster().getId());
            trade.setOrderId(batchTrade.getOrderId());
            OrderMaster orderMaster = orderMasterService.findById(trade.getOrderId());

            trade.setOrderCode(orderMaster != null ? orderMaster.getCustomerOrderCode() : "");

            trade.setProductId(orderLine.getProductId());

            trade.setWh(batchTrade.getTradeMaster().getWh());
            trade.setYm(0);
            trade.setCustomerId(batchTrade.getTradeMaster().getCustomerId());
            trade.setMcId(batchTrade.getTradeMaster().getMcId());
            trade.setPoId(0);
            trade.setSupplyId(0);
            trade.setRemark("");
            trade.setStockType(0);
            // 数量
            trade.setQtyOrder(new BigDecimal(orderLine.getQty()));
            trade.setQtyBackup(BigDecimal.ZERO);
            trade.setQtyFinish(BigDecimal.ZERO);
            trade.setQty (BigDecimal.ZERO);

            trade.setPrice(orderLine.getPrice());
            trade.setMoney(BigDecimal.ZERO);
            trade.setCreateBy(getCurrentUserId());
            trade.setCreateDate(new Date());
            trades.add(trade);
           //tradeService.save( trade );
        }
        tradeService.batchInsert(trades);

        Long c = tradeService.countByMaster(batchTrade.getTradeMaster().getId());
        updateMasterCount(batchTrade.getTradeMaster().getId(),c.shortValue());
        return JsonResult.success(c);

    }

    @RequestMapping("/save")
    public JsonResult<Integer> save(@RequestBody Trade trade) {
        trade.setMoney(trade.getPrice().multiply(trade.getQty()));
        if (trade.getId() == null) {
            trade.setCreateBy(getCurrentUserId());
            trade.setCreateDate(new Date());
            tradeService.save(trade);
        } else {
            tradeService.update(trade);
        }
        return JsonResult.success( trade.getId());

    }



}

