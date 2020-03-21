package com.kunlong.dongxw.data.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kunlong.dongxw.data.domain.VRmType;
import com.kunlong.dongxw.data.dao.VRmTypeMapper;
import com.kunlong.dongxw.data.service.VRmTypeService;
import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.mybatis.hbatis.orm.criteria.statement.UpdateStatement;
import org.mybatis.hbatis.orm.criteria.support.StatementBuilder;
/**
 * VRmTypeServiceImpl
 * @author generator
 * @date 2020年03月21日
 */
@Service
public class VRmTypeServiceImpl implements VRmTypeService {
	
	@Autowired
	private VRmTypeMapper repo;
	/**
	 * 保存
	 * @param entity
	 */
	public void save(VRmType entity){
		this.checkEntity(entity);
		repo.insert(entity);
	}

	/**
	 * 修改
	 * @param entity
	 */
	public void update(VRmType entity){
		this.checkEntity(entity);
		repo.update(entity);
	}
	/**
	 * 较验实体
	 * @param entity
	 */
	public void checkEntity(VRmType entity){
	
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
	public VRmType findById(Integer pk){
		return repo.selectByPK(pk);
	}
	/**
	 * 通过非空属性查询
	 * @param VRmType
	 * @return
	 */
	public List<VRmType> findByNotNullProps(VRmType entity){
		
		SelectStatement<VRmType> st = StatementBuilder.buildSelectSelective(entity);
		return repo.selectByStatement(st);
	}
	/**
	 * 通过主键更新非空属性
	 * @param VRmType
	 * @return
	 */
	public void updateNotNullPropsById(VRmType entity){
		
		UpdateStatement<VRmType> st = StatementBuilder.buildUpdateSelective(entity);
		repo.updateByStatement(st);
	}
	
	/**
	 * 通过实体参数分页查询
	 * @param VRmType.QueryParam
	 * @return
	 */
	public List<VRmType> findByQueryParam(VRmType.QueryParam queryParam){
		return repo.findByQueryParam(queryParam);
	}
	/**
	 * 通过实体参数统计
	 * @param VRmType.QueryParam
	 * @return
	 */
	public long countByQueryParam(VRmType.QueryParam queryParam) {
		return repo.countByQueryParam(queryParam);
	}
	/**
	 * 通过ID集合查询
	 * @param List<Integer> pks
	 * @return
	 */
	public List<VRmType> findByIds(List<Integer> pks) {
		return repo.selectByPKS(pks);
	}
	/**
	 * 值填充
	 */
	public void fillValues(List<VRmType> items, VRmType.ValueField... field) {
		if (items == null || items.isEmpty() || field.length < 1) {
			return;
		}
	}
}
