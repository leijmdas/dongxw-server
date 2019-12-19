package com.kunlong.dongxw.manager.service;

import com.kunlong.dongxw.manager.domain.DictDatatype;
import java.util.List;
/**
 * DictDatatypeService
 * @author generator
 * @date 2019年12月19日
 */
public interface DictDatatypeService {
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(DictDatatype entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(DictDatatype entity);
	
	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(Integer pk);
	
	/**
	 * 通过id获取
	 * @param id
	 * @return
	 */
	public DictDatatype findById(Integer pk);
	/**
	 * 通过非空属性查询
	 * @param DictDatatype
	 * @return
	 */
	public List<DictDatatype> findByNotNullProps(DictDatatype entity);
	/**
	 * 通过主键更新非空属性
	 * @param DictDatatype
	 * @return
	 */
	public void updateNotNullPropsById(DictDatatype entity);
	
	
	/**
	 * 通过实体参数分页查询
	 * @param DictDatatype.QueryParam
	 * @return
	 */
	public List<DictDatatype> findByQueryParam(DictDatatype.QueryParam queryParam);
	/**
	 * 通过实体参数统计
	 * @param DictDatatype.QueryParam
	 * @return
	 */
	public long countByQueryParam(DictDatatype.QueryParam queryParam);
	/**
	 * 通过ID集合查询
	 * @param List<Integer> pks
	 * @return
	 */
	public List<DictDatatype> findByIds(List<Integer> pks);
	/**
	 * 值填充
	 * @param items
	 * @param field
	 */
	public void fillValues(List<DictDatatype> items, DictDatatype.ValueField... field);
}
