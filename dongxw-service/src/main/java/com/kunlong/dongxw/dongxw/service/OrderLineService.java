package com.kunlong.dongxw.dongxw.service;

import com.kunlong.dongxw.dongxw.domain.OrderLine;
import java.util.List;
/**
 * OrderLineService
 * @author generator
 * @date 2019年12月29日
 */
public interface OrderLineService {
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(OrderLine entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(OrderLine entity);
	
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
	public OrderLine findById(Integer pk);
	/**
	 * 通过非空属性查询
	 * @param OrderLine
	 * @return
	 */
	public List<OrderLine> findByNotNullProps(OrderLine entity);
	/**
	 * 通过主键更新非空属性
	 * @param OrderLine
	 * @return
	 */
	public void updateNotNullPropsById(OrderLine entity);
	
	
	/**
	 * 通过实体参数分页查询
	 * @param OrderLine.QueryParam
	 * @return
	 */
	public List<OrderLine> findByQueryParam(OrderLine.QueryParam queryParam);
	/**
	 * 通过实体参数统计
	 * @param OrderLine.QueryParam
	 * @return
	 */
	public long countByQueryParam(OrderLine.QueryParam queryParam);
	/**
	 * 通过ID集合查询
	 * @param List<Integer> pks
	 * @return
	 */
	public List<OrderLine> findByIds(List<Integer> pks);
	/**
	 * 值填充
	 * @param items
	 * @param field
	 */
	public void fillValues(List<OrderLine> items,OrderLine.ValueField ...field);
}
