package com.kunlong.dongxw.data.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.hbatis.orm.mapper.HbatisMapper;
import com.kunlong.dongxw.data.domain.MakeSheet;
/**
 * MakeSheetMapper
 * @author generator
 * @date 2020年02月04日
 */
public interface MakeSheetMapper extends HbatisMapper<MakeSheet, Integer> {
	
	
	//-- 按实体参数查询[START] 
	List<MakeSheet> findByQueryParam(@Param("queryParam")MakeSheet.QueryParam queryParam);
	
	long countByQueryParam(@Param("queryParam")MakeSheet.QueryParam queryParam);
	//-- 按实体参数查询[END] 
	
	//-- 自定义业务方法，请写在下方 -->
}