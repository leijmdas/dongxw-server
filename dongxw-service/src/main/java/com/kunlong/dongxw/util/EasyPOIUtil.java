package com.kunlong.dongxw.util;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

public class EasyPOIUtil {
    public static String makeExcelSheet(String templateName, String fileName, String sheetName, Map<String, Object> map) throws IOException {

        TemplateExportParams exportParams = new TemplateExportParams("templates/"+templateName);
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, map);
        workbook.setSheetName( 0,sheetName );
        File newFile= FileUtil.makeTmpFile(sheetName,fileName);
        FileOutputStream fos = new FileOutputStream(newFile);
        try {
            workbook.write(fos);
        } finally {
            fos.flush();
            fos.close();
        }

        return newFile.getAbsolutePath();
    }
}
