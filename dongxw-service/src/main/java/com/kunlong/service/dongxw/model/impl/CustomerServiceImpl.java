package com.kunlong.service.dongxw.model.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kunlong.service.dongxw.domain.Customer;
import com.kunlong.service.dongxw.dao.CustomerMapper;
import com.kunlong.service.dongxw.service.CustomerService;
import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.mybatis.hbatis.orm.criteria.statement.UpdateStatement;
import org.mybatis.hbatis.orm.criteria.support.StatementBuilder;
/**
 * CustomerServiceImpl
 * @author generator
 * @date 2019年12月19日
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerMapper repo;
	/**
	 * 保存
	 * @param entity
	 */
	public void save(Customer entity){
		this.checkEntity(entity);
		repo.insert(entity);
	}

	/**
	 * 修改
	 * @param entity
	 */
	public void update(Customer entity){
		this.checkEntity(entity);
		repo.update(entity);
	}
	/**
	 * 较验实体
	 * @param entity
	 */
	public void checkEntity(Customer entity){
	
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
	public Customer findById(Integer pk){
		return repo.selectByPK(pk);
	}
	/**
	 * 通过非空属性查询
	 * @param Customer
	 * @return
	 */
	public List<Customer> findByNotNullProps(Customer entity){
		
		SelectStatement<Customer> st = StatementBuilder.buildSelectSelective(entity);
		return repo.selectByStatement(st);
	}
	/**
	 * 通过主键更新非空属性
	 * @param Customer
	 * @return
	 */
	public void updateNotNullPropsById(Customer entity){
		
		UpdateStatement<Customer> st = StatementBuilder.buildUpdateSelective(entity);
		repo.updateByStatement(st);
	}
	
	/**
	 * 通过实体参数分页查询
	 * @param Customer.QueryParam
	 * @return
	 */
	public List<Customer> findByQueryParam(Customer.QueryParam queryParam){
		return repo.findByQueryParam(queryParam);
	}
	/**
	 * 通过实体参数统计
	 * @param Customer.QueryParam
	 * @return
	 */
	public long countByQueryParam(Customer.QueryParam queryParam) {
		return repo.countByQueryParam(queryParam);
	}
	/**
	 * 通过ID集合查询
	 * @param List<Integer> pks
	 * @return
	 */
	public List<Customer> findByIds(List<Integer> pks) {
		return repo.selectByPKS(pks);
	}
	/**
	 * 值填充
	 */
	public void fillValues(List<Customer> items, Customer.ValueField... field) {
		if (items == null || items.isEmpty() || field.length < 1) {
			return;
		}
	}
}
