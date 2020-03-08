package com.kunlong.dongxw.data.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.hbatis.orm.mapper.HbatisMapper;
import com.kunlong.dongxw.data.domain.PurchaseOrderItem;
/**
 * PurchaseOrderItemMapper
 * @author generator
 * @date 2020年03月08日
 */
public interface PurchaseOrderItemMapper extends HbatisMapper<PurchaseOrderItem, Integer> {
	
	
	//-- 按实体参数查询[START] 
	List<PurchaseOrderItem> findByQueryParam(@Param("queryParam")PurchaseOrderItem.QueryParam queryParam);
	
	long countByQueryParam(@Param("queryParam")PurchaseOrderItem.QueryParam queryParam);
	//-- 按实体参数查询[END] 
	
	//-- 自定义业务方法，请写在下方 -->
}