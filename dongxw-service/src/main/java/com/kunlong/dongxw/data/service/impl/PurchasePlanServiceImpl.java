package com.kunlong.dongxw.data.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kunlong.dongxw.data.domain.PurchasePlan;
import com.kunlong.dongxw.data.dao.PurchasePlanMapper;
import com.kunlong.dongxw.data.service.PurchasePlanService;
import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.mybatis.hbatis.orm.criteria.statement.UpdateStatement;
import org.mybatis.hbatis.orm.criteria.support.StatementBuilder;
/**
 * PurchasePlanServiceImpl
 * @author generator
 * @date 2020年02月05日
 */
@Service
public class PurchasePlanServiceImpl implements PurchasePlanService {
	
	@Autowired
	private PurchasePlanMapper repo;
	/**
	 * 保存
	 * @param entity
	 */
	public void save(PurchasePlan entity){
		this.checkEntity(entity);
		repo.insert(entity);
	}

	/**
	 * 修改
	 * @param entity
	 */
	public void update(PurchasePlan entity){
		this.checkEntity(entity);
		repo.update(entity);
	}
	/**
	 * 较验实体
	 * @param entity
	 */
	public void checkEntity(PurchasePlan entity){
	
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
	public PurchasePlan findById(Integer pk){
		return repo.selectByPK(pk);
	}
	/**
	 * 通过非空属性查询
	 * @param PurchasePlan
	 * @return
	 */
	public List<PurchasePlan> findByNotNullProps(PurchasePlan entity){
		
		SelectStatement<PurchasePlan> st = StatementBuilder.buildSelectSelective(entity);
		return repo.selectByStatement(st);
	}
	/**
	 * 通过主键更新非空属性
	 * @param PurchasePlan
	 * @return
	 */
	public void updateNotNullPropsById(PurchasePlan entity){
		
		UpdateStatement<PurchasePlan> st = StatementBuilder.buildUpdateSelective(entity);
		repo.updateByStatement(st);
	}
	
	/**
	 * 通过实体参数分页查询
	 * @param PurchasePlan.QueryParam
	 * @return
	 */
	public List<PurchasePlan> findByQueryParam(PurchasePlan.QueryParam queryParam){
		return repo.findByQueryParam(queryParam);
	}
	/**
	 * 通过实体参数统计
	 * @param PurchasePlan.QueryParam
	 * @return
	 */
	public long countByQueryParam(PurchasePlan.QueryParam queryParam) {
		return repo.countByQueryParam(queryParam);
	}
	/**
	 * 通过ID集合查询
	 * @param List<Integer> pks
	 * @return
	 */
	public List<PurchasePlan> findByIds(List<Integer> pks) {
		return repo.selectByPKS(pks);
	}
	/**
	 * 值填充
	 */
	public void fillValues(List<PurchasePlan> items, PurchasePlan.ValueField... field) {
		if (items == null || items.isEmpty() || field.length < 1) {
			return;
		}
	}
}
