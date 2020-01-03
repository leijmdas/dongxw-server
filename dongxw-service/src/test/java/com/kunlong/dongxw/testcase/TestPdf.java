package com.kunlong.dongxw.testcase;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.jtest.NodesFactroy.Inject.Inject;
import com.jtest.NodesFactroy.Node.HttpClientNode;
import com.jtest.annotation.JTest;
import com.jtest.annotation.JTestClass;
import com.jtest.testframe.ITestImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@JTestClass.author("leijm")
public class TestPdf extends ITestImpl {
    private static final Logger logger = LoggerFactory.getLogger(TestPdf.class);

    String url_sysuser = "http://127.0.0.1:10080/rest/sysuser";
    String url_export = "http://127.0.0.1:10081/dongxw/export";
    String url_dongxw  = "http://127.0.0.1:8098/api/dongxw/customer";

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

    @JTest
    @JTestClass.title("pdf")
    @JTestClass.pre("")
    @JTestClass.step("test_0002_normalPdf")
    @JTestClass.exp("ok")
    public void test_0002_normalPdf() throws DocumentException, FileNotFoundException {


        //Step 4—Add content.
        //页面大小
        Rectangle rect = new Rectangle(PageSize.B5.rotate());
        //页面背景色
        rect.setBackgroundColor(BaseColor.ORANGE);

        Document document = new Document(rect);

        PdfWriter writer =  PdfWriter.getInstance(document, new FileOutputStream( "/newPdf.pdf"));
        //PdfWriter writer = PdfWriter.getInstance(doc, out);

        //PDF版本(默认1.4)
        writer.setPdfVersion(PdfWriter.PDF_VERSION_1_2);

        //文档属性
        document.addTitle("Title@sample");
        document.addAuthor("Author@rensanning");
        document.addSubject("Subject@iText sample");
        document.addKeywords("Keywords@iText");
        document.addCreator("Creator@iText");

        //页边空白
        document.setMargins(10, 20, 30, 40);

        document.open();
        document.add(new Paragraph("Hello World"));

        //Step 5—Close the Document.
        document.close();

    }

//    public byte[] genQR(String text,String ext) throws Exception {
//        QRCodeGenerator gen = new QRCodeGenerator();
//        BufferedImage img = gen.encodeQR(text);
//
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//
//        ImageIO.write(img, ext == null? "PNG":ext, out);
//
//        return out.toByteArray();
//    }
    public static void main(String[] args) {

        run(TestPdf.class, 2);

    }


}
		