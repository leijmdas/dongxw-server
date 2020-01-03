package com.kunlong.dongxw.dongxw.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kunlong.dongxw.dongxw.domain.Supplier;
import com.kunlong.dongxw.dongxw.dao.SupplierMapper;
import com.kunlong.dongxw.dongxw.service.SupplierService;
import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.mybatis.hbatis.orm.criteria.statement.UpdateStatement;
import org.mybatis.hbatis.orm.criteria.support.StatementBuilder;
/**
 * SupplierServiceImpl
 * @author generator
 * @date 2020年01月03日
 */
@Service
public class SupplierServiceImpl implements SupplierService {
	
	@Autowired
	private SupplierMapper repo;
	/**
	 * 保存
	 * @param entity
	 */
	public void save(Supplier entity){
		this.checkEntity(entity);
		repo.insert(entity);
	}

	/**
	 * 修改
	 * @param entity
	 */
	public void update(Supplier entity){
		this.checkEntity(entity);
		repo.update(entity);
	}
	/**
	 * 较验实体
	 * @param entity
	 */
	public void checkEntity(Supplier entity){
	
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
	public Supplier findById(Integer pk){
		return repo.selectByPK(pk);
	}
	/**
	 * 通过非空属性查询
	 * @param Supplier
	 * @return
	 */
	public List<Supplier> findByNotNullProps(Supplier entity){
		
		SelectStatement<Supplier> st = StatementBuilder.buildSelectSelective(entity);
		return repo.selectByStatement(st);
	}
	/**
	 * 通过主键更新非空属性
	 * @param Supplier
	 * @return
	 */
	public void updateNotNullPropsById(Supplier entity){
		
		UpdateStatement<Supplier> st = StatementBuilder.buildUpdateSelective(entity);
		repo.updateByStatement(st);
	}
	
	/**
	 * 通过实体参数分页查询
	 * @param Supplier.QueryParam
	 * @return
	 */
	public List<Supplier> findByQueryParam(Supplier.QueryParam queryParam){
		return repo.findByQueryParam(queryParam);
	}
	/**
	 * 通过实体参数统计
	 * @param Supplier.QueryParam
	 * @return
	 */
	public long countByQueryParam(Supplier.QueryParam queryParam) {
		return repo.countByQueryParam(queryParam);
	}
	/**
	 * 通过ID集合查询
	 * @param List<Integer> pks
	 * @return
	 */
	public List<Supplier> findByIds(List<Integer> pks) {
		return repo.selectByPKS(pks);
	}
	/**
	 * 值填充
	 */
	public void fillValues(List<Supplier> items, Supplier.ValueField... field) {
		if (items == null || items.isEmpty() || field.length < 1) {
			return;
		}
	}
}
