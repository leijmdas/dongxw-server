package com.kunlong.dongxw.data.service;

import com.kunlong.dongxw.data.domain.MakeSheet;
import java.util.List;
/**
 * MakeSheetService
 * @author generator
 * @date 2020年02月16日
 */
public interface MakeSheetService {
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(MakeSheet entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(MakeSheet entity);
	
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
	public MakeSheet findById(Integer pk);
	/**
	 * 通过非空属性查询
	 * @param MakeSheet
	 * @return
	 */
	public List<MakeSheet> findByNotNullProps(MakeSheet entity);
	/**
	 * 通过主键更新非空属性
	 * @param MakeSheet
	 * @return
	 */
	public void updateNotNullPropsById(MakeSheet entity);
	
	
	/**
	 * 通过实体参数分页查询
	 * @param MakeSheet.QueryParam
	 * @return
	 */
	public List<MakeSheet> findByQueryParam(MakeSheet.QueryParam queryParam);
	/**
	 * 通过实体参数统计
	 * @param MakeSheet.QueryParam
	 * @return
	 */
	public long countByQueryParam(MakeSheet.QueryParam queryParam);
	/**
	 * 通过ID集合查询
	 * @param List<Integer> pks
	 * @return
	 */
	public List<MakeSheet> findByIds(List<Integer> pks);
	/**
	 * 值填充
	 * @param items
	 * @param field
	 */
	public void fillValues(List<MakeSheet> items,MakeSheet.ValueField ...field);
}
