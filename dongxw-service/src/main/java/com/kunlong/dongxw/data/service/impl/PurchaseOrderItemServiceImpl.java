package com.kunlong.dongxw.data.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kunlong.dongxw.data.domain.PurchaseOrderItem;
import com.kunlong.dongxw.data.dao.PurchaseOrderItemMapper;
import com.kunlong.dongxw.data.service.PurchaseOrderItemService;
import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.mybatis.hbatis.orm.criteria.statement.UpdateStatement;
import org.mybatis.hbatis.orm.criteria.support.StatementBuilder;
/**
 * PurchaseOrderItemServiceImpl
 * @author generator
 * @date 2020年03月07日
 */
@Service
public class PurchaseOrderItemServiceImpl implements PurchaseOrderItemService {
	
	@Autowired
	private PurchaseOrderItemMapper repo;
	/**
	 * 保存
	 * @param entity
	 */
	public void save(PurchaseOrderItem entity){
		this.checkEntity(entity);
		repo.insert(entity);
	}

	/**
	 * 修改
	 * @param entity
	 */
	public void update(PurchaseOrderItem entity){
		this.checkEntity(entity);
		repo.update(entity);
	}
	/**
	 * 较验实体
	 * @param entity
	 */
	public void checkEntity(PurchaseOrderItem entity){
	
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
	public PurchaseOrderItem findById(Integer pk){
		return repo.selectByPK(pk);
	}
	/**
	 * 通过非空属性查询
	 * @param PurchaseOrderItem
	 * @return
	 */
	public List<PurchaseOrderItem> findByNotNullProps(PurchaseOrderItem entity){
		
		SelectStatement<PurchaseOrderItem> st = StatementBuilder.buildSelectSelective(entity);
		return repo.selectByStatement(st);
	}
	/**
	 * 通过主键更新非空属性
	 * @param PurchaseOrderItem
	 * @return
	 */
	public void updateNotNullPropsById(PurchaseOrderItem entity){
		
		UpdateStatement<PurchaseOrderItem> st = StatementBuilder.buildUpdateSelective(entity);
		repo.updateByStatement(st);
	}
	
	/**
	 * 通过实体参数分页查询
	 * @param PurchaseOrderItem.QueryParam
	 * @return
	 */
	public List<PurchaseOrderItem> findByQueryParam(PurchaseOrderItem.QueryParam queryParam){
		return repo.findByQueryParam(queryParam);
	}
	/**
	 * 通过实体参数统计
	 * @param PurchaseOrderItem.QueryParam
	 * @return
	 */
	public long countByQueryParam(PurchaseOrderItem.QueryParam queryParam) {
		return repo.countByQueryParam(queryParam);
	}
	/**
	 * 通过ID集合查询
	 * @param List<Integer> pks
	 * @return
	 */
	public List<PurchaseOrderItem> findByIds(List<Integer> pks) {
		return repo.selectByPKS(pks);
	}
	/**
	 * 值填充
	 */
	public void fillValues(List<PurchaseOrderItem> items, PurchaseOrderItem.ValueField... field) {
		if (items == null || items.isEmpty() || field.length < 1) {
			return;
		}
	}
}
