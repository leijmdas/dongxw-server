package com.kunlong.dongxw.data.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.hbatis.orm.mapper.HbatisMapper;
import com.kunlong.dongxw.data.domain.Trade;
/**
 * TradeMapper
 * @author generator
 * @date 2020年09月26日
 */
public interface TradeMapper extends HbatisMapper<Trade, Integer> {
	
	
	//-- 按实体参数查询[START] 
	List<Trade> findByQueryParam(@Param("queryParam")Trade.QueryParam queryParam);
	
	long countByQueryParam(@Param("queryParam")Trade.QueryParam queryParam);
	//-- 按实体参数查询[END] 
	
	//-- 自定义业务方法，请写在下方 -->
}