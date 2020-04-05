package com.kunlong.dongxw.data.service;

import com.kunlong.dongxw.data.domain.PoDaySeq;
import java.util.List;
/**
 * PoDaySeqService
 * @author generator
 * @date 2020年04月05日
 */
public interface PoDaySeqService {
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(PoDaySeq entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(PoDaySeq entity);
	
	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(Integer pk);
	
	/**
	 * 通过id获取
	 * @param id
	 * @return
	 */
	public PoDaySeq findById(Integer pk);
	/**
	 * 通过非空属性查询
	 * @param PoDaySeq
	 * @return
	 */
	public List<PoDaySeq> findByNotNullProps(PoDaySeq entity);
	/**
	 * 通过主键更新非空属性
	 * @param PoDaySeq
	 * @return
	 */
	public void updateNotNullPropsById(PoDaySeq entity);
	
	
	/**
	 * 通过实体参数分页查询
	 * @param PoDaySeq.QueryParam
	 * @return
	 */
	public List<PoDaySeq> findByQueryParam(PoDaySeq.QueryParam queryParam);
	/**
	 * 通过实体参数统计
	 * @param PoDaySeq.QueryParam
	 * @return
	 */
	public long countByQueryParam(PoDaySeq.QueryParam queryParam);
	/**
	 * 通过ID集合查询
	 * @param List<Integer> pks
	 * @return
	 */
	public List<PoDaySeq> findByIds(List<Integer> pks);
	/**
	 * 值填充
	 * @param items
	 * @param field
	 */
	public void fillValues(List<PoDaySeq> items,PoDaySeq.ValueField ...field);
}
