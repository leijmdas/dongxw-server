package com.kunlong.dongxw.data.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.hbatis.orm.mapper.HbatisMapper;
import com.kunlong.dongxw.data.domain.VOrderPlan;
/**
 * VOrderPlanMapper
 * @author generator
 * @date 2020年03月21日
 */
public interface VOrderPlanMapper extends HbatisMapper<VOrderPlan, Integer> {
	
	
	//-- 按实体参数查询[START] 
	List<VOrderPlan> findByQueryParam(@Param("queryParam")VOrderPlan.QueryParam queryParam);
	
	long countByQueryParam(@Param("queryParam")VOrderPlan.QueryParam queryParam);
	//-- 按实体参数查询[END] 
	
	//-- 自定义业务方法，请写在下方 -->
}