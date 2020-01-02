package com.kunlong.dongxw.dongxw.service;

import com.kunlong.dongxw.dongxw.domain.ProductType;
import java.util.List;
/**
 * ProductTypeService
 * @author generator
 * @date 2020年01月02日
 */
public interface ProductTypeService {
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(ProductType entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(ProductType entity);
	
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
	public ProductType findById(Integer pk);
	/**
	 * 通过非空属性查询
	 * @param ProductType
	 * @return
	 */
	public List<ProductType> findByNotNullProps(ProductType entity);
	/**
	 * 通过主键更新非空属性
	 * @param ProductType
	 * @return
	 */
	public void updateNotNullPropsById(ProductType entity);
	
	
	/**
	 * 通过实体参数分页查询
	 * @param ProductType.QueryParam
	 * @return
	 */
	public List<ProductType> findByQueryParam(ProductType.QueryParam queryParam);
	/**
	 * 通过实体参数统计
	 * @param ProductType.QueryParam
	 * @return
	 */
	public long countByQueryParam(ProductType.QueryParam queryParam);
	/**
	 * 通过ID集合查询
	 * @param List<Integer> pks
	 * @return
	 */
	public List<ProductType> findByIds(List<Integer> pks);
	/**
	 * 值填充
	 * @param items
	 * @param field
	 */
	public void fillValues(List<ProductType> items,ProductType.ValueField ...field);
}
