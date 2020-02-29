package com.kunlong.dongxw.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.TableStyle;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.WriteTable;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy; ;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.xmlbeans.impl.common.IOUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author 言曌
 * @date 2020-01-02 11:21
 */

@Service
public class EasyExcelUtil {
    protected final static Logger logger = LoggerFactory.getLogger(EasyExcelUtil.class);

    public static void writeExcel2Response(String fileName, HttpServletResponse response, String outFile) throws Exception {
        setExcelHeader(response, fileName);
        BufferedOutputStream bufferedOutPut = new BufferedOutputStream(response.getOutputStream());

        IOUtil.copyCompletely(new FileInputStream(outFile), bufferedOutPut);
        bufferedOutPut.flush();
        bufferedOutPut.close();
        response.getOutputStream().flush();
        response.getOutputStream().close();
    }

    public static String writeBomExcels2File(String fileName, String sheetName,
                                             Map<String, List> mapSheetData) throws Exception {
        if (mapSheetData.keySet().size() == 0) {
            //error(response, "无数据");
            return "nofile";
        }
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        WriteFont writeFont = new WriteFont();
        writeFont.setBold(true);
        writeFont.setFontHeightInPoints(Short.valueOf("9"));
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
        contentWriteCellStyle.setBorderTop(BorderStyle.HAIR);
        contentWriteCellStyle.setBorderBottom(BorderStyle.HAIR);
        contentWriteCellStyle.setBorderLeft(BorderStyle.HAIR);
        contentWriteCellStyle.setBorderRight(BorderStyle.HAIR);
        WriteFont cWriteFont = new WriteFont();
        cWriteFont.setBold(false);
        //cWriteFont.setColor(IndexedColors.DARK_RED.index);
        cWriteFont.setFontHeightInPoints(Short.valueOf("8"));
        cWriteFont.setFontName("宋体");
        contentWriteCellStyle.setWrapped(true);
        contentWriteCellStyle.setWriteFont(cWriteFont);
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);
//        ExcelWriterBuilder writerBuilder = EasyExcel.write(getOutputStream(fileName, response))
//                .excelType(ExcelTypeEnum.XLSX).registerWriteHandler(horizontalCellStyleStrategy);

        String fileNameNew = SimpleSequenceGenerator.generate("BOMLIST") + fileName;
        File f = new File(fileNameNew);
        if (!f.exists()) {
            f.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(f);
        ExcelWriter excelWriter = EasyExcel.write(fos)
                .excelType(ExcelTypeEnum.XLSX).registerWriteHandler(horizontalCellStyleStrategy).build();
        int i = 0;
        WriteSheet writeSheet = EasyExcel.writerSheet(sheetName).build();
        writeSheet.setAutoTrim(true);

        for (List value : mapSheetData.values()) {
            //writeSheet = EasyExcel.writerSheet(sheetName).head(cls).build();
            WriteTable writeTable = new WriteTable();
            writeTable.setTableNo(i++);
            Class cls = value.get(0).getClass();
            writeTable.setClazz(cls);
            writeTable.setNeedHead(i == 1);
            WriteFont tableFont = new WriteFont();
            tableFont.setBold(true);
            tableFont.setFontHeightInPoints(Short.valueOf("10"));
            tableFont.setFontName("宋体");
            TableStyle tableStyle = new TableStyle();
            //tableStyle.setTableContentFont(tableFont);
            if (i == 1) {
                //writeTable.setRelativeHeadRowIndex(7);
                //writeSheet.setRelativeHeadRowIndex(7);
            } else {
                //writeTable.setRelativeHeadRowIndex(0);
                writeSheet.setRelativeHeadRowIndex(0);
                //writeTable.setTableStyle(tableStyle);
                Collection<Integer> collection = new ArrayList<>();
                ((ArrayList<Integer>) collection).add(14);
                ((ArrayList<Integer>) collection).add(15);
                ((ArrayList<Integer>) collection).add(16);
                ((ArrayList<Integer>) collection).add(17);
                writeTable.setIncludeColumnIndexes(collection);
            }
            writeTable.setAutoTrim(true);
            excelWriter.write(value, writeSheet, writeTable);
        }
        excelWriter.finish();
        fos.flush();
        fos.close();
        return fileNameNew;
    }

    public static void writeExcels(HttpServletResponse response,
                                   String fileName, String sheetName,
                                   Map<String, List> mapSheetData) throws Exception {
        if(mapSheetData.keySet().size()==0){
            error(response,"无数据");
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
        headWriteCellStyle.setFillForegroundColor(IndexedColors.LEMON_CHIFFON.getIndex());
        //内容样式
        WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
        //设置内容靠左对齐
        contentWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER_SELECTION);
        contentWriteCellStyle.setBorderTop(BorderStyle.HAIR);
        contentWriteCellStyle.setBorderBottom(BorderStyle.HAIR);
        contentWriteCellStyle.setBorderLeft(BorderStyle.HAIR);
        contentWriteCellStyle.setBorderRight(BorderStyle.HAIR);
        WriteFont cWriteFont = new WriteFont();
        cWriteFont.setBold(false);
        cWriteFont.setFontHeightInPoints(Short.valueOf("8"));
        cWriteFont.setFontName("宋体");
        contentWriteCellStyle.setWrapped(true);
        contentWriteCellStyle.setWriteFont(cWriteFont);
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);
//        ExcelWriterBuilder writerBuilder = EasyExcel.write(getOutputStream(fileName, response))
//                .excelType(ExcelTypeEnum.XLSX).registerWriteHandler(horizontalCellStyleStrategy);
        ExcelWriter excelWriter = EasyExcel.write(getOutputStream(fileName, response))
                .excelType(ExcelTypeEnum.XLSX).registerWriteHandler(horizontalCellStyleStrategy).build();
        int i = 0;
        WriteSheet writeSheet = EasyExcel.writerSheet(sheetName).build();
        writeSheet.setAutoTrim(true);

        for (List value: mapSheetData.values()) {
            //writeSheet = EasyExcel.writerSheet(sheetName).head(cls).build();
            WriteTable writeTable = new WriteTable();
            writeTable.setTableNo(i++);
            Class cls = value.get(0).getClass();
            writeTable.setClazz(cls);
            writeTable.setNeedHead(i==1);
            WriteFont tableFont = new WriteFont();
            tableFont.setBold(true);
            tableFont.setFontHeightInPoints(Short.valueOf("10"));
            tableFont.setFontName("宋体");
            TableStyle tableStyle=new TableStyle() ;
            //tableStyle.setTableContentFont(tableFont);
            if(i==1){
                //writeTable.setRelativeHeadRowIndex(7);
                //writeSheet.setRelativeHeadRowIndex(7);
            }else {
                //writeTable.setRelativeHeadRowIndex(0);
                writeSheet.setRelativeHeadRowIndex(0);
                //writeTable.setTableStyle(tableStyle);
                Collection<Integer> collection=new ArrayList<>();
                ((ArrayList<Integer>) collection).add(14);
                ((ArrayList<Integer>) collection).add(15);
                ((ArrayList<Integer>) collection).add(16);
                ((ArrayList<Integer>) collection).add(17);
                writeTable.setIncludeColumnIndexes(collection);
            }
            writeTable.setAutoTrim(true);
            excelWriter.write(value, writeSheet, writeTable);
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

    public static void error(HttpServletResponse resp,String errInfo) throws IOException {
        setExcelHeader(resp,"nofile.txt");
        resp.getWriter().write(errInfo);
    }

    static void setExcelHeader(HttpServletResponse response, String fileName) throws UnsupportedEncodingException {
        //fileName = URLEncoder.encode(fileName, "UTF-8");
        response.setHeader("content-disposition", "attachment;  filename=" + new String(fileName.getBytes("utf-8"), "ISO8859-1"));
        response.setHeader("attachment-name", URLEncoder.encode(fileName, "UTF-8"));
        response.setHeader("content-Type", "application/vnd.ms-excel");
        response.setContentType("application/msexcel");
        response.setCharacterEncoding("UTF-8");
        //response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

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