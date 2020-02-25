package com.kunlong.dongxw.data.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ContentRowHeight(20)
@HeadRowHeight(12)
@ColumnWidth(11)
public class BomExcelModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @ExcelProperty(value = { "序号"})
    @ColumnWidth(4)
    private String seqNo;

    @ExcelProperty(value = { "物料代码"})
    @ColumnWidth(10)
    private String code;
    @ExcelProperty(value = { "物料名称"})
    @ColumnWidth(20)
    private String name;
    @ExcelProperty(value = { "颜色"})
    @ColumnWidth(8)
    private String color;

    @ExcelProperty(value = { "宽封度"})
    @ColumnWidth(5)
    private String width;

    @ExcelProperty(value = { "裁片名称"})
    @ColumnWidth(12)
    private String cutPartName;

    @ExcelProperty(value = { "尺寸（英寸）","长度"})
    @ColumnWidth(8)
    private BigDecimal sizeL;
    @ExcelProperty(value = { "尺寸（英寸）"," "})
    @ColumnWidth(2)
    private String sizeX;
    @ExcelProperty(value = { "尺寸（英寸）","宽度"})
    @ColumnWidth(8)
    private BigDecimal sizeW;

    @ExcelProperty(value = { "件数"})
    @ColumnWidth(5)
    private Short pieces;
    @ExcelProperty(value = { "刀数"})
    @ColumnWidth(5)
    private String knifeQty;
    @ExcelProperty(value = { "长封度"})
    @ColumnWidth(5)
    private Integer length;


    @ExcelProperty(value = { "损耗"})
    @ColumnWidth(5)
    private String lossRate;

    @ExcelProperty(value = { "每个用量"})
    @ColumnWidth(6)
    private BigDecimal eachQty;

    @ExcelProperty(value = { "用量"})
    @ColumnWidth(8)
    private String qty;


    @ExcelProperty(value = { "单位"})
    @ColumnWidth(5)
    private String unit;

    @ExcelProperty(value = { "单价"})
    @ColumnWidth(7)
    private BigDecimal price;

    @ColumnWidth(8)
    @ExcelProperty(value = { "金额"})
    private BigDecimal money;

}
