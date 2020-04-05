package com.kunlong.dongxw.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kunlong.dongxw.util.EasyPOIUtil;
import com.kunlong.dubbo.api.service.FileApiService;
import com.kunlong.dubbo.sys.model.SysUserDTO;
import com.kunlong.dubbo.sys.service.SysUserApiService;
import com.kunlong.dubbo.api.service.AuthApiService;
import com.kunlong.dubbo.api.service.MailApiService;
import com.kunlong.dongxw.context.CurrentRequestContext;
import com.kunlong.platform.consts.RequestContextConst;
import com.kunlong.platform.utils.KunlongUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class BaseController {
	public static String group_NAME1="group1";

	byte[] download(String path){
		String[] paths = getFastDfsFileNames( path );
		String group = paths[0];
		String remoteFileName = paths[1];
		//String specFileName = remoteFileName.substring(remoteFileName.lastIndexOf("/") + 1);

		byte[] img = fileApiService.download(group, remoteFileName);
		return img;
	}

	String[] getFastDfsFileNames(String path) {
		String substr = path.substring(path.indexOf("group"));
		String group = substr.split("/")[0];
		String remoteFileName = substr.substring(substr.indexOf("/") + 1);
		return new String[] {group,remoteFileName};
	}

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	@Reference(lazy = true, version = "${dubbo.service.version}")
	protected FileApiService fileApiService;

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

	private String transDatetime(Date d) {
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

	public <T> T buildQueryLikeValue(T obj, Class<T> cls) {
		JSONObject jsonObject = JSONObject.parseObject(KunlongUtils.toJSONString(obj));
		for (String key : jsonObject.keySet()) {
			if (jsonObject.get(key) != null) {
				if (jsonObject.get(key) instanceof String) {
					jsonObject.put(key, "%" + jsonObject.get(key).toString() + "%");
				}
			}
		}
		return JSON.toJavaObject(jsonObject, cls);

	}

	protected String makeExcelSheet(String templateName,String fileName, String sheetName, Map<String, Object> map)
			throws IOException {
		return EasyPOIUtil.makeExcelSheet(templateName,fileName,sheetName,map);
//		TemplateExportParams exportParams = new TemplateExportParams("templates/"+templateName);
//		Workbook workbook = ExcelExportUtil.exportExcel(exportParams, map);
//		workbook.setSheetName(0, sheetName);
//		String fileNameNew = SimpleSequenceGenerator.generate(sheetName) + fileName;
//		File f = new File(fileNameNew);
//		if (!f.exists()) {
//			f.createNewFile();
//		}
//		FileOutputStream fos = new FileOutputStream(f);
//		try {
//			workbook.write(fos);
//		} finally {
//			fos.flush();
//			fos.close();
//		}
//		return fileNameNew;
	}

}
