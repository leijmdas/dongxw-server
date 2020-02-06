package com.kunlong.dongxw.data.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.hbatis.orm.mapper.HbatisMapper;
import com.kunlong.dongxw.data.domain.Document;
/**
 * DocumentMapper
 * @author generator
 * @date 2020年01月03日
 */
public interface DocumentMapper extends HbatisMapper<Document, Long> {
	
	
	//-- 按实体参数查询[START] 
	List<Document> findByQueryParam(@Param("queryParam")Document.QueryParam queryParam);
	
	long countByQueryParam(@Param("queryParam")Document.QueryParam queryParam);
	//-- 按实体参数查询[END] 
	
	//-- 自定义业务方法，请写在下方 -->
}