package com.kunlong.dongxw.data.service;

import com.kunlong.dongxw.data.domain.TradeMaster;
import java.util.List;
/**
 * TradeMasterService
 * @author generator
 * @date 2020年09月27日
 */
public interface TradeMasterService {
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(TradeMaster entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(TradeMaster entity);
	
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
	public TradeMaster findById(Integer pk);
	/**
	 * 通过非空属性查询
	 * @param TradeMaster
	 * @return
	 */
	public List<TradeMaster> findByNotNullProps(TradeMaster entity);
	/**
	 * 通过主键更新非空属性
	 * @param TradeMaster
	 * @return
	 */
	public void updateNotNullPropsById(TradeMaster entity);
	
	
	/**
	 * 通过实体参数分页查询
	 * @param TradeMaster.QueryParam
	 * @return
	 */
	public List<TradeMaster> findByQueryParam(TradeMaster.QueryParam queryParam);
	/**
	 * 通过实体参数统计
	 * @param TradeMaster.QueryParam
	 * @return
	 */
	public long countByQueryParam(TradeMaster.QueryParam queryParam);
	/**
	 * 通过ID集合查询
	 * @param List<Integer> pks
	 * @return
	 */
	public List<TradeMaster> findByIds(List<Integer> pks);
	/**
	 * 值填充
	 * @param items
	 * @param field
	 */
	public void fillValues(List<TradeMaster> items,TradeMaster.ValueField ...field);
}
