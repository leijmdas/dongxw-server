package com.kunlong.dongxw.testcase;

import com.jtest.utility.testlog.TestLog;
import com.kunlong.dongxw.manager.domain.DictDatatype;
import com.kunlong.dongxw.manager.service.DictDatatypeService;
import com.kunlong.dongxw.pub.TestBaseApp;
import com.kunlong.dongxw.dongxw.domain.Customer;
import com.kunlong.dongxw.dongxw.service.CustomerService;
import com.kunlong.platform.utils.JsonResult;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestDongxwService extends TestBaseApp {

    @Autowired
    CustomerService customerService;
    @Autowired
    DictDatatypeService dictDatatypeService;

    @Test
    public void test001_findById() {
        Customer c = customerService.findById(1);
        TestLog.logJtest("Customer", c);
        DictDatatype dictDatatype = dictDatatypeService.findById(3);
        TestLog.logJtest("dictDatatype", dictDatatype);

    }

    @Test
    public void test002_count() {
        long c = customerService.countByQueryParam(new Customer.QueryParam());

        TestLog.logJtest("long", c);
        long dictDatatype = dictDatatypeService.countByQueryParam(new DictDatatype.QueryParam());
        TestLog.logJtest("dictDatatype", dictDatatype);

    }

    @Test
    public void test003_findByQueryParam() {

        List<Customer> customers = customerService.findByQueryParam(new Customer.QueryParam());
        TestLog.logJtest("customers", customers);

        List<DictDatatype> dictDatatypes = dictDatatypeService.findByQueryParam(new DictDatatype.QueryParam());
        TestLog.logJtest("dictDatatypes", dictDatatypes);
        //Document document = new Document();
        ////Step 2—Get a PdfWriter instance.
        //PdfWriter.getInstance(document, new FileOutputStream(FILE_DIR + "createSamplePDF.pdf"));
        ////Step 3—Open the Document.
        //document.open();
        ////Step 4—Add content.
        //document.add(new Paragraph("Hello World"));
        ////Step 5—Close the Document.
        //document.close();
        //————————————————
        //版权声明：本文为CSDN博主「辰辰呐」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
        //原文链接：https://blog.csdn.net/qq_37581708/article/details/79709612
    }

    @Test
    public void test004_save() {

        customerService.save(new Customer());



    }
}

