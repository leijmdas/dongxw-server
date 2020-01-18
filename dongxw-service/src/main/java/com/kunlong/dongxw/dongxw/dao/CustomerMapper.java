package com.kunlong.dongxw.dongxw.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.hbatis.orm.mapper.HbatisMapper;
import com.kunlong.dongxw.dongxw.domain.Customer;
/**
 * CustomerMapper
 * @author generator
 * @date 2020年01月18日
 */
public interface CustomerMapper extends HbatisMapper<Customer, Integer> {
	
	
	//-- 按实体参数查询[START] 
	List<Customer> findByQueryParam(@Param("queryParam")Customer.QueryParam queryParam);
	
	long countByQueryParam(@Param("queryParam")Customer.QueryParam queryParam);
	//-- 按实体参数查询[END] 
	
	//-- 自定义业务方法，请写在下方 -->
}