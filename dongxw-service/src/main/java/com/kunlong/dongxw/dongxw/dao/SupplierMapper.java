package com.kunlong.dongxw.dongxw.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.hbatis.orm.mapper.HbatisMapper;
import com.kunlong.dongxw.dongxw.domain.Supplier;
/**
 * SupplierMapper
 * @author generator
 * @date 2020年01月03日
 */
public interface SupplierMapper extends HbatisMapper<Supplier, Integer> {
	
	
	//-- 按实体参数查询[START] 
	List<Supplier> findByQueryParam(@Param("queryParam")Supplier.QueryParam queryParam);
	
	long countByQueryParam(@Param("queryParam")Supplier.QueryParam queryParam);
	//-- 按实体参数查询[END] 
	
	//-- 自定义业务方法，请写在下方 -->
}