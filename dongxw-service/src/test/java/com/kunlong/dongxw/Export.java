package com.kunlong.dongxw;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
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
            export(servletRequest, response, workbook, "l:/test.xlsx");
        } catch (Exception e) {
            logger.error("f=" + e.getMessage());
        }
    }

    /**
     * export导出请求头设置
     * 防止乱码
     *
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

    void exportCost() throws Exception {
        TemplateExportParams exportParams = new TemplateExportParams("templates/bom_product.xlsx");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("customerName", "customerName");
        map.put("code", "code");
        map.put("size", "size");
        map.put("remark", "remark");

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

    public static void analysis(InputStream is) throws IOException {
        XSSFWorkbook sheets = new XSSFWorkbook(is);

    }

    static XSSFWorkbook readSheet(String fileName) throws IOException {
        FileInputStream fis = new FileInputStream(fileName);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        fis.close();
        return workbook;
    }

    public static XSSFWorkbook mergeHSSFWorkbooks(XSSFWorkbook[] workbooks) {
        if (workbooks == null || workbooks.length == 0) {
            return null;
        } else if (workbooks.length == 1) {
            return workbooks[0];
        }
        XSSFWorkbook wbFirst = workbooks[0];
        XSSFSheet toSheet = wbFirst.getSheetAt(0);
        for (int i = 1; i < workbooks.length; i++) {
            XSSFWorkbook wb = workbooks[i];
            XSSFSheet fromsheet = wb.getSheetAt(0);
            copyRows(wbFirst, wb,
                    fromsheet, toSheet,

                    fromsheet.getFirstRowNum(),
                    fromsheet.getLastRowNum(),
                    toSheet.getLastRowNum());
        }
        return wbFirst;
    }


    /**
     * @param destWorkBook   目标workbook
     * @param sourceWorkBook 源workbook
     * @param sourceSheet    源sheet
     * @param targetSheet    目sheet
     * @param pStartRow      起始读取行
     * @param pEndRow        结束读取行
     * @param pPosition      目标保存
     */
    public static void copyRows(XSSFWorkbook destWorkBook,
                                XSSFWorkbook sourceWorkBook,
                                XSSFSheet sourceSheet,
                                XSSFSheet targetSheet, int pStartRow, int pEndRow, int pPosition) {
        XSSFRow sourceRow = null;
        XSSFRow targetRow = null;
        XSSFCell sourceCell = null;
        XSSFCell targetCell = null;
        int cType;
        int i;
        int j;
        int targetRowFrom;
        int targetRowTo;

        if ((pStartRow == -1) || (pEndRow == -1)) {
            return;
        }

        List<CellRangeAddress> oldRanges = new ArrayList<CellRangeAddress>();
        for (i = 0; i < sourceSheet.getNumMergedRegions(); i++) {
            oldRanges.add(sourceSheet.getMergedRegion(i));
        }

        // 拷贝合并的单元格。原理：复制当前合并单元格后，原位置的格式会移动到新位置，需在原位置生成旧格式
        for (int k = 0; k < oldRanges.size(); k++) {
            CellRangeAddress oldRange = oldRanges.get(k);
            CellRangeAddress newRange = new CellRangeAddress(
                    oldRange.getFirstRow(), oldRange.getLastRow(),
                    oldRange.getFirstColumn(), oldRange.getLastColumn());
            if (oldRange.getFirstRow() >= pStartRow
                    && oldRange.getLastRow() <= pEndRow) {
                targetRowFrom = oldRange.getFirstRow() - pStartRow + pPosition;
                targetRowTo = oldRange.getLastRow() - pStartRow + pPosition;
                oldRange.setFirstRow(targetRowFrom + sourceSheet.getLastRowNum() + 1);
                oldRange.setLastRow(targetRowTo + sourceSheet.getLastRowNum() + 1);
                newRange.setFirstRow(targetSheet.getLastRowNum() + 1);
                newRange.setLastRow(targetSheet.getLastRowNum() + sourceSheet.getLastRowNum() + 1);

            }
        }
        // 设置列宽
        for (i = pStartRow; i <= pEndRow; i++) {
            sourceRow = sourceSheet.getRow(i);
            if (sourceRow != null) {
                for (j = sourceRow.getLastCellNum(); j > sourceRow.getFirstCellNum(); j--) {
                    targetSheet.setColumnWidth(j, sourceSheet.getColumnWidth(j));
                    targetSheet.setColumnHidden(j, false);
                }
                break;
            }
        }
        // 拷贝行并填充数据
        for (; i <= pEndRow; i++) {
            sourceRow = sourceSheet.getRow(i);
            if (sourceRow == null) {
                continue;
            }
            targetRow = targetSheet.createRow(i - pStartRow + pPosition);
            targetRow.setHeight(sourceRow.getHeight());
            for (j = sourceRow.getFirstCellNum(); j <= sourceRow.getPhysicalNumberOfCells(); j++) {
                sourceCell = sourceRow.getCell(j);
                if (sourceCell == null) {
                    continue;
                }
                targetCell = targetRow.createCell(j);

                //样式的设置
                XSSFCellStyle cStyle = destWorkBook.createCellStyle();
                cStyle.cloneStyleFrom(sourceCell.getCellStyle());
                targetCell.setCellStyle(cStyle);

                cType = sourceCell.getCellType();
                targetCell.setCellType(cType);
                switch (cType) {
                    case HSSFCell.CELL_TYPE_BOOLEAN:
                        targetCell.setCellValue(sourceCell.getBooleanCellValue());
                        // System.out.println("--------TYPE_BOOLEAN:" + targetCell.getBooleanCellValue());
                        break;
                    case HSSFCell.CELL_TYPE_ERROR:
                        targetCell.setCellErrorValue(sourceCell.getErrorCellValue());
                        // System.out.println("--------TYPE_ERROR:" + targetCell.getErrorCellValue());
                        break;
                    case HSSFCell.CELL_TYPE_FORMULA:
                        // parseFormula这个函数的用途在后面说明
                        targetCell.setCellFormula(parseFormula(sourceCell.getCellFormula()));
                        // System.out.println("--------TYPE_FORMULA:" + targetCell.getCellFormula());
                        break;
                    case HSSFCell.CELL_TYPE_NUMERIC:
                        targetCell.setCellValue(sourceCell.getNumericCellValue());
                        // System.out.println("--------TYPE_NUMERIC:" + targetCell.getNumericCellValue());
                        break;
                    case HSSFCell.CELL_TYPE_STRING:
                        targetCell.setCellValue(sourceCell.getRichStringCellValue());
                        // System.out.println("--------TYPE_STRING:" + i + targetCell.getRichStringCellValue());
                        break;
                }
            }
        }
    }

    /**
     * 处理公式
     *
     * @param pPOIFormula
     * @return
     */
    private static String parseFormula(String pPOIFormula) {
        final String cstReplaceString = "ATTR(semiVolatile)"; //$NON-NLS-1$
        StringBuffer result = null;
        int index;
        result = new StringBuffer();
        index = pPOIFormula.indexOf(cstReplaceString);
        if (index >= 0) {
            result.append(pPOIFormula.substring(0, index));
            result.append(pPOIFormula.substring(index + cstReplaceString.length()));
        } else {
            result.append(pPOIFormula);
        }
        return result.toString();
    }

    /**
     * 拷贝Excel行
     *
     * @param fromsheet
     * @param newsheet
     * @param firstrow
     * @param lastrow
     */
    @SuppressWarnings("deprecation")
    public static void copyRows(XSSFSheet fromsheet, XSSFSheet newsheet) {
        int firstrow = fromsheet.getFirstRowNum();
        int lastrow = fromsheet.getLastRowNum();

        if ((firstrow == -1) || (lastrow == -1) || lastrow < firstrow) {
            return;
        }
        // 拷贝合并的单元格

        for (int i = 0; i < fromsheet.getNumMergedRegions(); i++) {
            CellRangeAddress mergedRegion = fromsheet.getMergedRegion(i);
           mergedRegion.setFirstRow(i +newsheet.getLastRowNum()+1);
           mergedRegion.setLastRow(i  +newsheet.getLastRowNum()+1);

            newsheet.addMergedRegion(mergedRegion);
        }
        XSSFRow fromRow = null;
        XSSFRow newRow = null;
        XSSFCell newCell = null;
        XSSFCell fromCell = null;
        // 设置列宽
        for (int i = firstrow; i <= lastrow; i++) {
            fromRow = fromsheet.getRow(i);
            if (fromRow != null) {
                for (int j = fromRow.getLastCellNum(); j >= fromRow.getFirstCellNum(); j--) {
                    int colnum = fromsheet.getColumnWidth((short) j);
                    if (colnum > 100) {
                        newsheet.setColumnWidth((short) j, (short) colnum);
                    }
                    if (colnum == 0) {
                        newsheet.setColumnHidden((short) j, true);
                    } else {
                        newsheet.setColumnHidden((short) j, false);
                    }
                }
                break;
            }
        }
        // 拷贝行并填充数据
        for (int i = 0; i <= lastrow; i++) {
            fromRow = fromsheet.getRow(i);
            if (fromRow == null) {
                continue;
            }
            newRow = newsheet.createRow(newsheet.getLastRowNum()+1+i - firstrow);
            newRow.setHeight(fromRow.getHeight());
            for (int j = fromRow.getFirstCellNum(); j < fromRow.getPhysicalNumberOfCells(); j++) {
                fromCell = fromRow.getCell((short) j);
                if (fromCell == null) {
                    continue;
                }
                newCell = newRow.createCell((short) j);
                XSSFCellStyle cellStyle = fromCell.getCellStyle();

//                HSSFCellStyle newStyle = newsheet.getWorkbook().createCellStyle();
//                newStyle.cloneStyleFrom(cellStyle);
//                newCell.setCellStyle(newStyle);

//                HSSFCellStyle cellStyle2 = newCell.getCellStyle();
//                cellStyle2.setFillForegroundColor(cellStyle.getFillForegroundColor());
//                cellStyle2.setFillPattern(cellStyle.getFillPattern());
//                cellStyle2.setAlignment(cellStyle.getAlignment());
//                cellStyle2.setVerticalAlignment(cellStyle.getVerticalAlignment());

                int cType = fromCell.getCellType();
                newCell.setCellType(cType);
                switch (cType) {
                    case XSSFCell.CELL_TYPE_STRING:
                        newCell.setCellValue(fromCell.getRichStringCellValue());
                        break;
                    case XSSFCell.CELL_TYPE_NUMERIC:
                        newCell.setCellValue(fromCell.getNumericCellValue());
                        break;
                    case XSSFCell.CELL_TYPE_FORMULA:
                        newCell.setCellFormula(fromCell.getCellFormula());
                        break;
                    case XSSFCell.CELL_TYPE_BOOLEAN:
                        newCell.setCellValue(fromCell.getBooleanCellValue());
                        break;
                    case XSSFCell.CELL_TYPE_ERROR:
                        newCell.setCellValue(fromCell.getErrorCellValue());
                        break;
                    default:
                        newCell.setCellValue(fromCell.getRichStringCellValue());
                        break;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        XSSFWorkbook[] workbooks = new XSSFWorkbook[2];

        workbooks[0] = readSheet("l:/a0.xlsx");
        workbooks[1] = readSheet("l:/a1.xlsx");
        FileOutputStream fos = new FileOutputStream("l:/a02.xlsx");
        System.out.println(workbooks[0].getSheetAt(0).getFirstRowNum());
        System.out.println(workbooks[0].getSheetAt(0).getLastRowNum());
        System.out.println(workbooks[1].getSheetAt(0).getFirstRowNum());
        System.out.println(workbooks[1].getSheetAt(0).getLastRowNum());
        ///copyRows(workbooks[1].getSheetAt(0), workbooks[0].getSheetAt(0));

        XSSFWorkbook workbook = mergeHSSFWorkbooks(workbooks);
        workbook.write(fos);
        fos.close();
        workbook.close();

    }
}