package com.kunlong.dongxw.data.service;

import com.kunlong.dongxw.data.domain.Document;
import java.util.List;
/**
 * DocumentService
 * @author generator
 * @date 2020年01月03日
 */
public interface DocumentService {
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(Document entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(Document entity);
	
	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(Long pk);
	
	/**
	 * 通过id获取
	 * @param id
	 * @return
	 */
	public Document findById(Long pk);
	/**
	 * 通过非空属性查询
	 * @param Document
	 * @return
	 */
	public List<Document> findByNotNullProps(Document entity);
	/**
	 * 通过主键更新非空属性
	 * @param Document
	 * @return
	 */
	public void updateNotNullPropsById(Document entity);
	
	
	/**
	 * 通过实体参数分页查询
	 * @param Document.QueryParam
	 * @return
	 */
	public List<Document> findByQueryParam(Document.QueryParam queryParam);
	/**
	 * 通过实体参数统计
	 * @param Document.QueryParam
	 * @return
	 */
	public long countByQueryParam(Document.QueryParam queryParam);
	/**
	 * 通过ID集合查询
	 * @param List<Long> pks
	 * @return
	 */
	public List<Document> findByIds(List<Long> pks);
	/**
	 * 值填充
	 * @param items
	 * @param field
	 */
	public void fillValues(List<Document> items,Document.ValueField ...field);
}
