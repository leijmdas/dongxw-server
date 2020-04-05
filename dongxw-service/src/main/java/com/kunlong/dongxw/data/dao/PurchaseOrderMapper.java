package com.kunlong.dongxw.data.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.hbatis.orm.mapper.HbatisMapper;
import com.kunlong.dongxw.data.domain.PurchaseOrder;
/**
 * PurchaseOrderMapper
 * @author generator
 * @date 2020年04月05日
 */
public interface PurchaseOrderMapper extends HbatisMapper<PurchaseOrder, Integer> {
	
	
	//-- 按实体参数查询[START] 
	List<PurchaseOrder> findByQueryParam(@Param("queryParam")PurchaseOrder.QueryParam queryParam);
	
	long countByQueryParam(@Param("queryParam")PurchaseOrder.QueryParam queryParam);
	//-- 按实体参数查询[END] 
	
	//-- 自定义业务方法，请写在下方 -->
}