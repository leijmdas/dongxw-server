package com.kunlong.dongxw.data.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kunlong.dongxw.data.domain.TradeMaster;
import com.kunlong.dongxw.data.dao.TradeMasterMapper;
import com.kunlong.dongxw.data.service.TradeMasterService;
import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.mybatis.hbatis.orm.criteria.statement.UpdateStatement;
import org.mybatis.hbatis.orm.criteria.support.StatementBuilder;
/**
 * TradeMasterServiceImpl
 * @author generator
 * @date 2020年09月27日
 */
@Service
public class TradeMasterServiceImpl implements TradeMasterService {
	
	@Autowired
	private TradeMasterMapper repo;
	/**
	 * 保存
	 * @param entity
	 */
	public void save(TradeMaster entity){
		this.checkEntity(entity);
		repo.insert(entity);
	}

	/**
	 * 修改
	 * @param entity
	 */
	public void update(TradeMaster entity){
		this.checkEntity(entity);
		repo.update(entity);
	}
	/**
	 * 较验实体
	 * @param entity
	 */
	public void checkEntity(TradeMaster entity){
	
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
	public TradeMaster findById(Integer pk){
		return repo.selectByPK(pk);
	}
	/**
	 * 通过非空属性查询
	 * @param TradeMaster
	 * @return
	 */
	public List<TradeMaster> findByNotNullProps(TradeMaster entity){
		
		SelectStatement<TradeMaster> st = StatementBuilder.buildSelectSelective(entity);
		return repo.selectByStatement(st);
	}
	/**
	 * 通过主键更新非空属性
	 * @param TradeMaster
	 * @return
	 */
	public void updateNotNullPropsById(TradeMaster entity){
		
		UpdateStatement<TradeMaster> st = StatementBuilder.buildUpdateSelective(entity);
		repo.updateByStatement(st);
	}
	
	/**
	 * 通过实体参数分页查询
	 * @param TradeMaster.QueryParam
	 * @return
	 */
	public List<TradeMaster> findByQueryParam(TradeMaster.QueryParam queryParam){
		return repo.findByQueryParam(queryParam);
	}
	/**
	 * 通过实体参数统计
	 * @param TradeMaster.QueryParam
	 * @return
	 */
	public long countByQueryParam(TradeMaster.QueryParam queryParam) {
		return repo.countByQueryParam(queryParam);
	}
	/**
	 * 通过ID集合查询
	 * @param List<Integer> pks
	 * @return
	 */
	public List<TradeMaster> findByIds(List<Integer> pks) {
		return repo.selectByPKS(pks);
	}
	/**
	 * 值填充
	 */
	public void fillValues(List<TradeMaster> items, TradeMaster.ValueField... field) {
		if (items == null || items.isEmpty() || field.length < 1) {
			return;
		}
	}
}
