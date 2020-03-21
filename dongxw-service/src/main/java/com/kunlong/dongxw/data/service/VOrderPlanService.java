package com.kunlong.dongxw.data.service;

import com.kunlong.dongxw.data.domain.VOrderPlan;
import java.util.List;
/**
 * VOrderPlanService
 * @author generator
 * @date 2020年03月21日
 */
public interface VOrderPlanService {
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(VOrderPlan entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(VOrderPlan entity);
	
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
	public VOrderPlan findById(Integer pk);
	/**
	 * 通过非空属性查询
	 * @param VOrderPlan
	 * @return
	 */
	public List<VOrderPlan> findByNotNullProps(VOrderPlan entity);
	/**
	 * 通过主键更新非空属性
	 * @param VOrderPlan
	 * @return
	 */
	public void updateNotNullPropsById(VOrderPlan entity);
	
	
	/**
	 * 通过实体参数分页查询
	 * @param VOrderPlan.QueryParam
	 * @return
	 */
	public List<VOrderPlan> findByQueryParam(VOrderPlan.QueryParam queryParam);
	/**
	 * 通过实体参数统计
	 * @param VOrderPlan.QueryParam
	 * @return
	 */
	public long countByQueryParam(VOrderPlan.QueryParam queryParam);
	/**
	 * 通过ID集合查询
	 * @param List<Integer> pks
	 * @return
	 */
	public List<VOrderPlan> findByIds(List<Integer> pks);
	/**
	 * 值填充
	 * @param items
	 * @param field
	 */
	public void fillValues(List<VOrderPlan> items,VOrderPlan.ValueField ...field);
}
