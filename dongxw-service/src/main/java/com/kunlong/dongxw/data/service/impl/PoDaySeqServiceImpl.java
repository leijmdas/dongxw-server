package com.kunlong.dongxw.data.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kunlong.dongxw.data.domain.PoDaySeq;
import com.kunlong.dongxw.data.dao.PoDaySeqMapper;
import com.kunlong.dongxw.data.service.PoDaySeqService;
import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.mybatis.hbatis.orm.criteria.statement.UpdateStatement;
import org.mybatis.hbatis.orm.criteria.support.StatementBuilder;
/**
 * PoDaySeqServiceImpl
 * @author generator
 * @date 2020年04月05日
 */
@Service
public class PoDaySeqServiceImpl implements PoDaySeqService {
	
	@Autowired
	private PoDaySeqMapper repo;
	/**
	 * 保存
	 * @param entity
	 */
	public void save(PoDaySeq entity){
		this.checkEntity(entity);
		repo.insert(entity);
	}

	/**
	 * 修改
	 * @param entity
	 */
	public void update(PoDaySeq entity){
		this.checkEntity(entity);
		repo.update(entity);
	}
	/**
	 * 较验实体
	 * @param entity
	 */
	public void checkEntity(PoDaySeq entity){
	
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
	public PoDaySeq findById(Integer pk){
		return repo.selectByPK(pk);
	}
	/**
	 * 通过非空属性查询
	 * @param PoDaySeq
	 * @return
	 */
	public List<PoDaySeq> findByNotNullProps(PoDaySeq entity){
		
		SelectStatement<PoDaySeq> st = StatementBuilder.buildSelectSelective(entity);
		return repo.selectByStatement(st);
	}
	/**
	 * 通过主键更新非空属性
	 * @param PoDaySeq
	 * @return
	 */
	public void updateNotNullPropsById(PoDaySeq entity){
		
		UpdateStatement<PoDaySeq> st = StatementBuilder.buildUpdateSelective(entity);
		repo.updateByStatement(st);
	}
	
	/**
	 * 通过实体参数分页查询
	 * @param PoDaySeq.QueryParam
	 * @return
	 */
	public List<PoDaySeq> findByQueryParam(PoDaySeq.QueryParam queryParam){
		return repo.findByQueryParam(queryParam);
	}
	/**
	 * 通过实体参数统计
	 * @param PoDaySeq.QueryParam
	 * @return
	 */
	public long countByQueryParam(PoDaySeq.QueryParam queryParam) {
		return repo.countByQueryParam(queryParam);
	}
	/**
	 * 通过ID集合查询
	 * @param List<Integer> pks
	 * @return
	 */
	public List<PoDaySeq> findByIds(List<Integer> pks) {
		return repo.selectByPKS(pks);
	}
	/**
	 * 值填充
	 */
	public void fillValues(List<PoDaySeq> items, PoDaySeq.ValueField... field) {
		if (items == null || items.isEmpty() || field.length < 1) {
			return;
		}
	}
}
