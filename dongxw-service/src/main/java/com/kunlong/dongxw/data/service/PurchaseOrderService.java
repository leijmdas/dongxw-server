package com.kunlong.dongxw.data.service;

import com.kunlong.dongxw.data.domain.PurchaseOrder;
import java.util.List;
/**
 * PurchaseOrderService
 * @author generator
 * @date 2020年04月05日
 */
public interface PurchaseOrderService {
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(PurchaseOrder entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(PurchaseOrder entity);
	
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
	public PurchaseOrder findById(Integer pk);
	/**
	 * 通过非空属性查询
	 * @param PurchaseOrder
	 * @return
	 */
	public List<PurchaseOrder> findByNotNullProps(PurchaseOrder entity);
	/**
	 * 通过主键更新非空属性
	 * @param PurchaseOrder
	 * @return
	 */
	public void updateNotNullPropsById(PurchaseOrder entity);
	
	
	/**
	 * 通过实体参数分页查询
	 * @param PurchaseOrder.QueryParam
	 * @return
	 */
	public List<PurchaseOrder> findByQueryParam(PurchaseOrder.QueryParam queryParam);
	/**
	 * 通过实体参数统计
	 * @param PurchaseOrder.QueryParam
	 * @return
	 */
	public long countByQueryParam(PurchaseOrder.QueryParam queryParam);
	/**
	 * 通过ID集合查询
	 * @param List<Integer> pks
	 * @return
	 */
	public List<PurchaseOrder> findByIds(List<Integer> pks);
	/**
	 * 值填充
	 * @param items
	 * @param field
	 */
	public void fillValues(List<PurchaseOrder> items,PurchaseOrder.ValueField ...field);
}
