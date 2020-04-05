package com.kunlong.dongxw.data.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.hbatis.orm.mapper.HbatisMapper;
import com.kunlong.dongxw.data.domain.PurchasePlan;
/**
 * PurchasePlanMapper
 * @author generator
 * @date 2020年04月05日
 */
public interface PurchasePlanMapper extends HbatisMapper<PurchasePlan, Integer> {
	
	
	//-- 按实体参数查询[START] 
	List<PurchasePlan> findByQueryParam(@Param("queryParam")PurchasePlan.QueryParam queryParam);
	
	long countByQueryParam(@Param("queryParam")PurchasePlan.QueryParam queryParam);
	//-- 按实体参数查询[END] 
	
	//-- 自定义业务方法，请写在下方 -->
}