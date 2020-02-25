package com.kunlong.dongxw.data.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ContentRowHeight(12)
@ColumnWidth(10)
public class BomCostExcelModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @ExcelProperty(value = {" "}, index = 0)
    @ColumnWidth(2)
    private String item0;

    @ExcelProperty(value = {"费用项"}, index = 14)
    @ColumnWidth(8)
    private String item;

    @ExcelProperty(value = {" "}, index = 15)
    @ColumnWidth(5)
    private String item115;

    @ExcelProperty(value = {" "}, index = 16)
    @ColumnWidth(7)
    private String item116;

    @ExcelProperty(value = {"费用"}, index = 17)
    @ColumnWidth(8)
    private BigDecimal value;


}
