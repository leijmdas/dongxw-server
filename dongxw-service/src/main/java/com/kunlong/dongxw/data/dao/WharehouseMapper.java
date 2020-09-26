package com.kunlong.dongxw.data.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.hbatis.orm.mapper.HbatisMapper;
import com.kunlong.dongxw.data.domain.Wharehouse;
/**
 * WharehouseMapper
 * @author generator
 * @date 2020年09月22日
 */
public interface WharehouseMapper extends HbatisMapper<Wharehouse, Integer> {
	
	
	//-- 按实体参数查询[START] 
	List<Wharehouse> findByQueryParam(@Param("queryParam")Wharehouse.QueryParam queryParam);
	
	long countByQueryParam(@Param("queryParam")Wharehouse.QueryParam queryParam);
	//-- 按实体参数查询[END] 
	
	//-- 自定义业务方法，请写在下方 -->
}