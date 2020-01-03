package com.kunlong.dongxw.dongxw.service;

import com.kunlong.dongxw.dongxw.domain.Supplier;
import java.util.List;
/**
 * SupplierService
 * @author generator
 * @date 2020年01月03日
 */
public interface SupplierService {
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(Supplier entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(Supplier entity);
	
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
	public Supplier findById(Integer pk);
	/**
	 * 通过非空属性查询
	 * @param Supplier
	 * @return
	 */
	public List<Supplier> findByNotNullProps(Supplier entity);
	/**
	 * 通过主键更新非空属性
	 * @param Supplier
	 * @return
	 */
	public void updateNotNullPropsById(Supplier entity);
	
	
	/**
	 * 通过实体参数分页查询
	 * @param Supplier.QueryParam
	 * @return
	 */
	public List<Supplier> findByQueryParam(Supplier.QueryParam queryParam);
	/**
	 * 通过实体参数统计
	 * @param Supplier.QueryParam
	 * @return
	 */
	public long countByQueryParam(Supplier.QueryParam queryParam);
	/**
	 * 通过ID集合查询
	 * @param List<Integer> pks
	 * @return
	 */
	public List<Supplier> findByIds(List<Integer> pks);
	/**
	 * 值填充
	 * @param items
	 * @param field
	 */
	public void fillValues(List<Supplier> items,Supplier.ValueField ...field);
}
