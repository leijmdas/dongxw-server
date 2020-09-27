package com.kunlong.dongxw.data.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.hbatis.orm.mapper.HbatisMapper;
import com.kunlong.dongxw.data.domain.TradeMaster;
/**
 * TradeMasterMapper
 * @author generator
 * @date 2020年09月27日
 */
public interface TradeMasterMapper extends HbatisMapper<TradeMaster, Integer> {
	
	
	//-- 按实体参数查询[START] 
	List<TradeMaster> findByQueryParam(@Param("queryParam")TradeMaster.QueryParam queryParam);
	
	long countByQueryParam(@Param("queryParam")TradeMaster.QueryParam queryParam);
	//-- 按实体参数查询[END] 
	
	//-- 自定义业务方法，请写在下方 -->
}