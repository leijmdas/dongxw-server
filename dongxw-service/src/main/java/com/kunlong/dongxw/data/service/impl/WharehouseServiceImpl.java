package com.kunlong.dongxw.data.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kunlong.dongxw.data.domain.Wharehouse;
import com.kunlong.dongxw.data.dao.WharehouseMapper;
import com.kunlong.dongxw.data.service.WharehouseService;
import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.mybatis.hbatis.orm.criteria.statement.UpdateStatement;
import org.mybatis.hbatis.orm.criteria.support.StatementBuilder;
/**
 * WharehouseServiceImpl
 * @author generator
 * @date 2020年09月22日
 */
@Service
public class WharehouseServiceImpl implements WharehouseService {
	
	@Autowired
	private WharehouseMapper repo;
	/**
	 * 保存
	 * @param entity
	 */
	public void save(Wharehouse entity){
		this.checkEntity(entity);
		repo.insert(entity);
	}

	/**
	 * 修改
	 * @param entity
	 */
	public void update(Wharehouse entity){
		this.checkEntity(entity);
		repo.update(entity);
	}
	/**
	 * 较验实体
	 * @param entity
	 */
	public void checkEntity(Wharehouse entity){
	
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
	public Wharehouse findById(Integer pk){
		return repo.selectByPK(pk);
	}
	/**
	 * 通过非空属性查询
	 * @param Wharehouse
	 * @return
	 */
	public List<Wharehouse> findByNotNullProps(Wharehouse entity){
		
		SelectStatement<Wharehouse> st = StatementBuilder.buildSelectSelective(entity);
		return repo.selectByStatement(st);
	}
	/**
	 * 通过主键更新非空属性
	 * @param Wharehouse
	 * @return
	 */
	public void updateNotNullPropsById(Wharehouse entity){
		
		UpdateStatement<Wharehouse> st = StatementBuilder.buildUpdateSelective(entity);
		repo.updateByStatement(st);
	}
	
	/**
	 * 通过实体参数分页查询
	 * @param Wharehouse.QueryParam
	 * @return
	 */
	public List<Wharehouse> findByQueryParam(Wharehouse.QueryParam queryParam){
		return repo.findByQueryParam(queryParam);
	}
	/**
	 * 通过实体参数统计
	 * @param Wharehouse.QueryParam
	 * @return
	 */
	public long countByQueryParam(Wharehouse.QueryParam queryParam) {
		return repo.countByQueryParam(queryParam);
	}
	/**
	 * 通过ID集合查询
	 * @param List<Integer> pks
	 * @return
	 */
	public List<Wharehouse> findByIds(List<Integer> pks) {
		return repo.selectByPKS(pks);
	}
	/**
	 * 值填充
	 */
	public void fillValues(List<Wharehouse> items, Wharehouse.ValueField... field) {
		if (items == null || items.isEmpty() || field.length < 1) {
			return;
		}
	}
}
