package com.kunlong.dongxw.data.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kunlong.dongxw.data.domain.WhStock;
import com.kunlong.dongxw.data.dao.WhStockMapper;
import com.kunlong.dongxw.data.service.WhStockService;
import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.mybatis.hbatis.orm.criteria.statement.UpdateStatement;
import org.mybatis.hbatis.orm.criteria.support.StatementBuilder;
/**
 * WhStockServiceImpl
 * @author generator
 * @date 2020年09月22日
 */
@Service
public class WhStockServiceImpl implements WhStockService {
	
	@Autowired
	private WhStockMapper repo;
	/**
	 * 保存
	 * @param entity
	 */
	public void save(WhStock entity){
		this.checkEntity(entity);
		repo.insert(entity);
	}

	/**
	 * 修改
	 * @param entity
	 */
	public void update(WhStock entity){
		this.checkEntity(entity);
		repo.update(entity);
	}
	/**
	 * 较验实体
	 * @param entity
	 */
	public void checkEntity(WhStock entity){
	
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(Integer pk){
		repo.deleteByPK(pk);
	}
	
	/**
	 * 通过id获取
	 * @param id
	 * @return
	 */
	public WhStock findById(Integer pk){
		return repo.selectByPK(pk);
	}
	/**
	 * 通过非空属性查询
	 * @param WhStock
	 * @return
	 */
	public List<WhStock> findByNotNullProps(WhStock entity){
		
		SelectStatement<WhStock> st = StatementBuilder.buildSelectSelective(entity);
		return repo.selectByStatement(st);
	}
	/**
	 * 通过主键更新非空属性
	 * @param WhStock
	 * @return
	 */
	public void updateNotNullPropsById(WhStock entity){
		
		UpdateStatement<WhStock> st = StatementBuilder.buildUpdateSelective(entity);
		repo.updateByStatement(st);
	}
	
	/**
	 * 通过实体参数分页查询
	 * @param WhStock.QueryParam
	 * @return
	 */
	public List<WhStock> findByQueryParam(WhStock.QueryParam queryParam){
		return repo.findByQueryParam(queryParam);
	}
	/**
	 * 通过实体参数统计
	 * @param WhStock.QueryParam
	 * @return
	 */
	public long countByQueryParam(WhStock.QueryParam queryParam) {
		return repo.countByQueryParam(queryParam);
	}
	/**
	 * 通过ID集合查询
	 * @param List<Integer> pks
	 * @return
	 */
	public List<WhStock> findByIds(List<Integer> pks) {
		return repo.selectByPKS(pks);
	}
	/**
	 * 值填充
	 */
	public void fillValues(List<WhStock> items, WhStock.ValueField... field) {
		if (items == null || items.isEmpty() || field.length < 1) {
			return;
		}
	}
}
