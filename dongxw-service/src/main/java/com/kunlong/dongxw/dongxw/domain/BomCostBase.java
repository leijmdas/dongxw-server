package com.kunlong.dongxw.dongxw.domain;

import com.kunlong.platform.model.KunlongModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * OrderLineBase 订单产品表
 * @author generator
 * @date 2020年01月04日
 */
public class BomCostBase extends KunlongModel implements Serializable {
	 public static BomCost defaultBomCosrt (Integer productId){
		 BomCost bomCost = new BomCost();
		 bomCost.setProductId(productId);
		 bomCost.setCreateDate(new Date());
		 bomCost.setCreateBy(0);
		 bomCost.setRemark("");
		 bomCost.setVersion("");
		 bomCost.setRmFee(BigDecimal.ZERO);
		 bomCost.setTotalFee(BigDecimal.ZERO);
		 bomCost.setCutRm(BigDecimal.ZERO);
		 bomCost.setKnifeModel(BigDecimal.ZERO);
		 bomCost.setShippingFee(BigDecimal.ZERO);
		 bomCost.setLossRm(BigDecimal.ZERO);
		 bomCost.setWorkFee(BigDecimal.ZERO);
		 return bomCost;
	 }
}