package com.kunlong.dongxw.data.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@ContentRowHeight(22)
@HeadRowHeight(25)
@ColumnWidth(10)
public class BomCostExcelModel implements Serializable {
    private static final long serialVersionUID = 1L;


    @ExcelProperty(value = { "费用项"})
    @ColumnWidth(10)
    private String item;

    @ExcelProperty(value = { " "})
    @ColumnWidth(10)
    private String item1;

    @ExcelProperty(value = { " "})
    @ColumnWidth(10)
    private String item2;

    @ExcelProperty(value = { "费用"})
    @ColumnWidth(20)
    private BigDecimal value;


}
