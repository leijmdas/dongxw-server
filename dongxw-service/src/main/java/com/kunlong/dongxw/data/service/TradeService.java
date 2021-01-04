package com.kunlong.dongxw.data.service;

import com.kunlong.dongxw.data.domain.Trade;
import java.util.List;
/**
 * TradeService
 * @author generator
 * @date 2020年11月28日
 */
public interface TradeService {
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(Trade entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(Trade entity);
	
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
	public Trade findById(Integer pk);
	/**
	 * 通过非空属性查询
	 * @param Trade
	 * @return
	 */
	public List<Trade> findByNotNullProps(Trade entity);
	/**
	 * 通过主键更新非空属性
	 * @param Trade
	 * @return
	 */
	public void updateNotNullPropsById(Trade entity);
	
	
	/**
	 * 通过实体参数分页查询
	 * @param Trade.QueryParam
	 * @return
	 */
	public List<Trade> findByQueryParam(Trade.QueryParam queryParam);
	/**
	 * 通过实体参数统计
	 * @param Trade.QueryParam
	 * @return
	 */
	public long countByQueryParam(Trade.QueryParam queryParam);
	/**
	 * 通过ID集合查询
	 * @param List<Integer> pks
	 * @return
	 */
	public List<Trade> findByIds(List<Integer> pks);
	/**
	 * 值填充
	 * @param items
	 * @param field
	 */
	public void fillValues(List<Trade> items,Trade.ValueField ...field);
}
