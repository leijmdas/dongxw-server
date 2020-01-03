package com.kunlong.dongxw.dongxw.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.hbatis.orm.mapper.HbatisMapper;
import com.kunlong.dongxw.dongxw.domain.OrderMaster;
/**
 * OrderMasterMapper
 * @author generator
 * @date 2020年01月03日
 */
public interface OrderMasterMapper extends HbatisMapper<OrderMaster, Integer> {
	
	
	//-- 按实体参数查询[START] 
	List<OrderMaster> findByQueryParam(@Param("queryParam")OrderMaster.QueryParam queryParam);
	
	long countByQueryParam(@Param("queryParam")OrderMaster.QueryParam queryParam);
	//-- 按实体参数查询[END] 
	
	//-- 自定义业务方法，请写在下方 -->
}