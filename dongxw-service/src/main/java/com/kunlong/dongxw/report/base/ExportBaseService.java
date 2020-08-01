package com.kunlong.dongxw.report.base;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class ExportBaseService {
    public void setExcelHeader(HttpServletResponse response,String fileName) throws UnsupportedEncodingException {
        //fileName = URLEncoder.encode(fileName, "UTF-8");
        response.setHeader("file",URLEncoder.encode(  fileName,"UTF-8"));

        response.setHeader("content-disposition", "attachment;  filename=" + new String(fileName.getBytes("utf-8"), "ISO8859-1"));
        response.setHeader("attachment-name", URLEncoder.encode(fileName, "utf-8"));
        response.setHeader("content-Type", "application/vnd.ms-excel");
        response.setContentType("application/msexcel");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
    }

}
