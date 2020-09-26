package com.kunlong.dongxw.data.service;

import com.kunlong.dongxw.data.domain.MonthClose;
import java.util.List;
/**
 * MonthCloseService
 * @author generator
 * @date 2020年08月09日
 */
public interface MonthCloseService {
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(MonthClose entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(MonthClose entity);
	
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
	public MonthClose findById(Integer pk);
	/**
	 * 通过非空属性查询
	 * @param MonthClose
	 * @return
	 */
	public List<MonthClose> findByNotNullProps(MonthClose entity);
	/**
	 * 通过主键更新非空属性
	 * @param MonthClose
	 * @return
	 */
	public void updateNotNullPropsById(MonthClose entity);
	
	
	/**
	 * 通过实体参数分页查询
	 * @param MonthClose.QueryParam
	 * @return
	 */
	public List<MonthClose> findByQueryParam(MonthClose.QueryParam queryParam);
	/**
	 * 通过实体参数统计
	 * @param MonthClose.QueryParam
	 * @return
	 */
	public long countByQueryParam(MonthClose.QueryParam queryParam);
	/**
	 * 通过ID集合查询
	 * @param List<Integer> pks
	 * @return
	 */
	public List<MonthClose> findByIds(List<Integer> pks);
	/**
	 * 值填充
	 * @param items
	 * @param field
	 */
	public void fillValues(List<MonthClose> items,MonthClose.ValueField ...field);
}
