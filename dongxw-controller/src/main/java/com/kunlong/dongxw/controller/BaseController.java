package com.kunlong.dongxw.controller;

import cn.kunlong.center.api.model.SysUserDTO;
import cn.kunlong.center.api.service.SysUserApiService;
import com.kunlong.api.service.AuthApiService;
import com.kunlong.api.service.MailApiService;
import com.kunlong.dongxw.context.CurrentRequestContext;
import com.kunlong.platform.consts.RequestContextConst;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseController {
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Reference(lazy = true, version = "${dubbo.service.version}")
	MailApiService mailApiService;

	@Reference(lazy = true, version = "${dubbo.service.version}")
	AuthApiService authApiService;


	@Reference(lazy = true, version = "${dubbo.service.version}")
	SysUserApiService sysUserApiService;
	public SysUserDTO findUserById(Integer userId){
		return sysUserApiService.findById(userId);
	}

	public Integer getCurrentUserId() {
		String token = (String) CurrentRequestContext.getContext().getAttribute(RequestContextConst.KEY_SESSIONKEY);

		return authApiService.getCurrentUserId(token);

	}

	private SysUserDTO getCurrentSysUser() {
		String token = (String) CurrentRequestContext.getContext().getAttribute(RequestContextConst.KEY_SESSIONKEY);

		return authApiService.getCurrentSysUser(token);
	}


	
//	public Integer getCurrentCorpId() {
//		return getCurrentSysUser().getCorpId();
//	}
	
	
}
