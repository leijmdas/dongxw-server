package com.kunlong.dongxw.data.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kunlong.dongxw.data.domain.MakeSheet;
import com.kunlong.dongxw.data.dao.MakeSheetMapper;
import com.kunlong.dongxw.data.service.MakeSheetService;
import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.mybatis.hbatis.orm.criteria.statement.UpdateStatement;
import org.mybatis.hbatis.orm.criteria.support.StatementBuilder;
/**
 * MakeSheetServiceImpl
 * @author generator
 * @date 2020年02月28日
 */
@Service
public class MakeSheetServiceImpl implements MakeSheetService {
	
	@Autowired
	private MakeSheetMapper repo;
	/**
	 * 保存
	 * @param entity
	 */
	public void save(MakeSheet entity){
		this.checkEntity(entity);
		repo.insert(entity);
	}

	/**
	 * 修改
	 * @param entity
	 */
	public void update(MakeSheet entity){
		this.checkEntity(entity);
		repo.update(entity);
	}
	/**
	 * 较验实体
	 * @param entity
	 */
	public void checkEntity(MakeSheet entity){
	
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
	public MakeSheet findById(Integer pk){
		return repo.selectByPK(pk);
	}
	/**
	 * 通过非空属性查询
	 * @param MakeSheet
	 * @return
	 */
	public List<MakeSheet> findByNotNullProps(MakeSheet entity){
		
		SelectStatement<MakeSheet> st = StatementBuilder.buildSelectSelective(entity);
		return repo.selectByStatement(st);
	}
	/**
	 * 通过主键更新非空属性
	 * @param MakeSheet
	 * @return
	 */
	public void updateNotNullPropsById(MakeSheet entity){
		
		UpdateStatement<MakeSheet> st = StatementBuilder.buildUpdateSelective(entity);
		repo.updateByStatement(st);
	}
	
	/**
	 * 通过实体参数分页查询
	 * @param MakeSheet.QueryParam
	 * @return
	 */
	public List<MakeSheet> findByQueryParam(MakeSheet.QueryParam queryParam){
		return repo.findByQueryParam(queryParam);
	}
	/**
	 * 通过实体参数统计
	 * @param MakeSheet.QueryParam
	 * @return
	 */
	public long countByQueryParam(MakeSheet.QueryParam queryParam) {
		return repo.countByQueryParam(queryParam);
	}
	/**
	 * 通过ID集合查询
	 * @param List<Integer> pks
	 * @return
	 */
	public List<MakeSheet> findByIds(List<Integer> pks) {
		return repo.selectByPKS(pks);
	}
	/**
	 * 值填充
	 */
	public void fillValues(List<MakeSheet> items, MakeSheet.ValueField... field) {
		if (items == null || items.isEmpty() || field.length < 1) {
			return;
		}
	}
}
