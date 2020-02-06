package com.kunlong.dongxw.data.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.hbatis.orm.mapper.HbatisMapper;
import com.kunlong.dongxw.data.domain.ProductType;
/**
 * ProductTypeMapper
 * @author generator
 * @date 2020年01月24日
 */
public interface ProductTypeMapper extends HbatisMapper<ProductType, Integer> {
	
	
	//-- 按实体参数查询[START] 
	List<ProductType> findByQueryParam(@Param("queryParam")ProductType.QueryParam queryParam);
	
	long countByQueryParam(@Param("queryParam")ProductType.QueryParam queryParam);
	//-- 按实体参数查询[END] 
	
	//-- 自定义业务方法，请写在下方 -->
}