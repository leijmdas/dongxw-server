package com.kunlong.dongxw.data.service.selfdef;

import com.alibaba.dubbo.config.annotation.Service;
import com.kunlong.dongxw.consts.TradeTypeConsts;
import com.kunlong.dongxw.data.dao.TradeMapper;
import com.kunlong.dongxw.data.domain.Trade;
import com.kunlong.dongxw.data.service.TradeService;
import com.kunlong.dongxw.data.service.impl.TradeServiceImpl;
import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TradeServiceSelfImpl extends TradeServiceImpl implements TradeServiceSelf {
    @Autowired
    private TradeMapper repo;

    @Override
    public List<Trade> queryFinishTradeIssue(int orderId, int productId) {
        Trade.QueryParam queryParam = new Trade.QueryParam();
        queryParam.setLimit(-1);
        queryParam.setParam(new Trade());
        queryParam.getParam().setOrderId(orderId);
        queryParam.getParam().setProductId(productId);
        queryParam.getParam().setTradeType(TradeTypeConsts.TradeTYPE_ISSUE);
        return findByQueryParam(queryParam);
    }

    public List<Trade> findByMaster(Integer masterId){
        Trade.QueryParam queryParam=new Trade.QueryParam();
        queryParam.setParam(new Trade());
        queryParam.getParam().setMasterId(masterId);
        return repo.findByQueryParam(queryParam);
    }


    public long countByMaster(Integer masterId) {


        SelectStatement<Trade> selectStatement = SelectStatement.newInstance(Trade.EntityNode.INSTANCE);
        selectStatement.setPageRange(0, 1);
        selectStatement.getRestrictions().add(Trade.EntityNode.INSTANCE.masterId.eq(masterId));

        return repo.countByRestrictions(selectStatement.getRestrictions());

    }
    public  int deleteByPKS(List<Integer> pks){
        return repo.deleteByPKS(pks);
    }
    @Override
    public void batchInsert(List<Trade> trades) {
        repo.batchInsert(trades);

    }


    public BigDecimal sumFinish(Trade trade) {
        List<Trade> trades = queryFinishTradeIssue(trade.getOrderId(), trade.getProductId());
        BigDecimal sum = BigDecimal.ZERO;
        for (Trade t : trades) {
            if (t.getId() < trade.getId()) {
                sum = sum.add(t.getQty());
            }
        }
        return sum;
    }
}
