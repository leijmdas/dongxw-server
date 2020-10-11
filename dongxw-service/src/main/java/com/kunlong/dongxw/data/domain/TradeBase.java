package com.kunlong.dongxw.data.domain;

import com.kunlong.platform.model.KunlongModel;

import java.io.Serializable;


/**
 * OrderLineBase 订单产品表
 * @author generator
 * @date 2020年01月04日
 */
public class TradeBase extends KunlongModel implements Serializable {

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	Product  product ;

	public TradeMaster getTradeMaster() {
		return tradeMaster;
	}

	public void setTradeMaster(TradeMaster tradeMaster) {
		this.tradeMaster = tradeMaster;
	}

	TradeMaster tradeMaster;

	private static final long serialVersionUID = 1L;

}