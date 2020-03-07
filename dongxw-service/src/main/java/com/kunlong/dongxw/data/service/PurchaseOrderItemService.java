package com.kunlong.dongxw.data.service;

import com.kunlong.dongxw.data.domain.PurchaseOrderItem;
import java.util.List;
/**
 * PurchaseOrderItemService
 * @author generator
 * @date 2020年03月07日
 */
public interface PurchaseOrderItemService {
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(PurchaseOrderItem entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(PurchaseOrderItem entity);
	
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
	public PurchaseOrderItem findById(Integer pk);
	/**
	 * 通过非空属性查询
	 * @param PurchaseOrderItem
	 * @return
	 */
	public List<PurchaseOrderItem> findByNotNullProps(PurchaseOrderItem entity);
	/**
	 * 通过主键更新非空属性
	 * @param PurchaseOrderItem
	 * @return
	 */
	public void updateNotNullPropsById(PurchaseOrderItem entity);
	
	
	/**
	 * 通过实体参数分页查询
	 * @param PurchaseOrderItem.QueryParam
	 * @return
	 */
	public List<PurchaseOrderItem> findByQueryParam(PurchaseOrderItem.QueryParam queryParam);
	/**
	 * 通过实体参数统计
	 * @param PurchaseOrderItem.QueryParam
	 * @return
	 */
	public long countByQueryParam(PurchaseOrderItem.QueryParam queryParam);
	/**
	 * 通过ID集合查询
	 * @param List<Integer> pks
	 * @return
	 */
	public List<PurchaseOrderItem> findByIds(List<Integer> pks);
	/**
	 * 值填充
	 * @param items
	 * @param field
	 */
	public void fillValues(List<PurchaseOrderItem> items,PurchaseOrderItem.ValueField ...field);
}
