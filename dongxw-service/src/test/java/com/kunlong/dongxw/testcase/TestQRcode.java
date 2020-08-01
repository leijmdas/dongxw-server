package com.kunlong.dongxw.testcase;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.jtest.NodesFactroy.Inject.Inject;
import com.jtest.NodesFactroy.Node.HttpClientNode;
import com.jtest.annotation.JTest;
import com.jtest.annotation.JTestClass;
import com.jtest.testframe.ITestImpl;
import com.kunlong.dongxw.data.domain.PurchasePlan;
import com.kunlong.dongxw.report.base.IRptDTO;
import com.kunlong.dongxw.util.ExportExcelTool;
import com.kunlong.dongxw.util.QRCodeGenerator;
import com.kunlong.dongxw.util.TenderExportExcelUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hwpf.usermodel.Fields;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.assertj.core.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@JTestClass.author("leijm")
public class TestQRcode extends ITestImpl {
    private static final Logger logger = LoggerFactory.getLogger(TestQRcode.class);

    String url_sysuser = "http://127.0.0.1:10080/rest/sysuser";
    String url_export = "http://127.0.0.1:10081/data/export";
    String url_dongxw  = "http://127.0.0.1:8098/api/data/customer";

    @Inject(filename = "node.xml", value = "httpclient")
    HttpClientNode httpclient;
    //Login login = new Login();

    public void suiteSetUp() {

    }

    public void suiteTearDown() throws IOException {
    }

    @Override
    public void setUp() {
        //  login.loginsys(httpclient);
        //auth();
    }

    @Override
    public void tearDown() {

    }

    @JTest
    @JTestClass.title("pdf")
    @JTestClass.pre("")
    @JTestClass.step("test_0001_simplePdf")
    @JTestClass.exp("ok")
    public void test_0001_simplePdf() throws DocumentException, FileNotFoundException {


     /*   String ret = httpclient.post(url_producttype + "/findById/1", "{}", "application/json");
        httpclient.checkStatusCode(200);

        JsonResult<Customer> result = JSON.parseObject(ret, JsonResult.class);
        System.out.println(ret);
        //System.out.println(result.getData());
        System.out.println(result);*/
        Document document = new Document();
        //Step 2—Get a PdfWriter instance.
        PdfWriter.getInstance(document, new FileOutputStream( "/createSamplePDF.pdf"));
        //Step 3—Open the Document.
        document.open();
        //Step 4—Add content.
        document.add(new Paragraph("Hello World"));
        //Step 5—Close the Document.
        document.close();

    }
    public byte[] genQR(String text,String ext) throws Exception {
        QRCodeGenerator gen = new QRCodeGenerator();
        BufferedImage img = gen.encodeQR(text);

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        ImageIO.write(img, ext == null? "PNG":ext, out);

        return out.toByteArray();
    }

    @JTest
    @JTestClass.title("pdf")
    @JTestClass.pre("")
    @JTestClass.step("test_0002_normalPdf")
    @JTestClass.exp("ok")
    public void test_0002_genQR() throws Exception {

        byte[] b=genQR("http://120.78.136.63:8888/group1/M00/00/00/rBIvIF4O0CCAHhqQAAAKStJzL20007.png",null);
        try(FileOutputStream fo=new FileOutputStream(new File("/orderUrl.png"))) {
            fo.write(b);
        }


    }

    @JTest
    @JTestClass.title("pdf")
    @JTestClass.pre("")
    @JTestClass.step("test_0002_normalPdf")
    @JTestClass.exp("ok")
    public void test_0003_uploadXls() throws Exception {

        byte[] b=genQR("http://120.78.136.63:8888/group1/M00/00/00/rBIvIF4O0CCAHhqQAAAKStJzL20007.png",null);
        try(FileOutputStream fo=new FileOutputStream(new File("/orderUrl.png"))) {
            fo.write(b);
        }


    }

    void tt() {
        String fileName = "l:/报表.xlsx";
        ExcelWriter excelWriter = EasyExcel.write(fileName).build();
        java.util.List<Student> students = new ArrayList<>();
        Student student = new Student("1", "张三", "2000-01-01",new Date());
        students.add(student);
        //这里 需要指定写用哪个class去写
        WriteSheet writeSheet = EasyExcel.writerSheet(0, "学生信息1").head(Student.class).build();
        excelWriter.write(students, writeSheet);
        writeSheet = EasyExcel.writerSheet(1, "学生信息2").head(Student.class).build();
        excelWriter.write(students, writeSheet);
        //千万别忘记finish 会帮忙关闭流
        excelWriter.finish();
    }


    @Data
    @AllArgsConstructor
    public static class Student    implements IRptDTO  {
        @ExcelProperty({"学号"})
        private String no;
        @ExcelProperty({"姓名"})
        private String name;
        @ExcelProperty({"生日"})
        private String birthday;
        @ExcelProperty({"生日"})
        private Date bday;

        public String[] getHeaders() {
            return new String[0];
        }


        @Override
        public Map<String, Object> getMap() {
            return null;
        }
    }

    @Autowired
    ExportExcelTool<Student> excelUtil;

    @JTest
    @JTestClass.title("test_0004_expXls")
    @JTestClass.pre("")
    @JTestClass.step("test_0004_expXls")
    @JTestClass.exp("ok")
    public void test_0004_expXls() throws Exception {

        ExportExcelTool excelUtil = new ExportExcelTool<Student>();
        String[] headers = {"顺序", "甲方系统","生日","生日"};
        List<Student> list = new ArrayList<>();
        Student student = new Student("1", "张三", "2000-01-01",new Date());

        list.add(student);
        list.add(student);
        list.add(student);
        list.add(student);
        list.add(student);
        list.add(student);
        list.add(student);
        list.add(student);
        list.add(student);
        list.add(student);
        File f = new File("c:/usesum.xlsx");

        try (OutputStream outputStream=new FileOutputStream(f);XSSFWorkbook workbook = new XSSFWorkbook()) {
            excelUtil.exportExcel2007("物料汇总", headers, list,
                    outputStream, "yyyy-MM-dd", workbook);

        }

    }

    public static void main(String[] args) {

        //  run(TestQRcode.class, 4);
        Field[] fields = new PurchasePlan().getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
        System.out.println(fields[i].getName());
        }
    }


}
		