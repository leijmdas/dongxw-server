package com.kunlong.dongxw.dongxw.service;

import com.kunlong.dongxw.dongxw.domain.OrderMaster;
import java.util.List;
/**
 * OrderMasterService
 * @author generator
 * @date 2020年01月06日
 */
public interface OrderMasterService {
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(OrderMaster entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(OrderMaster entity);
	
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
	public OrderMaster findById(Integer pk);
	/**
	 * 通过非空属性查询
	 * @param entity
	 * @return
	 */
	public List<OrderMaster> findByNotNullProps(OrderMaster entity);
	/**
	 * 通过主键更新非空属性
	 * @param entity
	 * @return
	 */
	public void updateNotNullPropsById(OrderMaster entity);
	
	
	/**
	 * 通过实体参数分页查询
	 * @param queryParam
	 * @return
	 */
	public List<OrderMaster> findByQueryParam(OrderMaster.QueryParam queryParam);
	/**
	 * 通过实体参数统计
	 * @param  queryParam
	 * @return
	 */
	public long countByQueryParam(OrderMaster.QueryParam queryParam);
	/**
	 * 通过ID集合查询
	 * @param List<Integer> pks
	 * @return
	 */
	public List<OrderMaster> findByIds(List<Integer> pks);
	/**
	 * 值填充
	 * @param items
	 * @param field
	 */
	public void fillValues(List<OrderMaster> items,OrderMaster.ValueField ...field);
}
