package com.kunlong.dongxw.data.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kunlong.dongxw.data.domain.SelfMonthClose;
import com.kunlong.dongxw.data.dao.SelfMonthCloseMapper;
import com.kunlong.dongxw.data.service.SelfMonthCloseService;
import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.mybatis.hbatis.orm.criteria.statement.UpdateStatement;
import org.mybatis.hbatis.orm.criteria.support.StatementBuilder;
/**
 * SelfMonthCloseServiceImpl
 * @author generator
 * @date 2020年08月08日
 */
@Service
public class SelfMonthCloseServiceImpl implements SelfMonthCloseService {
	
	@Autowired
	private SelfMonthCloseMapper repo;
	/**
	 * 保存
	 * @param entity
	 */
	public void save(SelfMonthClose entity){
		this.checkEntity(entity);
		repo.insert(entity);
	}

	/**
	 * 修改
	 * @param entity
	 */
	public void update(SelfMonthClose entity){
		this.checkEntity(entity);
		repo.update(entity);
	}
	/**
	 * 较验实体
	 * @param entity
	 */
	public void checkEntity(SelfMonthClose entity){
	
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
	public SelfMonthClose findById(Integer pk){
		return repo.selectByPK(pk);
	}
	/**
	 * 通过非空属性查询
	 * @param SelfMonthClose
	 * @return
	 */
	public List<SelfMonthClose> findByNotNullProps(SelfMonthClose entity){
		
		SelectStatement<SelfMonthClose> st = StatementBuilder.buildSelectSelective(entity);
		return repo.selectByStatement(st);
	}
	/**
	 * 通过主键更新非空属性
	 * @param SelfMonthClose
	 * @return
	 */
	public void updateNotNullPropsById(SelfMonthClose entity){
		
		UpdateStatement<SelfMonthClose> st = StatementBuilder.buildUpdateSelective(entity);
		repo.updateByStatement(st);
	}
	
	/**
	 * 通过实体参数分页查询
	 * @param SelfMonthClose.QueryParam
	 * @return
	 */
	public List<SelfMonthClose> findByQueryParam(SelfMonthClose.QueryParam queryParam){
		return repo.findByQueryParam(queryParam);
	}
	/**
	 * 通过实体参数统计
	 * @param SelfMonthClose.QueryParam
	 * @return
	 */
	public long countByQueryParam(SelfMonthClose.QueryParam queryParam) {
		return repo.countByQueryParam(queryParam);
	}
	/**
	 * 通过ID集合查询
	 * @param List<Integer> pks
	 * @return
	 */
	public List<SelfMonthClose> findByIds(List<Integer> pks) {
		return repo.selectByPKS(pks);
	}
	/**
	 * 值填充
	 */
	public void fillValues(List<SelfMonthClose> items, SelfMonthClose.ValueField... field) {
		if (items == null || items.isEmpty() || field.length < 1) {
			return;
		}
	}
}
