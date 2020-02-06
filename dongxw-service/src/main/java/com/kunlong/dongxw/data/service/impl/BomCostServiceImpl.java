package com.kunlong.dongxw.data.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kunlong.dongxw.data.domain.BomCost;
import com.kunlong.dongxw.data.dao.BomCostMapper;
import com.kunlong.dongxw.data.service.BomCostService;
import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.mybatis.hbatis.orm.criteria.statement.UpdateStatement;
import org.mybatis.hbatis.orm.criteria.support.StatementBuilder;
/**
 * BomCostServiceImpl
 * @author generator
 * @date 2020年02月02日
 */
@Service
public class BomCostServiceImpl implements BomCostService {
	
	@Autowired
	private BomCostMapper repo;
	/**
	 * 保存
	 * @param entity
	 */
	public void save(BomCost entity){
		this.checkEntity(entity);
		repo.insert(entity);
	}

	/**
	 * 修改
	 * @param entity
	 */
	public void update(BomCost entity){
		this.checkEntity(entity);
		repo.update(entity);
	}
	/**
	 * 较验实体
	 * @param entity
	 */
	public void checkEntity(BomCost entity){
	
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
	public BomCost findById(Integer pk){
		return repo.selectByPK(pk);
	}
	/**
	 * 通过非空属性查询
	 * @param BomCost
	 * @return
	 */
	public List<BomCost> findByNotNullProps(BomCost entity){
		
		SelectStatement<BomCost> st = StatementBuilder.buildSelectSelective(entity);
		return repo.selectByStatement(st);
	}
	/**
	 * 通过主键更新非空属性
	 * @param BomCost
	 * @return
	 */
	public void updateNotNullPropsById(BomCost entity){
		
		UpdateStatement<BomCost> st = StatementBuilder.buildUpdateSelective(entity);
		repo.updateByStatement(st);
	}
	
	/**
	 * 通过实体参数分页查询
	 * @param BomCost.QueryParam
	 * @return
	 */
	public List<BomCost> findByQueryParam(BomCost.QueryParam queryParam){
		return repo.findByQueryParam(queryParam);
	}
	/**
	 * 通过实体参数统计
	 * @param BomCost.QueryParam
	 * @return
	 */
	public long countByQueryParam(BomCost.QueryParam queryParam) {
		return repo.countByQueryParam(queryParam);
	}
	/**
	 * 通过ID集合查询
	 * @param List<Integer> pks
	 * @return
	 */
	public List<BomCost> findByIds(List<Integer> pks) {
		return repo.selectByPKS(pks);
	}
	/**
	 * 值填充
	 */
	public void fillValues(List<BomCost> items, BomCost.ValueField... field) {
		if (items == null || items.isEmpty() || field.length < 1) {
			return;
		}
	}
}
