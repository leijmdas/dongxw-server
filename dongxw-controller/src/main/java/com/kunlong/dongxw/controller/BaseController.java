package com.kunlong.dongxw.controller;

import com.kunlong.dubbo.sys.model.SysUserDTO;
import com.kunlong.dubbo.sys.service.SysUserApiService;
import com.kunlong.dubbo.api.service.AuthApiService;
import com.kunlong.dubbo.api.service.MailApiService;
import com.kunlong.dongxw.context.CurrentRequestContext;
import com.kunlong.platform.consts.RequestContextConst;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

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

	String transDatetime(Date d) {
		if(d==null){
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(d);
	}

	String transDate(Date d) {
		if(d==null){
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(d);
	}



}
