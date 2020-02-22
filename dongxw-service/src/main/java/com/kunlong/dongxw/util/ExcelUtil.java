package com.kunlong.dongxw.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * @author 言曌
 * @date 2020-01-02 11:21
 */

@Service
public class ExcelUtil {

    public static void writeExcels(HttpServletResponse response,
                                   String fileName, String sheetName,
                                   Map<String, List> mapSheetData) throws Exception {
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        WriteFont writeFont = new WriteFont();
        writeFont.setBold(true);
        writeFont.setFontHeightInPoints(Short.valueOf("11"));
        writeFont.setFontName("宋体");
        headWriteCellStyle.setWriteFont(writeFont);
        headWriteCellStyle.setBorderTop(BorderStyle.THIN);
        headWriteCellStyle.setBorderBottom(BorderStyle.THIN);
        headWriteCellStyle.setBorderLeft(BorderStyle.THIN);
        headWriteCellStyle.setBorderRight(BorderStyle.THIN);
        headWriteCellStyle.setWrapped(true);
        //设置表头居中对齐
        headWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);
        //headWriteCellStyle.setFillBackgroundColor(IndexedColors.WHITE.getIndex());
        headWriteCellStyle.setFillForegroundColor(IndexedColors.LEMON_CHIFFON.getIndex());
        //内容样式
        WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
        //设置内容靠左对齐
        contentWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER_SELECTION);
        contentWriteCellStyle.setBorderTop(BorderStyle.THIN);
        contentWriteCellStyle.setBorderBottom(BorderStyle.THIN);
        contentWriteCellStyle.setBorderLeft(BorderStyle.THIN);
        contentWriteCellStyle.setBorderRight(BorderStyle.THIN);
        WriteFont cWriteFont = new WriteFont();
        cWriteFont.setBold(false);
        cWriteFont.setFontHeightInPoints(Short.valueOf("10"));
        cWriteFont.setFontName("宋体");
        contentWriteCellStyle.setWrapped(true);
        contentWriteCellStyle.setWriteFont(cWriteFont);
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);
//        ExcelWriterBuilder writerBuilder = EasyExcel.write(getOutputStream(fileName, response))
//                .excelType(ExcelTypeEnum.XLSX).registerWriteHandler(horizontalCellStyleStrategy);
        ExcelWriter excelWriter = EasyExcel.write(getOutputStream(fileName, response))
                .excelType(ExcelTypeEnum.XLSX).registerWriteHandler(horizontalCellStyleStrategy).build();
        int i = 0;
        Class cls = null;
        for (String key : mapSheetData.keySet()) {
            if (cls == null) {
                cls = mapSheetData.get(key).get(0).getClass();
            }
            WriteSheet writeSheet = EasyExcel.writerSheet(sheetName).head(cls).build();
            excelWriter.write(mapSheetData.get(key), writeSheet);
        }
        excelWriter.finish();
    }


    /**
     * 导出
     *
     * @param response
         * @param data
         * @param fileName
         * @param sheetName
         * @param
         * @throws Exception
         */
    public static void writeExcel(HttpServletResponse response, String fileName, String sheetName, List data) throws Exception {
        //表头样式
        if (data.size() == 0) {
            return;
        }

        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        WriteFont writeFont = new WriteFont();
        writeFont.setBold(true);
        writeFont.setFontHeightInPoints(Short.valueOf("10"));
        writeFont.setFontName("宋体");
        headWriteCellStyle.setWriteFont(writeFont);
        headWriteCellStyle.setBorderTop(BorderStyle.THIN);
        headWriteCellStyle.setBorderBottom(BorderStyle.THIN);
        headWriteCellStyle.setBorderLeft(BorderStyle.THIN);
        headWriteCellStyle.setBorderRight(BorderStyle.THIN);
        headWriteCellStyle.setWrapped(true);
        //设置表头居中对齐
        headWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);
        //headWriteCellStyle.setFillBackgroundColor(IndexedColors.WHITE.getIndex());
        headWriteCellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        //内容样式
        WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
        //设置内容靠左对齐
        contentWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER_SELECTION);
        contentWriteCellStyle.setBorderTop(BorderStyle.THIN);
        contentWriteCellStyle.setBorderBottom(BorderStyle.THIN);
        contentWriteCellStyle.setBorderLeft(BorderStyle.THIN);
        contentWriteCellStyle.setBorderRight(BorderStyle.THIN);
        WriteFont cWriteFont = new WriteFont();
        cWriteFont.setBold(false);
        cWriteFont.setFontHeightInPoints(Short.valueOf("9"));
        cWriteFont.setFontName("宋体");
        contentWriteCellStyle.setWrapped(true);
        contentWriteCellStyle.setWriteFont(cWriteFont);
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);
        ExcelWriterBuilder writerBuilder=EasyExcel.write(getOutputStream(fileName, response), data.get(0).getClass())
                .excelType(ExcelTypeEnum.XLSX).registerWriteHandler(horizontalCellStyleStrategy);
        writerBuilder.sheet(sheetName).doWrite(data);


        //writerBuilder.sheet(sheetName).doWrite(data);


    }

    static void setExcelHeader(HttpServletResponse response, String fileName) throws UnsupportedEncodingException {
        //fileName = URLEncoder.encode(fileName, "UTF-8");
        response.setHeader("content-disposition", "attachment;  filename=" + new String(fileName.getBytes("utf-8"), "ISO8859-1"));
        response.setHeader("attachment-name", URLEncoder.encode(fileName, "utf-8"));
        response.setHeader("content-Type", "application/vnd.ms-excel");
        response.setContentType("application/msexcel");
    }


    static OutputStream getOutputStream(String fileName, HttpServletResponse response) throws Exception {

        setExcelHeader(response, fileName);
        return response.getOutputStream();
    }
}

//        fileName = URLEncoder.encode(fileName, "UTF-8");
//        response.setContentType("application/vnd.ms-excel");
//        response.setCharacterEncoding("utf8");
//        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");