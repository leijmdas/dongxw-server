package xls.report.testcase;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.*;

public class TemplateExcelMakePLantest {


    @Test
    public void map_plan() throws Exception {
        TemplateExportParams params = new TemplateExportParams(
                "templates/workplan_template.xlsx");
        Map<String, Object> map = new HashMap<String, Object>();
        Map <String, Object> info=new LinkedHashMap();
        map.put("info",info);
        info.put("makeDate","");
        info.put("makeBy","石头");
        List<Map<String, Object>> mapList = new ArrayList<>();
        int i=1;
        for(i=1; i<20;i++){
            Map<String, Object> row = new LinkedHashMap<>();
            row.put("customerName", "pppp");
            row.put("orderCode", "pppp");
            row.put("epCode", ";;;;") ;
            row.put("qty","z220");
            row.put("color", "z99");
            row.put("orderDate", "z99");
            row.put("issueDate", "ppppp");
            row.put("rmDate", "[[[[[[");
            row.put("pkgDate","[[[[[[[");
            row.put("planStart", "[pp");
            row.put("planFinish",";;");
            row.put("realFinish", ";;;");
            row.put("memo",";;;");

            mapList.add(row);
        }
        info.put("list",mapList);
        Workbook workbook = ExcelExportUtil.exportExcel(params, map);
        File savefile = new File("l:/opt/excel");
        if (!savefile.exists()) {
            savefile.mkdirs();
        }
        FileOutputStream fos = new FileOutputStream("l:/opt/excel/workplan_template_map.xls");
        workbook.write(fos);
        fos.close();
        System.out.print("l:/opt/excel/workplan_template_map.xls");
    }



}
