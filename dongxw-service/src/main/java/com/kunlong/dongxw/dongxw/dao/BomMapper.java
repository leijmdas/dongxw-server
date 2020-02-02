package com.kunlong.dongxw.dongxw.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.hbatis.orm.mapper.HbatisMapper;
import com.kunlong.dongxw.dongxw.domain.Bom;
/**
 * BomMapper
 * @author generator
 * @date 2020年02月02日
 */
public interface BomMapper extends HbatisMapper<Bom, Integer> {
	
	
	//-- 按实体参数查询[START] 
	List<Bom> findByQueryParam(@Param("queryParam")Bom.QueryParam queryParam);
	
	long countByQueryParam(@Param("queryParam")Bom.QueryParam queryParam);
	//-- 按实体参数查询[END] 
	
	//-- 自定义业务方法，请写在下方 -->
}