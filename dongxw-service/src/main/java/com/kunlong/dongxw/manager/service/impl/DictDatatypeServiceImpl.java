package com.kunlong.dongxw.manager.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kunlong.dongxw.manager.domain.DictDatatype;
import com.kunlong.dongxw.manager.dao.DictDatatypeMapper;
import com.kunlong.dongxw.manager.service.DictDatatypeService;
import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.mybatis.hbatis.orm.criteria.statement.UpdateStatement;
import org.mybatis.hbatis.orm.criteria.support.StatementBuilder;
/**
 * DictDatatypeServiceImpl
 * @author generator
 * @date 2019年12月19日
 */
@Service
public class DictDatatypeServiceImpl implements DictDatatypeService {
	
	@Autowired
	private DictDatatypeMapper repo;
	/**
	 * 保存
	 * @param entity
	 */
	public void save(DictDatatype entity){
		this.checkEntity(entity);
		repo.insert(entity);
	}

	/**
	 * 修改
	 * @param entity
	 */
	public void update(DictDatatype entity){
		this.checkEntity(entity);
		repo.update(entity);
	}
	/**
	 * 较验实体
	 * @param entity
	 */
	public void checkEntity(DictDatatype entity){
	
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
	public DictDatatype findById(Integer pk){
		return repo.selectByPK(pk);
	}
	/**
	 * 通过非空属性查询
	 * @param DictDatatype
	 * @return
	 */
	public List<DictDatatype> findByNotNullProps(DictDatatype entity){
		
		SelectStatement<DictDatatype> st = StatementBuilder.buildSelectSelective(entity);
		return repo.selectByStatement(st);
	}
	/**
	 * 通过主键更新非空属性
	 * @param DictDatatype
	 * @return
	 */
	public void updateNotNullPropsById(DictDatatype entity){
		
		UpdateStatement<DictDatatype> st = StatementBuilder.buildUpdateSelective(entity);
		repo.updateByStatement(st);
	}
	
	/**
	 * 通过实体参数分页查询
	 * @param DictDatatype.QueryParam
	 * @return
	 */
	public List<DictDatatype> findByQueryParam(DictDatatype.QueryParam queryParam){
		return repo.findByQueryParam(queryParam);
	}
	/**
	 * 通过实体参数统计
	 * @param DictDatatype.QueryParam
	 * @return
	 */
	public long countByQueryParam(DictDatatype.QueryParam queryParam) {
		return repo.countByQueryParam(queryParam);
	}
	/**
	 * 通过ID集合查询
	 * @param List<Integer> pks
	 * @return
	 */
	public List<DictDatatype> findByIds(List<Integer> pks) {
		return repo.selectByPKS(pks);
	}
	/**
	 * 值填充
	 */
	public void fillValues(List<DictDatatype> items, DictDatatype.ValueField... field) {
		if (items == null || items.isEmpty() || field.length < 1) {
			return;
		}
	}
}
