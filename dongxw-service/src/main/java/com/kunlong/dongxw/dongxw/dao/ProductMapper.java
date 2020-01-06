package com.kunlong.dongxw.dongxw.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.hbatis.orm.mapper.HbatisMapper;
import com.kunlong.dongxw.dongxw.domain.Product;
/**
 * ProductMapper
 * @author generator
 * @date 2020年01月07日
 */
public interface ProductMapper extends HbatisMapper<Product, Integer> {
	
	
	//-- 按实体参数查询[START] 
	List<Product> findByQueryParam(@Param("queryParam")Product.QueryParam queryParam);
	
	long countByQueryParam(@Param("queryParam")Product.QueryParam queryParam);
	//-- 按实体参数查询[END] 
	
	//-- 自定义业务方法，请写在下方 -->
}