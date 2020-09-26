package com.kunlong.dongxw.data.service;

import com.kunlong.dongxw.data.domain.WhStock;
import java.util.List;
/**
 * WhStockService
 * @author generator
 * @date 2020年09月22日
 */
public interface WhStockService {
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(WhStock entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(WhStock entity);
	
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
	public WhStock findById(Integer pk);
	/**
	 * 通过非空属性查询
	 * @param WhStock
	 * @return
	 */
	public List<WhStock> findByNotNullProps(WhStock entity);
	/**
	 * 通过主键更新非空属性
	 * @param WhStock
	 * @return
	 */
	public void updateNotNullPropsById(WhStock entity);
	
	
	/**
	 * 通过实体参数分页查询
	 * @param WhStock.QueryParam
	 * @return
	 */
	public List<WhStock> findByQueryParam(WhStock.QueryParam queryParam);
	/**
	 * 通过实体参数统计
	 * @param WhStock.QueryParam
	 * @return
	 */
	public long countByQueryParam(WhStock.QueryParam queryParam);
	/**
	 * 通过ID集合查询
	 * @param List<Integer> pks
	 * @return
	 */
	public List<WhStock> findByIds(List<Integer> pks);
	/**
	 * 值填充
	 * @param items
	 * @param field
	 */
	public void fillValues(List<WhStock> items,WhStock.ValueField ...field);
}
