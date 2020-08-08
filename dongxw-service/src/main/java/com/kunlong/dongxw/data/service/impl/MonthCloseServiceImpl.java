package com.kunlong.dongxw.data.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kunlong.dongxw.data.domain.MonthClose;
import com.kunlong.dongxw.data.dao.MonthCloseMapper;
import com.kunlong.dongxw.data.service.MonthCloseService;
import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.mybatis.hbatis.orm.criteria.statement.UpdateStatement;
import org.mybatis.hbatis.orm.criteria.support.StatementBuilder;
/**
 * MonthCloseServiceImpl
 * @author generator
 * @date 2020年08月08日
 */
@Service
public class MonthCloseServiceImpl implements MonthCloseService {
	
	@Autowired
	private MonthCloseMapper repo;
	/**
	 * 保存
	 * @param entity
	 */
	public void save(MonthClose entity){
		this.checkEntity(entity);
		repo.insert(entity);
	}

	/**
	 * 修改
	 * @param entity
	 */
	public void update(MonthClose entity){
		this.checkEntity(entity);
		repo.update(entity);
	}
	/**
	 * 较验实体
	 * @param entity
	 */
	public void checkEntity(MonthClose entity){
	
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
	public MonthClose findById(Integer pk){
		return repo.selectByPK(pk);
	}
	/**
	 * 通过非空属性查询
	 * @param MonthClose
	 * @return
	 */
	public List<MonthClose> findByNotNullProps(MonthClose entity){
		
		SelectStatement<MonthClose> st = StatementBuilder.buildSelectSelective(entity);
		return repo.selectByStatement(st);
	}
	/**
	 * 通过主键更新非空属性
	 * @param MonthClose
	 * @return
	 */
	public void updateNotNullPropsById(MonthClose entity){
		
		UpdateStatement<MonthClose> st = StatementBuilder.buildUpdateSelective(entity);
		repo.updateByStatement(st);
	}
	
	/**
	 * 通过实体参数分页查询
	 * @param MonthClose.QueryParam
	 * @return
	 */
	public List<MonthClose> findByQueryParam(MonthClose.QueryParam queryParam){
		return repo.findByQueryParam(queryParam);
	}
	/**
	 * 通过实体参数统计
	 * @param MonthClose.QueryParam
	 * @return
	 */
	public long countByQueryParam(MonthClose.QueryParam queryParam) {
		return repo.countByQueryParam(queryParam);
	}
	/**
	 * 通过ID集合查询
	 * @param List<Integer> pks
	 * @return
	 */
	public List<MonthClose> findByIds(List<Integer> pks) {
		return repo.selectByPKS(pks);
	}
	/**
	 * 值填充
	 */
	public void fillValues(List<MonthClose> items, MonthClose.ValueField... field) {
		if (items == null || items.isEmpty() || field.length < 1) {
			return;
		}
	}
}
