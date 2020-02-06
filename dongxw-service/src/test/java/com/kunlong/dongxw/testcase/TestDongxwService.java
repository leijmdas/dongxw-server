package com.kunlong.dongxw.testcase;

import com.jtest.utility.testlog.TestLog;
import com.kunlong.data.dao.BomModelMapper;
import com.kunlong.data.entity.BomModel;
import com.kunlong.data.entity.BomModelExample;
import com.kunlong.dongxw.data.service.MakePlanJoinService;
import com.kunlong.dongxw.pub.TestBaseApp;
import com.kunlong.dongxw.data.domain.Customer;
import com.kunlong.dongxw.data.service.CustomerService;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

public class TestDongxwService extends TestBaseApp {
    @Autowired
    MakePlanJoinService makePlanJoinService;

    @Autowired
    CustomerService customerService;
    @Test
    public void test001_findCustomerById() {
        Customer c = customerService.findById(22);
        TestLog.logJtest("Customer", c);

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

    @Test
    public void test005_MakePlanJoinService_makeSheetByPlanOrder() throws IOException {
        makePlanJoinService.makeSheetByPlanOrder(4,0);
    }

    @Autowired
    BomModelMapper bomModelMapper;

    @Test
    public void test006_bomModelMapper() throws IOException {
        BomModelExample example = new BomModelExample();
        example.createCriteria().andBigTypeIsNotNull();

        long count = bomModelMapper.countByExample(example);
        RowBounds rowBounds = new RowBounds(0, 3);

        List<BomModel> bomModels = bomModelMapper.selectByExampleWithRowbounds(example, rowBounds);

        System.out.println(count);
        for (BomModel bomModel : bomModels) {
            System.out.println(bomModel);
        }
    }

}

