package com.kunlong.dongxw.data.service.selfdef;

import com.kunlong.dongxw.data.domain.Trade;
import com.kunlong.dongxw.data.service.TradeService;

import java.math.BigDecimal;
import java.util.List;

public interface TradeServiceSelf extends TradeService {
    public BigDecimal sumFinish(Trade trade);
    List<Trade> queryFinishTradeIssue(int orderId, int productId);

    public List<Trade> findByMaster(Integer masterId);

    public long countByMaster(Integer masterId);

    public  int deleteByPKS(List<Integer> pks);
    public void batchInsert(List <Trade> trades);
 }
