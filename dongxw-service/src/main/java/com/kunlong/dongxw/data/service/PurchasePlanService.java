package com.kunlong.dongxw.data.service;

import com.kunlong.dongxw.data.domain.PurchasePlan;
import java.util.List;
/**
 * PurchasePlanService
 * @author generator
 * @date 2020年04月05日
 */
public interface PurchasePlanService {
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(PurchasePlan entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(PurchasePlan entity);
	
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
	public PurchasePlan findById(Integer pk);
	/**
	 * 通过非空属性查询
	 * @param PurchasePlan
	 * @return
	 */
	public List<PurchasePlan> findByNotNullProps(PurchasePlan entity);
	/**
	 * 通过主键更新非空属性
	 * @param PurchasePlan
	 * @return
	 */
	public void updateNotNullPropsById(PurchasePlan entity);
	
	
	/**
	 * 通过实体参数分页查询
	 * @param PurchasePlan.QueryParam
	 * @return
	 */
	public List<PurchasePlan> findByQueryParam(PurchasePlan.QueryParam queryParam);
	/**
	 * 通过实体参数统计
	 * @param PurchasePlan.QueryParam
	 * @return
	 */
	public long countByQueryParam(PurchasePlan.QueryParam queryParam);
	/**
	 * 通过ID集合查询
	 * @param List<Integer> pks
	 * @return
	 */
	public List<PurchasePlan> findByIds(List<Integer> pks);
	/**
	 * 值填充
	 * @param items
	 * @param field
	 */
	public void fillValues(List<PurchasePlan> items,PurchasePlan.ValueField ...field);
}
