package com.kunlong.dongxw.data.service;

import com.kunlong.dongxw.data.domain.VRmType;
import java.util.List;
/**
 * VRmTypeService
 * @author generator
 * @date 2020年05月31日
 */
public interface VRmTypeService {
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(VRmType entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(VRmType entity);
	
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
	public VRmType findById(Integer pk);
	/**
	 * 通过非空属性查询
	 * @param VRmType
	 * @return
	 */
	public List<VRmType> findByNotNullProps(VRmType entity);
	/**
	 * 通过主键更新非空属性
	 * @param VRmType
	 * @return
	 */
	public void updateNotNullPropsById(VRmType entity);
	
	
	/**
	 * 通过实体参数分页查询
	 * @param VRmType.QueryParam
	 * @return
	 */
	public List<VRmType> findByQueryParam(VRmType.QueryParam queryParam);
	/**
	 * 通过实体参数统计
	 * @param VRmType.QueryParam
	 * @return
	 */
	public long countByQueryParam(VRmType.QueryParam queryParam);
	/**
	 * 通过ID集合查询
	 * @param List<Integer> pks
	 * @return
	 */
	public List<VRmType> findByIds(List<Integer> pks);
	/**
	 * 值填充
	 * @param items
	 * @param field
	 */
	public void fillValues(List<VRmType> items,VRmType.ValueField ...field);
}
