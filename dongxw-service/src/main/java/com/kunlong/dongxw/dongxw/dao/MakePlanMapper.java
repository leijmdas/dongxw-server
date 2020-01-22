package com.kunlong.dongxw.dongxw.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.hbatis.orm.mapper.HbatisMapper;
import com.kunlong.dongxw.dongxw.domain.MakePlan;
/**
 * MakePlanMapper
 * @author generator
 * @date 2020年01月23日
 */
public interface MakePlanMapper extends HbatisMapper<MakePlan, Integer> {
	
	
	//-- 按实体参数查询[START] 
	List<MakePlan> findByQueryParam(@Param("queryParam")MakePlan.QueryParam queryParam);
	
	long countByQueryParam(@Param("queryParam")MakePlan.QueryParam queryParam);
	//-- 按实体参数查询[END] 
	
	//-- 自定义业务方法，请写在下方 -->
}