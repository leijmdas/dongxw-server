package com.kunlong.dongxw.testcase;

import com.jtest.utility.testlog.TestLog;
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
   // @Autowired
   //DictDatatypeService dictDatatypeService;

    @Test
    public void test001_findById() {
        Customer c = customerService.findById(1);
        TestLog.logJtest("Customer", c);
        //DictDatatype dictDatatype = dictDatatypeService.findById(3);
       //TestLog.logJtest("dictDatatype", dictDatatype);

    }

    @Test
    public void test002_count() {
        long c = customerService.countByQueryParam(new Customer.QueryParam());

        TestLog.logJtest("long", c);
        //long dictDatatype = dictDatatypeService.countByQueryParam(new DictDatatype.QueryParam());
        //TestLog.logJtest("dictDatatype", dictDatatype);

    }

    @Test
    public void test003_findByQueryParam() {

        List<Customer> customers = customerService.findByQueryParam(new Customer.QueryParam());
        TestLog.logJtest("customers", customers);


        //Document document = new Document();
        ////Step 2—Get a PdfWriter instance.
        //PdfWriter.getInstance(document, new FileOutputStream(FILE_DIR + "createSamplePDF.pdf"));
        ////Step 3—Open the Document.
        //document.open();
        ////Step 4—Add content.
        //document.add(new Paragraph("Hello World"));
        ////Step 5—Close the Document.
        //document.close();

    }

    @Test
    public void test004_save() {

        customerService.save(new Customer());



    }
}

