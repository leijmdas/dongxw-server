package com.kunlong.dongxw.dongxw.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kunlong.dongxw.dongxw.domain.MakePlan;
import com.kunlong.dongxw.dongxw.dao.MakePlanMapper;
import com.kunlong.dongxw.dongxw.service.MakePlanService;
import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.mybatis.hbatis.orm.criteria.statement.UpdateStatement;
import org.mybatis.hbatis.orm.criteria.support.StatementBuilder;
/**
 * MakePlanServiceImpl
 * @author generator
 * @date 2020年02月05日
 */
@Service
public class MakePlanServiceImpl implements MakePlanService {
	
	@Autowired
	private MakePlanMapper repo;
	/**
	 * 保存
	 * @param entity
	 */
	public void save(MakePlan entity){
		this.checkEntity(entity);
		repo.insert(entity);
	}

	/**
	 * 修改
	 * @param entity
	 */
	public void update(MakePlan entity){
		this.checkEntity(entity);
		repo.update(entity);
	}
	/**
	 * 较验实体
	 * @param entity
	 */
	public void checkEntity(MakePlan entity){
	
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
	public MakePlan findById(Integer pk){
		return repo.selectByPK(pk);
	}
	/**
	 * 通过非空属性查询
	 * @param MakePlan
	 * @return
	 */
	public List<MakePlan> findByNotNullProps(MakePlan entity){
		
		SelectStatement<MakePlan> st = StatementBuilder.buildSelectSelective(entity);
		return repo.selectByStatement(st);
	}
	/**
	 * 通过主键更新非空属性
	 * @param MakePlan
	 * @return
	 */
	public void updateNotNullPropsById(MakePlan entity){
		
		UpdateStatement<MakePlan> st = StatementBuilder.buildUpdateSelective(entity);
		repo.updateByStatement(st);
	}
	
	/**
	 * 通过实体参数分页查询
	 * @param MakePlan.QueryParam
	 * @return
	 */
	public List<MakePlan> findByQueryParam(MakePlan.QueryParam queryParam){
		return repo.findByQueryParam(queryParam);
	}
	/**
	 * 通过实体参数统计
	 * @param MakePlan.QueryParam
	 * @return
	 */
	public long countByQueryParam(MakePlan.QueryParam queryParam) {
		return repo.countByQueryParam(queryParam);
	}
	/**
	 * 通过ID集合查询
	 * @param List<Integer> pks
	 * @return
	 */
	public List<MakePlan> findByIds(List<Integer> pks) {
		return repo.selectByPKS(pks);
	}
	/**
	 * 值填充
	 */
	public void fillValues(List<MakePlan> items, MakePlan.ValueField... field) {
		if (items == null || items.isEmpty() || field.length < 1) {
			return;
		}
	}
}
