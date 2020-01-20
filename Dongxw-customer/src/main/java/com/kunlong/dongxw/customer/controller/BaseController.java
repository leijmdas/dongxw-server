package com.kunlong.dongxw.customer.controller;

import com.alibaba.fastjson.JSON;
import com.kunlong.api.service.AuthApiService;
import com.kunlong.dongxw.customer.consts.SessionKeyEnum;
import com.kunlong.dongxw.customer.context.CurrentRequestContext;
import com.kunlong.dongxw.dongxw.domain.Customer;
import com.kunlong.dongxw.dongxw.service.CustomerService;
import com.kunlong.platform.consts.RequestContextConst;
import com.kunlong.platform.utils.KunlongUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class BaseController {
	@Reference(lazy = true, version = "${dubbo.service.version}")
	AuthApiService authApiService;

	//@Autowired
	//CustomerService customerService;

	Customer getCustomer() {
		String token = (String) CurrentRequestContext.getContext().getAttribute(RequestContextConst.KEY_SESSIONKEY);
		Object map = authApiService.getAttribute(token, SessionKeyEnum.WEB_CUSTOMER.getKey());
		//System.out.println(KunlongUtils.toJSONStringPretty(map));
		return JSON.parseObject(KunlongUtils.toJSONStringPretty(map),Customer.class);

	}

	Integer getCustomerId() {

		Customer customer=getCustomer();
		return customer==null?-1:customer.getId();

	}

}
