package com.kunlong.dongxw.data.service;

import com.kunlong.dongxw.data.domain.BomCost;
import java.util.List;
/**
 * BomCostService
 * @author generator
 * @date 2020年02月02日
 */
public interface BomCostService {
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(BomCost entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(BomCost entity);
	
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
	public BomCost findById(Integer pk);
	/**
	 * 通过非空属性查询
	 * @param BomCost
	 * @return
	 */
	public List<BomCost> findByNotNullProps(BomCost entity);
	/**
	 * 通过主键更新非空属性
	 * @param BomCost
	 * @return
	 */
	public void updateNotNullPropsById(BomCost entity);
	
	
	/**
	 * 通过实体参数分页查询
	 * @param BomCost.QueryParam
	 * @return
	 */
	public List<BomCost> findByQueryParam(BomCost.QueryParam queryParam);
	/**
	 * 通过实体参数统计
	 * @param BomCost.QueryParam
	 * @return
	 */
	public long countByQueryParam(BomCost.QueryParam queryParam);
	/**
	 * 通过ID集合查询
	 * @param List<Integer> pks
	 * @return
	 */
	public List<BomCost> findByIds(List<Integer> pks);
	/**
	 * 值填充
	 * @param items
	 * @param field
	 */
	public void fillValues(List<BomCost> items,BomCost.ValueField ...field);
}
