package com.kunlong.dongxw.data.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kunlong.dongxw.data.domain.Document;
import com.kunlong.dongxw.data.dao.DocumentMapper;
import com.kunlong.dongxw.data.service.DocumentService;
import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.mybatis.hbatis.orm.criteria.statement.UpdateStatement;
import org.mybatis.hbatis.orm.criteria.support.StatementBuilder;
/**
 * DocumentServiceImpl
 * @author generator
 * @date 2020年01月03日
 */
@Service
public class DocumentServiceImpl implements DocumentService {
	
	@Autowired
	private DocumentMapper repo;
	/**
	 * 保存
	 * @param entity
	 */
	public void save(Document entity){
		this.checkEntity(entity);
		repo.insert(entity);
	}

	/**
	 * 修改
	 * @param entity
	 */
	public void update(Document entity){
		this.checkEntity(entity);
		repo.update(entity);
	}
	/**
	 * 较验实体
	 * @param entity
	 */
	public void checkEntity(Document entity){
	
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(Long pk){
		repo.deleteByPK(pk);
	}
	
	/**
	 * 通过id获取
	 * @param id
	 * @return
	 */
	public Document findById(Long pk){
		return repo.selectByPK(pk);
	}
	/**
	 * 通过非空属性查询
	 * @param Document
	 * @return
	 */
	public List<Document> findByNotNullProps(Document entity){
		
		SelectStatement<Document> st = StatementBuilder.buildSelectSelective(entity);
		return repo.selectByStatement(st);
	}
	/**
	 * 通过主键更新非空属性
	 * @param Document
	 * @return
	 */
	public void updateNotNullPropsById(Document entity){
		
		UpdateStatement<Document> st = StatementBuilder.buildUpdateSelective(entity);
		repo.updateByStatement(st);
	}
	
	/**
	 * 通过实体参数分页查询
	 * @param Document.QueryParam
	 * @return
	 */
	public List<Document> findByQueryParam(Document.QueryParam queryParam){
		return repo.findByQueryParam(queryParam);
	}
	/**
	 * 通过实体参数统计
	 * @param Document.QueryParam
	 * @return
	 */
	public long countByQueryParam(Document.QueryParam queryParam) {
		return repo.countByQueryParam(queryParam);
	}
	/**
	 * 通过ID集合查询
	 * @param List<Long> pks
	 * @return
	 */
	public List<Document> findByIds(List<Long> pks) {
		return repo.selectByPKS(pks);
	}
	/**
	 * 值填充
	 */
	public void fillValues(List<Document> items, Document.ValueField... field) {
		if (items == null || items.isEmpty() || field.length < 1) {
			return;
		}
	}
}
