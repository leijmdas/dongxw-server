package com.kunlong.dongxw.data.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ContentRowHeight(22)
@ColumnWidth(12)
public class BomCostExcelModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @ExcelProperty(value = {" "}, index = 0)
    @ColumnWidth(2)
    private String item0;


//    @ExcelProperty(value = {" "}, index = 1)
//    @ColumnWidth(10)
//    private String item01;
//    @ExcelProperty(value = {" "}, index = 2)
//    @ColumnWidth(10)
//    private String item2;
//    @ExcelProperty(value = {" "}, index = 3)
//    @ColumnWidth(10)
//    private String item3;
//    @ExcelProperty(value = {" "}, index = 4)
//    @ColumnWidth(10)
//    private String item4;
//    @ExcelProperty(value = {" "}, index = 5)
//    @ColumnWidth(10)
//    private String item5;
//    @ExcelProperty(value = {" "}, index = 6)
//    @ColumnWidth(10)
//    private String item6;
//    @ExcelProperty(value = {" "}, index = 7)
//    @ColumnWidth(10)
//    private String item7;
//    @ExcelProperty(value = {" "}, index = 8)
//    @ColumnWidth(10)
//    private String item8;
//    @ExcelProperty(value = {" "}, index = 9)
//    @ColumnWidth(10)
//    private String item9;
//    @ExcelProperty(value = {" "}, index = 10)
//    @ColumnWidth(10)
//    private String item10;
//
//    @ExcelProperty(value = {" "}, index = 11)
//    @ColumnWidth(10)
//    private String item11;
//    @ExcelProperty(value = {" "}, index = 12)
//    @ColumnWidth(10)
//    private String item12;
//    @ExcelProperty(value = {" "}, index = 13)
//    @ColumnWidth(10)
//    private String item13;


    @ExcelProperty(value = {"费用项"}, index = 14)
    @ColumnWidth(8)
    private String item;

    @ExcelProperty(value = {" "}, index = 15)
    @ColumnWidth(6)
    private String item115;

    @ExcelProperty(value = {" "}, index = 16)
    @ColumnWidth(8)
    private String item116;

    @ExcelProperty(value = {"费用"}, index = 17)
    @ColumnWidth(8)
    private BigDecimal value;


}
