package com.kunlong.dongxw.data.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kunlong.dongxw.data.domain.Trade;
import com.kunlong.dongxw.data.dao.TradeMapper;
import com.kunlong.dongxw.data.service.TradeService;
import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.mybatis.hbatis.orm.criteria.statement.UpdateStatement;
import org.mybatis.hbatis.orm.criteria.support.StatementBuilder;
/**
 * TradeServiceImpl
 * @author generator
 * @date 2020年09月26日
 */
@Service
public class TradeServiceImpl implements TradeService {
	
	@Autowired
	private TradeMapper repo;
	/**
	 * 保存
	 * @param entity
	 */
	public void save(Trade entity){
		this.checkEntity(entity);
		repo.insert(entity);
	}

	@Override
	public void batchInsert(List<Trade> trades) {
		repo.batchInsert(trades);

	}

	/**
	 * 修改
	 * @param entity
	 */
	public void update(Trade entity){
		this.checkEntity(entity);
		repo.update(entity);
	}
	/**
	 * 较验实体
	 * @param entity
	 */
	public void checkEntity(Trade entity){
	
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(Integer pk){
		repo.deleteByPK(pk);
	}
	public  int deleteByPKS(List<Integer> pks){
		return repo.deleteByPKS(pks);
	}

	/**
	 * 通过id获取
	 * @param id
	 * @return
	 */
	public Trade findById(Integer pk){
		return repo.selectByPK(pk);
	}
	/**
	 * 通过非空属性查询
	 * @param Trade
	 * @return
	 */
	public List<Trade> findByNotNullProps(Trade entity){
		
		SelectStatement<Trade> st = StatementBuilder.buildSelectSelective(entity);
		return repo.selectByStatement(st);
	}
	/**
	 * 通过主键更新非空属性
	 * @param Trade
	 * @return
	 */
	public void updateNotNullPropsById(Trade entity){
		
		UpdateStatement<Trade> st = StatementBuilder.buildUpdateSelective(entity);
		repo.updateByStatement(st);
	}
	
	/**
	 * 通过实体参数分页查询
	 * @param Trade.QueryParam
	 * @return
	 */
	public List<Trade> findByQueryParam(Trade.QueryParam queryParam){
		return repo.findByQueryParam(queryParam);
	}

	public List<Trade> findByMaster(Integer masterId){
		Trade.QueryParam queryParam=new Trade.QueryParam();
		queryParam.setParam(new Trade());
		queryParam.getParam().setMasterId(masterId);
		return repo.findByQueryParam(queryParam);
	}
	/**
	 * 通过实体参数统计
	 * @param Trade.QueryParam
	 * @return
	 */
	public long countByQueryParam(Trade.QueryParam queryParam) {
		return repo.countByQueryParam(queryParam);
	}

	public long countByMaster(Integer masterId) {

		//Trade entity=new Trade();
		//SelectStatement<Trade> st = StatementBuilder.buildSelectSelective(entity);

		SelectStatement<Trade> selectStatement = SelectStatement.newInstance(Trade.EntityNode.INSTANCE);
		selectStatement.setPageRange(0, 1);
		selectStatement.getRestrictions().add(Trade.EntityNode.INSTANCE.masterId.eq(masterId));

		return repo.countByRestrictions(selectStatement.getRestrictions());

	}

	/**
	 * 通过ID集合查询
	 * @param List<Integer> pks
	 * @return
	 */
	public List<Trade> findByIds(List<Integer> pks) {
		return repo.selectByPKS(pks);
	}
	/**
	 * 值填充
	 */
	public void fillValues(List<Trade> items, Trade.ValueField... field) {
		if (items == null || items.isEmpty() || field.length < 1) {
			return;
		}
	}
}
