package com.kunlong.dongxw.dongxw.service;

import com.kunlong.dongxw.dongxw.domain.MakePlan;
import java.util.List;
/**
 * MakePlanService
 * @author generator
 * @date 2020年01月23日
 */
public interface MakePlanService {
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(MakePlan entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(MakePlan entity);
	
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
	public MakePlan findById(Integer pk);
	/**
	 * 通过非空属性查询
	 * @param MakePlan
	 * @return
	 */
	public List<MakePlan> findByNotNullProps(MakePlan entity);
	/**
	 * 通过主键更新非空属性
	 * @param MakePlan
	 * @return
	 */
	public void updateNotNullPropsById(MakePlan entity);
	
	
	/**
	 * 通过实体参数分页查询
	 * @param MakePlan.QueryParam
	 * @return
	 */
	public List<MakePlan> findByQueryParam(MakePlan.QueryParam queryParam);
	/**
	 * 通过实体参数统计
	 * @param MakePlan.QueryParam
	 * @return
	 */
	public long countByQueryParam(MakePlan.QueryParam queryParam);
	/**
	 * 通过ID集合查询
	 * @param List<Integer> pks
	 * @return
	 */
	public List<MakePlan> findByIds(List<Integer> pks);
	/**
	 * 值填充
	 * @param items
	 * @param field
	 */
	public void fillValues(List<MakePlan> items,MakePlan.ValueField ...field);
}
