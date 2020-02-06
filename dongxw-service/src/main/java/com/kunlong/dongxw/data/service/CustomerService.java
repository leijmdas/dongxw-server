package com.kunlong.dongxw.data.service;

import com.kunlong.dongxw.data.domain.Customer;
import java.util.List;
/**
 * CustomerService
 * @author generator
 * @date 2020年01月18日
 */
public interface CustomerService {
	/**
	 * 保存
	 * @param entity
	 */
	public void save(Customer entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(Customer entity);
	
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
	public Customer findById(Integer pk);
	/**
	 * 通过非空属性查询
	 * @param Customer
	 * @return
	 */
	public List<Customer> findByNotNullProps(Customer entity);
	/**
	 * 通过主键更新非空属性
	 * @param Customer
	 * @return
	 */
	public void updateNotNullPropsById(Customer entity);
	
	
	/**
	 * 通过实体参数分页查询
	 * @param Customer.QueryParam
	 * @return
	 */
	public List<Customer> findByQueryParam(Customer.QueryParam queryParam);
	/**
	 * 通过实体参数统计
	 * @param Customer.QueryParam
	 * @return
	 */
	public long countByQueryParam(Customer.QueryParam queryParam);
	/**
	 * 通过ID集合查询
	 * @param List<Integer> pks
	 * @return
	 */
	public List<Customer> findByIds(List<Integer> pks);
	/**
	 * 值填充
	 * @param items
	 * @param field
	 */
	public void fillValues(List<Customer> items,Customer.ValueField ...field);
}
