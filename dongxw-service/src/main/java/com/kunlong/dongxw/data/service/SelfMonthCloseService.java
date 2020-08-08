package com.kunlong.dongxw.data.service;

import com.kunlong.dongxw.data.domain.SelfMonthClose;
import java.util.List;
/**
 * SelfMonthCloseService
 * @author generator
 * @date 2020年08月08日
 */
public interface SelfMonthCloseService {
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(SelfMonthClose entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(SelfMonthClose entity);
	
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
	public SelfMonthClose findById(Integer pk);
	/**
	 * 通过非空属性查询
	 * @param SelfMonthClose
	 * @return
	 */
	public List<SelfMonthClose> findByNotNullProps(SelfMonthClose entity);
	/**
	 * 通过主键更新非空属性
	 * @param SelfMonthClose
	 * @return
	 */
	public void updateNotNullPropsById(SelfMonthClose entity);
	
	
	/**
	 * 通过实体参数分页查询
	 * @param SelfMonthClose.QueryParam
	 * @return
	 */
	public List<SelfMonthClose> findByQueryParam(SelfMonthClose.QueryParam queryParam);
	/**
	 * 通过实体参数统计
	 * @param SelfMonthClose.QueryParam
	 * @return
	 */
	public long countByQueryParam(SelfMonthClose.QueryParam queryParam);
	/**
	 * 通过ID集合查询
	 * @param List<Integer> pks
	 * @return
	 */
	public List<SelfMonthClose> findByIds(List<Integer> pks);
	/**
	 * 值填充
	 * @param items
	 * @param field
	 */
	public void fillValues(List<SelfMonthClose> items,SelfMonthClose.ValueField ...field);
}
