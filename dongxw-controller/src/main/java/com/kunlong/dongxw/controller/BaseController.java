package com.kunlong.dongxw.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.kunlong.dongxw.util.EasyPOIUtil;
import com.kunlong.dongxw.util.SimpleSequenceGenerator;
import com.kunlong.dubbo.sys.model.SysUserDTO;
import com.kunlong.dubbo.sys.service.SysUserApiService;
import com.kunlong.dubbo.api.service.AuthApiService;
import com.kunlong.dubbo.api.service.MailApiService;
import com.kunlong.dongxw.context.CurrentRequestContext;
import com.kunlong.platform.consts.RequestContextConst;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

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
