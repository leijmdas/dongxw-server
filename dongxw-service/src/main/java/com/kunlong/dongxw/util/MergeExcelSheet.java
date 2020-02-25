package com.kunlong.dongxw.util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

public class MergeExcelSheet {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 传递 源workbook， 和 源文件名fileName
     *
     * @param sourceWorkBook 源workbook 用来获取excel数据
     * @param fileName       源文件名称，用来获取数据库中的sheet页信息
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */

    public Workbook mergeExcelBySheetMessage(Workbook sourceWorkBook) throws IllegalAccessException, InstantiationException {

        // 创建和目标workbook相同类型的workbook
        Workbook targetWorkBook = sourceWorkBook.getClass().newInstance();
        // 创建目标sheet
        Sheet targetSheet = targetWorkBook.createSheet(sourceWorkBook.getSheetName(1));

        // 取出所有的需要合并的sheet页合集
        //List<SheetMessage> needMergeSheetList = sheetMessageMapper.selectByFileName(fileName);

        // 当不需要合并的时候，直接返回源workbook

        // 将合并完之后的sourceWorkbook合并到targetWorkbook中
        for (Sheet sourceSheet:sourceWorkBook) {


            // 与上一个合并的sheet之间的间隔
            Integer lastSheetInterval = 0;//sheetMessage.getLastSheetInterval();
            if (lastSheetInterval > 0) {
                targetSheet.createRow(targetSheet.getLastRowNum() + lastSheetInterval);
            }

            // 源sheet合并需要合并的子项
            //mergeChildSheetMessage(sheetName, sourceWorkBook, sheetNameList);

            moveSourceSheetIntoTargetSheet(targetWorkBook, sourceSheet, targetSheet, 0);

        }

        return targetWorkBook;
    }



    /**
     * 源excel中sheet页合并需要合并的子sheet
     *
     * @param parentSheetName 需要合并的sheet页名称
     * @param sourceWorkBook  源excel
     * @param sheetNameList   已经合并过的sheet名称的list集合，用来防止重复合并
     */
    private void mergeChildSheetMessage(String parentSheetName, Workbook sourceWorkBook, List<String> sheetNameList) {

        if (sheetNameList.contains(parentSheetName)) {
            return;
        }


        // 合并
        Sheet targetSheet = sourceWorkBook.getSheet(parentSheetName);
        String[] s1=new String[]{"Ss"};
        for (String childSheetMessage :s1 ) {

            String sheetName = "ddd";//childSheetMessage.getSheetName();
            Integer titleLength = 12;//childSheetMessage.getTitleLength();

            // 递归合并子项的子项sheet
            mergeChildSheetMessage(sheetName, sourceWorkBook, sheetNameList);

            Sheet sourceSheet = sourceWorkBook.getSheet(sheetName);

            // 合并sheet页
            moveSourceSheetIntoTargetSheet(sourceWorkBook, sourceSheet, targetSheet, titleLength);

        }

        // 记录已经合并了的sheet页名称
        sheetNameList.add(parentSheetName);

    }



    /**
     * sheet页合并
     *
     * @param targetWorkBook    目标workbook，该对象主要用来创建单元格格式
     * @param sourceSheet       源sheet
     * @param targetSheet       目标sheet
     * @param removeTitleLength 源sheet页合并到目标sheet中需要去掉的表头长度，如果不去掉传递0
     */
    private static void moveSourceSheetIntoTargetSheet(Workbook targetWorkBook, Sheet sourceSheet, Sheet targetSheet, int removeTitleLength) {

        if (sourceSheet == null) {
            return;
        }

        // 获取目标sheet最后一行的下一行
        int targetRowNums = targetSheet.getLastRowNum();
        int physicalNumberOfRows = targetSheet.getPhysicalNumberOfRows();
        targetRowNums = physicalNumberOfRows == 0 ? 0 : targetRowNums + 1;

        // 移动 源sheet页中的 合并单元格区域 到目标sheet页中
        moveSourceSheetAllMergedRegionToTargetSheet(sourceSheet, targetSheet, targetRowNums, removeTitleLength);

        int sourceRowNums = sourceSheet.getLastRowNum();
        for (int i = removeTitleLength; i <= sourceRowNums; i++) {

            Row targetRow = targetSheet.createRow(targetRowNums++);
            Row sourceRow = sourceSheet.getRow(i);

            // 复制行
            copySourceRowToTargetRow(targetWorkBook, sourceRow, targetRow);
        }

    }


    /**
     * 合并sheet页中，处理源sheet页中可能存在的 合并单元格部分；
     * 当源sheet页在合并单元格的时候可能去掉表头，所以也需去掉表头的合并单元格部分
     *
     * @param sourceSheet       源sheet
     * @param targetSheet       目标sheet
     * @param targetRowNums     目标sheet的最后一行（源合并单元格的位置，需要变化到目标单元格区域，需要提供一个位置角标）
     * @param removeTitleLength 需要移除的表头长度
     */
    private static void moveSourceSheetAllMergedRegionToTargetSheet
    (Sheet sourceSheet, Sheet targetSheet, int targetRowNums, int removeTitleLength) {

        int numMergedRegions = sourceSheet.getNumMergedRegions();
        for (int i = 0; i < numMergedRegions; i++) {

            CellRangeAddress mergedRegion = sourceSheet.getMergedRegion(i);

            int firstRow = mergedRegion.getFirstRow();

            // 去掉表头的 单元格合并
            if (firstRow < removeTitleLength) {
                continue;
            }

            int lastRow = mergedRegion.getLastRow();
            int firstColumn = mergedRegion.getFirstColumn();
            int lastColumn = mergedRegion.getLastColumn();

            // 合并单元格的行需要跟随当前单元格的行数下移
            firstRow = firstRow + targetRowNums;
            lastRow = lastRow + targetRowNums;

            CellRangeAddress cellRangeAddress = new CellRangeAddress(firstRow, lastRow, firstColumn, lastColumn);
            targetSheet.addMergedRegion(cellRangeAddress);
        }

    }


    /**
     * 将源行复制到目标行
     *
     * @param targetWorkBook 目标workbook，主要用来创建单元格样式
     * @param sourceRow      源行
     * @param targetRow      目标行
     */
    private static void copySourceRowToTargetRow(Workbook targetWorkBook, Row sourceRow, Row targetRow) {

        if (sourceRow == null) {
            return;
        }

        // 行高
        targetRow.setHeight(sourceRow.getHeight());

        int sourceCellNums = sourceRow.getLastCellNum();
        for (int i = 0; i < sourceCellNums; i++) {

            Cell targetCell = targetRow.createCell(i);
            Cell sourceCell = sourceRow.getCell(i);

            // 复制单元格
            copySourceCellToTargetCell(targetWorkBook, targetCell, sourceCell);
        }

    }

    /**
     * 移动单元格
     *
     * @param targetWorkBook 目标workbook，用来在本方法中创建单元格样式
     * @param targetCell     目标单元格
     * @param sourceCell     源单元格
     */
    private static void copySourceCellToTargetCell(Workbook targetWorkBook, Cell targetCell, Cell sourceCell) {

        if (sourceCell == null) {
            return;
        }

        // 将源单元格的格式 赋值到 目标单元格中
        CellStyle sourceCellStyle = sourceCell.getCellStyle();
        /*
            此处由于是新建了workbook对象，只能新建 CellStyle对象，然后clone，再赋值；
            直接赋值 源CellStyle对象 会报不是同源异常
        */
        CellStyle targetCellStyle = targetWorkBook.createCellStyle();
        targetCellStyle.cloneStyleFrom(sourceCellStyle);
        targetCell.setCellStyle(targetCellStyle);

        CellType cellTypeEnum = sourceCell.getCellTypeEnum();
        switch (cellTypeEnum) {
            case STRING:
                targetCell.setCellValue(sourceCell.getStringCellValue());
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(sourceCell)) {
                    // 日期格式的值
                    targetCell.setCellValue(sourceCell.getDateCellValue());
                } else {
                    targetCell.setCellValue(sourceCell.getNumericCellValue());
                }
                break;
            case BOOLEAN:
                targetCell.setCellValue(sourceCell.getBooleanCellValue());
                break;
            case FORMULA:
                // ***为公式的情况下获取的是单元格的数值
                targetCell.setCellValue(sourceCell.getNumericCellValue());
                break;
            case BLANK:
                break;
            case ERROR:
                targetCell.setCellValue(sourceCell.getErrorCellValue());
                break;
            case _NONE:
                break;
            default:

        }
    }

    public Workbook mergeExcelBySheetMessage(Workbook[] sourceWorkBooks) throws IllegalAccessException, InstantiationException {
        int i = 0;
        Workbook targetWorkBook = null;
        Sheet targetSheet = null;
        // 创建和目标workbook相同类型的workbook
        for (Workbook workbook : sourceWorkBooks) {
            if (i++ == 0) {
                targetWorkBook = workbook.getClass().newInstance();
                // 创建目标sheet
                targetSheet = targetWorkBook.createSheet(workbook.getSheetName(0));

            }
            for (Sheet sourceSheet : workbook) {
                // 与上一个合并的sheet之间的间隔
                Integer lastSheetInterval = 0;//sheetMessage.getLastSheetInterval();
                if (lastSheetInterval > 0) {
                    targetSheet.createRow(targetSheet.getLastRowNum() + lastSheetInterval);
                } else {
                    for (int ii = 0; ii <= sourceSheet.getRow(sourceSheet.getFirstRowNum()).getLastCellNum(); ii++) {
                        targetSheet.setColumnWidth(ii, sourceSheet.getColumnWidth(ii));
                    }
                }

                // 源sheet合并需要合并的子项
                //mergeChildSheetMessage(sheetName, sourceWorkBook, sheetNameList);
                moveSourceSheetIntoTargetSheet(targetWorkBook, sourceSheet, targetSheet, 0);

            }
        }
        return targetWorkBook;
    }

    public String mergeSheets(String inFileHead, String bomFile, String outFile) throws Exception {

        //InputStream tin = new FileInputStream("l:/template/bom_template.xlsx");
        InputStream tin = new FileInputStream(inFileHead);
        XSSFWorkbook fromExcel = new XSSFWorkbook(tin);
        //InputStream bomin = new FileInputStream("l:/template/bom_list.xlsx");
        InputStream bomin = new FileInputStream(bomFile);
        XSSFWorkbook fromExcel1 = new XSSFWorkbook(bomin);
        tin.close();
        bomin.close();
        //Workbook workbook = new MergeSheet().mergeExcelBySheetMessage(fromExcel);
        Workbook[] workbooks=new Workbook[]{fromExcel,fromExcel1};
        Workbook workbook = mergeExcelBySheetMessage(workbooks);


        // FileOutputStream fileOut = new FileOutputStream("l:/template/bom_rpt.xlsx");
        String fileNameNew = SimpleSequenceGenerator.generate("BOM_GEN") + outFile;
        File f = new File(fileNameNew);
        if (!f.exists()) {
            f.createNewFile();
        }
        FileOutputStream fileOut = new FileOutputStream(f);
        workbook.write(fileOut);
        fileOut.flush();
        fileOut.close();
        System.out.println("复制成功 "+outFile);
        logger.info("复制成功: genFile: {}",outFile);
        return fileNameNew;
    }

    public static void main(String[] args) throws Exception {
        new MergeExcelSheet().mergeSheets("","","复制成功l:/templae/bom_rpt.xls");
    }
}