package com.kunlong.dongxw.dongxw.service;

import com.kunlong.dongxw.dongxw.domain.Product;
import java.util.List;
/**
 * ProductService
 * @author generator
 * @date 2020年01月07日
 */
public interface ProductService {
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(Product entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(Product entity);
	
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
	public Product findById(Integer pk);
	/**
	 * 通过非空属性查询
	 * @param Product
	 * @return
	 */
	public List<Product> findByNotNullProps(Product entity);
	/**
	 * 通过主键更新非空属性
	 * @param Product
	 * @return
	 */
	public void updateNotNullPropsById(Product entity);
	
	
	/**
	 * 通过实体参数分页查询
	 * @param Product.QueryParam
	 * @return
	 */
	public List<Product> findByQueryParam(Product.QueryParam queryParam);
	/**
	 * 通过实体参数统计
	 * @param Product.QueryParam
	 * @return
	 */
	public long countByQueryParam(Product.QueryParam queryParam);
	/**
	 * 通过ID集合查询
	 * @param List<Integer> pks
	 * @return
	 */
	public List<Product> findByIds(List<Integer> pks);
	/**
	 * 值填充
	 * @param items
	 * @param field
	 */
	public void fillValues(List<Product> items,Product.ValueField ...field);
}
