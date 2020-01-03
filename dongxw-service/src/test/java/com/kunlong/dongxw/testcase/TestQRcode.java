package com.kunlong.dongxw.testcase;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.jtest.NodesFactroy.Inject.Inject;
import com.jtest.NodesFactroy.Node.HttpClientNode;
import com.jtest.annotation.JTest;
import com.jtest.annotation.JTestClass;
import com.jtest.testframe.ITestImpl;
import com.kunlong.dongxw.util.QRCodeGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

@JTestClass.author("leijm")
public class TestQRcode extends ITestImpl {
    private static final Logger logger = LoggerFactory.getLogger(TestQRcode.class);

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

    public static void main(String[] args) {

        run(TestQRcode.class, 2);

    }


}
		