package com.kunlong.dongxw.customer.controller;

import com.alibaba.fastjson.JSON;
import com.kunlong.dubbo.api.service.AuthApiService;
import com.kunlong.dongxw.customer.consts.SessionKeyEnum;
import com.kunlong.dongxw.customer.context.CurrentRequestContext;
import com.kunlong.dongxw.data.domain.Customer;
import com.kunlong.platform.consts.RequestContextConst;
import com.kunlong.platform.utils.KunlongUtils;
import com.alibaba.dubbo.config.annotation.Reference;

public class BaseController {
	@Reference(lazy = true, version = "${dubbo.service.version}")
	AuthApiService authApiService;


	protected Customer getCustomer() {
		String token = (String) CurrentRequestContext.getContext().getAttribute(RequestContextConst.KEY_SESSIONKEY);
		Object map = authApiService.getAttribute(token, SessionKeyEnum.WEB_CUSTOMER.getKey());

		return JSON.parseObject(KunlongUtils.toJSONStringPretty(map),Customer.class);

	}

	protected Integer getCustomerId() {
		Customer customer = getCustomer();
		return customer == null ? -1 : customer.getId();

	}

}
