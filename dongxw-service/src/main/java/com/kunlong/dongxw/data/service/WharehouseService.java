package com.kunlong.dongxw.data.service;

import com.kunlong.dongxw.data.domain.Wharehouse;
import java.util.List;
/**
 * WharehouseService
 * @author generator
 * @date 2020年09月22日
 */
public interface WharehouseService {
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(Wharehouse entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(Wharehouse entity);
	
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
	public Wharehouse findById(Integer pk);
	/**
	 * 通过非空属性查询
	 * @param Wharehouse
	 * @return
	 */
	public List<Wharehouse> findByNotNullProps(Wharehouse entity);
	/**
	 * 通过主键更新非空属性
	 * @param Wharehouse
	 * @return
	 */
	public void updateNotNullPropsById(Wharehouse entity);
	
	
	/**
	 * 通过实体参数分页查询
	 * @param Wharehouse.QueryParam
	 * @return
	 */
	public List<Wharehouse> findByQueryParam(Wharehouse.QueryParam queryParam);
	/**
	 * 通过实体参数统计
	 * @param Wharehouse.QueryParam
	 * @return
	 */
	public long countByQueryParam(Wharehouse.QueryParam queryParam);
	/**
	 * 通过ID集合查询
	 * @param List<Integer> pks
	 * @return
	 */
	public List<Wharehouse> findByIds(List<Integer> pks);
	/**
	 * 值填充
	 * @param items
	 * @param field
	 */
	public void fillValues(List<Wharehouse> items,Wharehouse.ValueField ...field);
}
