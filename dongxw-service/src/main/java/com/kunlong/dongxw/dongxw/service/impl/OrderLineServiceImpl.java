package com.kunlong.dongxw.dongxw.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kunlong.dongxw.dongxw.domain.OrderLine;
import com.kunlong.dongxw.dongxw.dao.OrderLineMapper;
import com.kunlong.dongxw.dongxw.service.OrderLineService;
import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.mybatis.hbatis.orm.criteria.statement.UpdateStatement;
import org.mybatis.hbatis.orm.criteria.support.StatementBuilder;
/**
 * OrderLineServiceImpl
 * @author generator
 * @date 2020年01月01日
 */
@Service
public class OrderLineServiceImpl implements OrderLineService {
	
	@Autowired
	private OrderLineMapper repo;
	/**
	 * 保存
	 * @param entity
	 */
	public void save(OrderLine entity){
		this.checkEntity(entity);
		repo.insert(entity);
	}

	/**
	 * 修改
	 * @param entity
	 */
	public void update(OrderLine entity){
		this.checkEntity(entity);
		repo.update(entity);
	}
	/**
	 * 较验实体
	 * @param entity
	 */
	public void checkEntity(OrderLine entity){
	
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(Integer pk){
		repo.deleteByPK(pk);
	}
	
	/**
	 * 通过id获取
	 * @param id
	 * @return
	 */
	public OrderLine findById(Integer pk){
		return repo.selectByPK(pk);
	}
	/**
	 * 通过非空属性查询
	 * @param OrderLine
	 * @return
	 */
	public List<OrderLine> findByNotNullProps(OrderLine entity){
		
		SelectStatement<OrderLine> st = StatementBuilder.buildSelectSelective(entity);
		return repo.selectByStatement(st);
	}
	/**
	 * 通过主键更新非空属性
	 * @param OrderLine
	 * @return
	 */
	public void updateNotNullPropsById(OrderLine entity){
		
		UpdateStatement<OrderLine> st = StatementBuilder.buildUpdateSelective(entity);
		repo.updateByStatement(st);
	}
	
	/**
	 * 通过实体参数分页查询
	 * @param OrderLine.QueryParam
	 * @return
	 */
	public List<OrderLine> findByQueryParam(OrderLine.QueryParam queryParam){
		return repo.findByQueryParam(queryParam);
	}
	/**
	 * 通过实体参数统计
	 * @param OrderLine.QueryParam
	 * @return
	 */
	public long countByQueryParam(OrderLine.QueryParam queryParam) {
		return repo.countByQueryParam(queryParam);
	}
	/**
	 * 通过ID集合查询
	 * @param List<Integer> pks
	 * @return
	 */
	public List<OrderLine> findByIds(List<Integer> pks) {
		return repo.selectByPKS(pks);
	}
	/**
	 * 值填充
	 */
	public void fillValues(List<OrderLine> items, OrderLine.ValueField... field) {
		if (items == null || items.isEmpty() || field.length < 1) {
			return;
		}
	}
}
