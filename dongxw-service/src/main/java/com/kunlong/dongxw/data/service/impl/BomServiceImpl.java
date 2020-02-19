package com.kunlong.dongxw.data.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kunlong.dongxw.data.domain.Bom;
import com.kunlong.dongxw.data.dao.BomMapper;
import com.kunlong.dongxw.data.service.BomService;
import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.mybatis.hbatis.orm.criteria.statement.UpdateStatement;
import org.mybatis.hbatis.orm.criteria.support.StatementBuilder;
/**
 * BomServiceImpl
 * @author generator
 * @date 2020年02月19日
 */
@Service
public class BomServiceImpl implements BomService {
	
	@Autowired
	private BomMapper repo;
	/**
	 * 保存
	 * @param entity
	 */
	public void save(Bom entity){
		this.checkEntity(entity);
		repo.insert(entity);
	}

	/**
	 * 修改
	 * @param entity
	 */
	public void update(Bom entity){
		this.checkEntity(entity);
		repo.update(entity);
	}
	/**
	 * 较验实体
	 * @param entity
	 */
	public void checkEntity(Bom entity){
	
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
	public Bom findById(Integer pk){
		return repo.selectByPK(pk);
	}
	/**
	 * 通过非空属性查询
	 * @param Bom
	 * @return
	 */
	public List<Bom> findByNotNullProps(Bom entity){
		
		SelectStatement<Bom> st = StatementBuilder.buildSelectSelective(entity);
		return repo.selectByStatement(st);
	}
	/**
	 * 通过主键更新非空属性
	 * @param Bom
	 * @return
	 */
	public void updateNotNullPropsById(Bom entity){
		
		UpdateStatement<Bom> st = StatementBuilder.buildUpdateSelective(entity);
		repo.updateByStatement(st);
	}
	
	/**
	 * 通过实体参数分页查询
	 * @param Bom.QueryParam
	 * @return
	 */
	public List<Bom> findByQueryParam(Bom.QueryParam queryParam){
		return repo.findByQueryParam(queryParam);
	}
	/**
	 * 通过实体参数统计
	 * @param Bom.QueryParam
	 * @return
	 */
	public long countByQueryParam(Bom.QueryParam queryParam) {
		return repo.countByQueryParam(queryParam);
	}
	/**
	 * 通过ID集合查询
	 * @param List<Integer> pks
	 * @return
	 */
	public List<Bom> findByIds(List<Integer> pks) {
		return repo.selectByPKS(pks);
	}
	/**
	 * 值填充
	 */
	public void fillValues(List<Bom> items, Bom.ValueField... field) {
		if (items == null || items.isEmpty() || field.length < 1) {
			return;
		}
	}
}
