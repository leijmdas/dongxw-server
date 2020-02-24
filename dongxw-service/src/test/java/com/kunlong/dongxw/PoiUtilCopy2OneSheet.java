package com.kunlong.dongxw;

import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PoiUtilCopy2OneSheet {
        public class XSSFDateUtil extends DateUtil {

        }

        public static void copyCellStyle(XSSFCellStyle fromStyle, XSSFCellStyle toStyle) {
            toStyle.cloneStyleFrom(fromStyle);//此一行代码搞定
        }

        public static void mergeSheetAllRegion(XSSFSheet fromSheet, XSSFSheet toSheet) {//合并单元格
            int num = fromSheet.getNumMergedRegions();
            CellRangeAddress cellR = null;
            for (int i = 0; i < num; i++) {
                cellR = fromSheet.getMergedRegion(i);
                cellR.setFirstRow(cellR.getFirstRow()+toSheet.getLastRowNum()+1);
                cellR.setLastRow(cellR.getLastRow()+toSheet.getLastRowNum()+1);
                toSheet.addMergedRegion(cellR);
            }
        }

        public static void copyCell(XSSFWorkbook wb, XSSFCell fromCell, XSSFCell toCell) {
            XSSFCellStyle newstyle = wb.createCellStyle();
            copyCellStyle(fromCell.getCellStyle(), newstyle);
            //toCell.setEncoding(fromCell.getEncoding());
            //样式
            //toCell.setCellStyle(newstyle);
            if (fromCell.getCellComment() != null) {
                toCell.setCellComment(fromCell.getCellComment());
            }
            // 不同数据类型处理
            int fromCellType = fromCell.getCellType();
            toCell.setCellType(fromCellType);
            if (fromCellType == XSSFCell.CELL_TYPE_NUMERIC) {
                if (XSSFDateUtil.isCellDateFormatted(fromCell)) {
                    toCell.setCellValue(fromCell.getDateCellValue());
                } else {
                    toCell.setCellValue(fromCell.getNumericCellValue());
                }
            } else if (fromCellType == XSSFCell.CELL_TYPE_STRING) {
                toCell.setCellValue(fromCell.getRichStringCellValue());
            } else if (fromCellType == XSSFCell.CELL_TYPE_BLANK) {
                // nothing21
            } else if (fromCellType == XSSFCell.CELL_TYPE_BOOLEAN) {
                toCell.setCellValue(fromCell.getBooleanCellValue());
            } else if (fromCellType == XSSFCell.CELL_TYPE_ERROR) {
                toCell.setCellErrorValue(fromCell.getErrorCellValue());
            } else if (fromCellType == XSSFCell.CELL_TYPE_FORMULA) {
                toCell.setCellFormula(fromCell.getCellFormula());
            } else { // nothing29
            }

        }

        public static void copyRow(XSSFWorkbook wb, XSSFRow oldRow, XSSFRow toRow) {
            toRow.setHeight(oldRow.getHeight());
            for (Iterator cellIt = oldRow.cellIterator(); cellIt.hasNext(); ) {
                XSSFCell tmpCell = (XSSFCell) cellIt.next();
                XSSFCell newCell = toRow.createCell(tmpCell.getColumnIndex());
                copyCell(wb, tmpCell, newCell);
            }
        }

        public static void copySheet(XSSFWorkbook wb, XSSFSheet  toSheet,XSSFSheet fromSheet  ) {
            mergeSheetAllRegion(fromSheet, toSheet);
            //设置列宽
            for (int i = 0; i <= fromSheet.getRow(fromSheet.getFirstRowNum()).getLastCellNum(); i++) {
                toSheet.setColumnWidth(i, fromSheet.getColumnWidth(i));
            }
            for (Iterator rowIt = fromSheet.rowIterator(); rowIt.hasNext(); ) {
                XSSFRow oldRow = (XSSFRow) rowIt.next();
                XSSFRow newRow = toSheet.createRow(oldRow.getRowNum());
                copyRow(wb, oldRow, newRow);
            }
        }


    public static void main(String[] args) throws Exception {
        List<String> pathList = new ArrayList<String>();
        pathList.add("l:/bom_template.xlsx");
        pathList.add("l:/bom_list.xlsx");
        XSSFWorkbook newExcelCreat = new XSSFWorkbook();


//        for (int i = 0; i < pathList.size(); i++) {//遍历每个源excel文件，fileNameList为源文件的名称集合
////            InputStream in = new FileInputStream(pathList.get(i));
////            XSSFWorkbook fromExcel = new XSSFWorkbook(in);
////            XSSFSheet oldSheet = fromExcel.getSheetAt(0);//模板文件Sheet1
////
////            XSSFSheet newSheet = newExcelCreat.createSheet("Sheet" + (i + 1) + "");
////            copySheet(newExcelCreat, oldSheet, newSheet);
////        }
        //  for (int i = 0; i < pathList.size(); i++) {//遍历每个源excel文件，fileNameList为源文件的名称集合
        InputStream in = new FileInputStream(pathList.get(0));
        XSSFWorkbook fromExcel = new XSSFWorkbook(in);
        XSSFSheet tSheet = fromExcel.getSheetAt(0);//模板文件Sheet1
        InputStream in1 = new FileInputStream(pathList.get(1));
        XSSFWorkbook fromExcel1 = new XSSFWorkbook(in1);
        XSSFSheet inSheet = fromExcel1.getSheetAt(0);//模板文件Sheet1

        //copySheet(newExcelCreat, tosheet, fromSheet);
        //tSheet.getTables().addAll(inSheet.getTables());

        String allFileName = "l:/bom_report.xlsx";

        FileOutputStream fileOut = new FileOutputStream(allFileName);
        fromExcel.write(fileOut);
        fileOut.flush();
        fileOut.close();
        System.out.println("复制成功");

    }

}