package com.kunlong.dongxw.data.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.hbatis.orm.mapper.HbatisMapper;
import com.kunlong.dongxw.data.domain.WhStock;
/**
 * WhStockMapper
 * @author generator
 * @date 2020年09月22日
 */
public interface WhStockMapper extends HbatisMapper<WhStock, Integer> {
	
	
	//-- 按实体参数查询[START] 
	List<WhStock> findByQueryParam(@Param("queryParam")WhStock.QueryParam queryParam);
	
	long countByQueryParam(@Param("queryParam")WhStock.QueryParam queryParam);
	//-- 按实体参数查询[END] 
	
	//-- 自定义业务方法，请写在下方 -->
}