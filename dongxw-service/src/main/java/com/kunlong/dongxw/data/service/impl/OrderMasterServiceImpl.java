package com.kunlong.dongxw.data.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.kunlong.dongxw.data.dao.OrderLineMapper;
import com.kunlong.dongxw.data.service.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kunlong.dongxw.data.domain.OrderMaster;
import com.kunlong.dongxw.data.dao.OrderMasterMapper;
import com.kunlong.dongxw.data.service.OrderMasterService;
import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.mybatis.hbatis.orm.criteria.statement.UpdateStatement;
import org.mybatis.hbatis.orm.criteria.support.StatementBuilder;
/**
 * OrderMasterServiceImpl
 * @author generator
 * @date 2020年11月07日
 */
@Service
public class OrderMasterServiceImpl implements OrderMasterService {
	@Autowired
	private OrderLineService orderLineService;

	@Autowired
	private OrderMasterMapper repo;
	/**
	 * 保存
	 * @param entity
	 */
	public void save(OrderMaster entity){
		this.checkEntity(entity);
		repo.insert(entity);
	}

	/**
	 * 修改
	 * @param entity
	 */
	public void update(OrderMaster entity){
		this.checkEntity(entity);
		repo.update(entity);
	}
	/**
	 * 较验实体
	 * @param entity
	 */
	public void checkEntity(OrderMaster entity){
	
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(Integer pk){
		repo.deleteByPK(pk);
	}

	public BigDecimal computeTotal(Integer pk) {
		BigDecimal sum = orderLineService.computeTotal(pk);
		OrderMaster orderMaster = new OrderMaster();
		orderMaster.setId(pk);
		orderMaster.setTotalMoney(sum);
		updateNotNullPropsById(orderMaster);
		return  sum;
	}

	/**
	 * 通过id获取
	 * @param id
	 * @return
	 */
	public OrderMaster findById(Integer pk){
		return repo.selectByPK(pk);
	}
	/**
	 * 通过非空属性查询
	 * @param OrderMaster
	 * @return
	 */
	public List<OrderMaster> findByNotNullProps(OrderMaster entity){
		
		SelectStatement<OrderMaster> st = StatementBuilder.buildSelectSelective(entity);
		return repo.selectByStatement(st);
	}
	/**
	 * 通过主键更新非空属性
	 * @param OrderMaster
	 * @return
	 */
	public void updateNotNullPropsById(OrderMaster entity){
		
		UpdateStatement<OrderMaster> st = StatementBuilder.buildUpdateSelective(entity);
		repo.updateByStatement(st);
	}
	
	/**
	 * 通过实体参数分页查询
	 * @param OrderMaster.QueryParam
	 * @return
	 */
	public List<OrderMaster> findByQueryParam(OrderMaster.QueryParam queryParam){
		return repo.findByQueryParam(queryParam);
	}
	/**
	 * 通过实体参数统计
	 * @param OrderMaster.QueryParam
	 * @return
	 */
	public long countByQueryParam(OrderMaster.QueryParam queryParam) {
		return repo.countByQueryParam(queryParam);
	}
	/**
	 * 通过ID集合查询
	 * @param List<Integer> pks
	 * @return
	 */
	public List<OrderMaster> findByIds(List<Integer> pks) {
		return repo.selectByPKS(pks);
	}
	/**
	 * 值填充
	 */
	public void fillValues(List<OrderMaster> items, OrderMaster.ValueField... field) {
		if (items == null || items.isEmpty() || field.length < 1) {
			return;
		}
	}
}
