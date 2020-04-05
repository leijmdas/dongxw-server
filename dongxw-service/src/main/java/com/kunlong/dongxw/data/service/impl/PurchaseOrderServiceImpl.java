package com.kunlong.dongxw.data.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kunlong.dongxw.data.domain.PurchaseOrder;
import com.kunlong.dongxw.data.dao.PurchaseOrderMapper;
import com.kunlong.dongxw.data.service.PurchaseOrderService;
import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.mybatis.hbatis.orm.criteria.statement.UpdateStatement;
import org.mybatis.hbatis.orm.criteria.support.StatementBuilder;
/**
 * PurchaseOrderServiceImpl
 * @author generator
 * @date 2020年04月05日
 */
@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
	
	@Autowired
	private PurchaseOrderMapper repo;
	/**
	 * 保存
	 * @param entity
	 */
	public void save(PurchaseOrder entity){
		this.checkEntity(entity);
		repo.insert(entity);
	}

	/**
	 * 修改
	 * @param entity
	 */
	public void update(PurchaseOrder entity){
		this.checkEntity(entity);
		repo.update(entity);
	}
	/**
	 * 较验实体
	 * @param entity
	 */
	public void checkEntity(PurchaseOrder entity){
	
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
	public PurchaseOrder findById(Integer pk){
		return repo.selectByPK(pk);
	}
	/**
	 * 通过非空属性查询
	 * @param PurchaseOrder
	 * @return
	 */
	public List<PurchaseOrder> findByNotNullProps(PurchaseOrder entity){
		
		SelectStatement<PurchaseOrder> st = StatementBuilder.buildSelectSelective(entity);
		return repo.selectByStatement(st);
	}
	/**
	 * 通过主键更新非空属性
	 * @param PurchaseOrder
	 * @return
	 */
	public void updateNotNullPropsById(PurchaseOrder entity){
		
		UpdateStatement<PurchaseOrder> st = StatementBuilder.buildUpdateSelective(entity);
		repo.updateByStatement(st);
	}
	
	/**
	 * 通过实体参数分页查询
	 * @param PurchaseOrder.QueryParam
	 * @return
	 */
	public List<PurchaseOrder> findByQueryParam(PurchaseOrder.QueryParam queryParam){
		return repo.findByQueryParam(queryParam);
	}
	/**
	 * 通过实体参数统计
	 * @param PurchaseOrder.QueryParam
	 * @return
	 */
	public long countByQueryParam(PurchaseOrder.QueryParam queryParam) {
		return repo.countByQueryParam(queryParam);
	}
	/**
	 * 通过ID集合查询
	 * @param List<Integer> pks
	 * @return
	 */
	public List<PurchaseOrder> findByIds(List<Integer> pks) {
		return repo.selectByPKS(pks);
	}
	/**
	 * 值填充
	 */
	public void fillValues(List<PurchaseOrder> items, PurchaseOrder.ValueField... field) {
		if (items == null || items.isEmpty() || field.length < 1) {
			return;
		}
	}
}
