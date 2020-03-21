package com.kunlong.dongxw.data.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kunlong.dongxw.data.domain.VOrderPlan;
import com.kunlong.dongxw.data.dao.VOrderPlanMapper;
import com.kunlong.dongxw.data.service.VOrderPlanService;
import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.mybatis.hbatis.orm.criteria.statement.UpdateStatement;
import org.mybatis.hbatis.orm.criteria.support.StatementBuilder;
/**
 * VOrderPlanServiceImpl
 * @author generator
 * @date 2020年03月21日
 */
@Service
public class VOrderPlanServiceImpl implements VOrderPlanService {
	
	@Autowired
	private VOrderPlanMapper repo;
	/**
	 * 保存
	 * @param entity
	 */
	public void save(VOrderPlan entity){
		this.checkEntity(entity);
		repo.insert(entity);
	}

	/**
	 * 修改
	 * @param entity
	 */
	public void update(VOrderPlan entity){
		this.checkEntity(entity);
		repo.update(entity);
	}
	/**
	 * 较验实体
	 * @param entity
	 */
	public void checkEntity(VOrderPlan entity){
	
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
	public VOrderPlan findById(Integer pk){
		return repo.selectByPK(pk);
	}
	/**
	 * 通过非空属性查询
	 * @param VOrderPlan
	 * @return
	 */
	public List<VOrderPlan> findByNotNullProps(VOrderPlan entity){
		
		SelectStatement<VOrderPlan> st = StatementBuilder.buildSelectSelective(entity);
		return repo.selectByStatement(st);
	}
	/**
	 * 通过主键更新非空属性
	 * @param VOrderPlan
	 * @return
	 */
	public void updateNotNullPropsById(VOrderPlan entity){
		
		UpdateStatement<VOrderPlan> st = StatementBuilder.buildUpdateSelective(entity);
		repo.updateByStatement(st);
	}
	
	/**
	 * 通过实体参数分页查询
	 * @param VOrderPlan.QueryParam
	 * @return
	 */
	public List<VOrderPlan> findByQueryParam(VOrderPlan.QueryParam queryParam){
		return repo.findByQueryParam(queryParam);
	}
	/**
	 * 通过实体参数统计
	 * @param VOrderPlan.QueryParam
	 * @return
	 */
	public long countByQueryParam(VOrderPlan.QueryParam queryParam) {
		return repo.countByQueryParam(queryParam);
	}
	/**
	 * 通过ID集合查询
	 * @param List<Integer> pks
	 * @return
	 */
	public List<VOrderPlan> findByIds(List<Integer> pks) {
		return repo.selectByPKS(pks);
	}
	/**
	 * 值填充
	 */
	public void fillValues(List<VOrderPlan> items, VOrderPlan.ValueField... field) {
		if (items == null || items.isEmpty() || field.length < 1) {
			return;
		}
	}
}
