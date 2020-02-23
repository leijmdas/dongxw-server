package com.kunlong.dongxw;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zjp
 * @Title: Export
 * @date 2019/8/7
 */
@RestController
public class Export {
    private static final Logger logger = LoggerFactory.getLogger(Export.class);
    /**
     * 下载月度奖金表格
     *
     * @param response
     */
    @RequestMapping(value = "/exportBonus")
    public void exportBonus2(HttpServletRequest servletRequest, HttpServletResponse response) {
        try {
            TemplateExportParams params = new TemplateExportParams("templates/提成表1.xlsx");
            Map<String, Object> map = new HashMap<String, Object>();
            List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();
            map.put("year", "2019");
            map.put("month", "12");
            Workbook workbook = ExcelExportUtil.exportExcel(params, map);
            export(servletRequest, response, workbook,  "l:/test.xlsx");
        } catch (Exception e) {
            logger.error("f=" + e.getMessage());
        }
    }
    /**
     * export导出请求头设置
     * 防止乱码
     * @param response
     * @param workbook
     * @param fileName
     * @throws Exception
     */
    private static void export(HttpServletRequest servletRequest, HttpServletResponse response, Workbook workbook, String fileName) throws Exception {
        response.reset();
        response.setContentType("application/x-msdownload");
        response.setHeader("Content-disposition", "attachment; filename=" + new String(fileName.getBytes("utf-8"), "iso8859-1") + ".xls");
        ServletOutputStream outStream = null;
        try {
            outStream = response.getOutputStream();
            workbook.write(outStream);
        } finally {
            outStream.close();
        }
    }

    public static void main(String[] args) throws Exception {

        TemplateExportParams exportParams = new TemplateExportParams("templates/bom_product.xlsx");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("customerName","customerName");
        map.put("code","code");
        map.put("size","size");
        map.put("remark","remark");

        try (Workbook workbook = ExcelExportUtil.exportExcel(exportParams, map)) {
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream("l:/bom_product.xlsx");
                workbook.write(fos);
            } finally {
                fos.close();
            }
        }

    }
}