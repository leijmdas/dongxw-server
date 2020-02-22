package com.kunlong.dongxw.testcase;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.jtest.utility.testlog.TestLog;
import com.kunlong.data.dao.BomModelMapper;
import com.kunlong.data.dao.ProductModelMapper;
import com.kunlong.data.entity.BomModel;
import com.kunlong.data.entity.BomModelExample;
import com.kunlong.data.entity.ProductModel;
import com.kunlong.data.entity.ProductModelExample;
import com.kunlong.dongxw.data.dao.TkCustomerMapper;
import com.kunlong.dongxw.data.dao.TkMapper;
import com.kunlong.dongxw.data.domain.Bom;
import com.kunlong.dongxw.data.service.MakePlanJoinService;
import com.kunlong.dongxw.pub.TestBaseApp;
import com.kunlong.dongxw.data.domain.Customer;
import com.kunlong.dongxw.data.service.CustomerService;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.collections.Lists;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.weekend.Weekend;

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
        example.createCriteria().andBigTypeIsNotNull().andIdEqualTo(14);
        long count = bomModelMapper.countByExample(example);
        RowBounds rowBounds = RowBounds.DEFAULT;

        List<BomModel> bomModels = bomModelMapper.selectByExampleWithRowbounds(example, rowBounds);

        System.out.println(count);
        for (BomModel bomModel : bomModels) {
            System.out.println(bomModel);
        }

        List<BomModelExample.Criteria> criteriaList = Lists.newArrayList();
    }

    @Autowired
    TkMapper tkMapper;

    @Test
    public void test0007_tkMapper() {
        Example example = new Example(Bom.class);

        int count = tkMapper.selectCountByExample(example);
        RowBounds rowBounds = new RowBounds(0, 3);

        List<Bom> list = tkMapper.selectByExampleAndRowBounds(example, rowBounds);
        System.out.println(list);
    }
    @Autowired
    TkCustomerMapper tkCustomerMapper;

    @Test
    public void test0008_tkCustomerMapper() {
        Example example = new Example(Customer.class);
        example.createCriteria().andNotEqualTo("custName","MW");
        int count = tkCustomerMapper.selectCountByExample(example);
        RowBounds rowBounds = new RowBounds(0, 2);
        example.setOrderByClause("id desc,addr asc");
        List<Customer> list = tkCustomerMapper.selectByExampleAndRowBounds(example, rowBounds);
        System.out.println(list);
        count=  tkCustomerMapper.selectCountByExample(example);
        System.out.println(count);
        //Weekend<Customer> weekend = new Weekend<>(Customer.class);
//        list = tkCustomerMapper.selectByExample(example);
//        System.out.println(list);


    }

    @Autowired
    ProductModelMapper productModelMapper;
    @Test
    public void test009_productModelMapper() throws IOException {
//        ProductModelExample example = new ProductModelExample();
//        long count = productModelMapper.countByExample(example);
//        RowBounds rowBounds = new RowBounds(0,2);
//
//        List<ProductModel> productModels = productModelMapper.selectByExampleWithRowbounds(example, rowBounds);
//
//        System.out.println(count);
//        for (ProductModel model : productModels) {
//            System.out.println(model);
//        }

    }

}
