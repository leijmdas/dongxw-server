package com.kunlong.dongxw.manager.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.hbatis.orm.mapper.HbatisMapper;
import com.kunlong.dongxw.manager.domain.DictDatatype;
/**
 * DictDatatypeMapper
 * @author generator
 * @date 2019年12月19日
 */
public interface DictDatatypeMapper extends HbatisMapper<DictDatatype, Integer> {
	
	
	//-- 按实体参数查询[START] 
	List<DictDatatype> findByQueryParam(@Param("queryParam") DictDatatype.QueryParam queryParam);
	
	long countByQueryParam(@Param("queryParam") DictDatatype.QueryParam queryParam);
	//-- 按实体参数查询[END] 
	
	//-- 自定义业务方法，请写在下方 -->
}