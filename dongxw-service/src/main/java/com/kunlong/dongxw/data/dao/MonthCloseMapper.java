package com.kunlong.dongxw.data.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.hbatis.orm.mapper.HbatisMapper;
import com.kunlong.dongxw.data.domain.MonthClose;
/**
 * MonthCloseMapper
 * @author generator
 * @date 2020年08月09日
 */
public interface MonthCloseMapper extends HbatisMapper<MonthClose, Integer> {
	
	
	//-- 按实体参数查询[START] 
	List<MonthClose> findByQueryParam(@Param("queryParam")MonthClose.QueryParam queryParam);
	
	long countByQueryParam(@Param("queryParam")MonthClose.QueryParam queryParam);
	//-- 按实体参数查询[END] 
	
	//-- 自定义业务方法，请写在下方 -->
}