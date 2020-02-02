package com.kunlong.dongxw.dongxw.service;

import com.kunlong.dongxw.dongxw.domain.Bom;
import java.util.List;
/**
 * BomService
 * @author generator
 * @date 2020年02月02日
 */
public interface BomService {
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(Bom entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(Bom entity);
	
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
	public Bom findById(Integer pk);
	/**
	 * 通过非空属性查询
	 * @param Bom
	 * @return
	 */
	public List<Bom> findByNotNullProps(Bom entity);
	/**
	 * 通过主键更新非空属性
	 * @param Bom
	 * @return
	 */
	public void updateNotNullPropsById(Bom entity);
	
	
	/**
	 * 通过实体参数分页查询
	 * @param Bom.QueryParam
	 * @return
	 */
	public List<Bom> findByQueryParam(Bom.QueryParam queryParam);
	/**
	 * 通过实体参数统计
	 * @param Bom.QueryParam
	 * @return
	 */
	public long countByQueryParam(Bom.QueryParam queryParam);
	/**
	 * 通过ID集合查询
	 * @param List<Integer> pks
	 * @return
	 */
	public List<Bom> findByIds(List<Integer> pks);
	/**
	 * 值填充
	 * @param items
	 * @param field
	 */
	public void fillValues(List<Bom> items,Bom.ValueField ...field);
}
