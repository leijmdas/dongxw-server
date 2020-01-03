package com.kunlong.dongxw.controller;

import com.kunlong.api.service.AuthApiService;
import com.kunlong.dongxw.util.support.CurrentRequestContext;
import com.kunlong.platform.consts.RequestContextConst;
import org.apache.dubbo.config.annotation.Reference;

public class BaseController {
	@Reference(lazy = true, version = "${dubbo.service.version}")
	AuthApiService authApiService;

	public Integer getCurrentUserId() {
		String token = (String) CurrentRequestContext.getContext().getAttribute(RequestContextConst.KEY_SESSIONKEY);

		return 0;//authApiService.getCurrentUserId(token);

	}
//	public Map<Object,Object> getSessionValues(){
//		return SessionHolder.getCurrentSessionValues();
//	}
//
//	private SysUserDTO getCurrentSysUser() {
//		Map<Object,Object> vals = this.getSessionValues();
//		Assert.notNull(vals,"Session不存在或已效");
//		SysUserDTO su = (SysUserDTO)vals.get(SessionKeyEnum.WEB_USER.getKey());
//		Assert.notNull(su,"User Session不存在或已失效");
//		return su;
//	}


	
//	public Integer getCurrentCorpId() {
//		return getCurrentSysUser().getCorpId();
//	}
	
	
}
