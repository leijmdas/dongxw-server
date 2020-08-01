package com.kunlong.dongxw.testcase;

import com.alibaba.excel.annotation.ExcelProperty;
import com.jtest.utility.testlog.TestLog;
import com.kunlong.data.dao.BomModelMapper;
import com.kunlong.data.dao.ProductModelMapper;
import com.kunlong.data.entity.BomModel;
import com.kunlong.data.entity.BomModelExample;
import com.kunlong.dongxw.data.dao.TkCustomerMapper;
import com.kunlong.dongxw.data.dao.TkMapper;
import com.kunlong.dongxw.data.domain.*;
import com.kunlong.dongxw.data.service.*;
import com.kunlong.dongxw.pub.TestBaseApp;
import com.kunlong.dongxw.report.dto.PurchaseUseSumRptDTO;
import com.kunlong.dongxw.report.service.PurchaseUseSumService;
import com.kunlong.dongxw.util.ExportExcelTool;
import com.kunlong.dubbo.api.dto.queryParam.MetadataFieldModelQueryDTO;
import com.kunlong.dubbo.api.model.MetadataDictModelDTO;
import com.kunlong.dubbo.api.model.MetadataFieldModelDTO;
import com.kunlong.dubbo.api.service.MetadataDictApiService;
import com.kunlong.dubbo.api.service.MetadataFieldApiService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.ibatis.session.RowBounds;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.collections.Lists;
import tk.mybatis.mapper.entity.Example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

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
    // http://easypoi.mydoc.io/#category_49976
    @Test
    public void test_0010() throws IOException {
        List<MakePlan> makePlans = makePlanJoinService.findByOrder(4);
        makePlanJoinService.fillMakePlans(makePlans);
        System.out.print(makePlans.size());
        String fnNew = makePlanJoinService.writePlan2File("Makeplan", makePlans, "Makeplan.xlsx");
        System.out.println(fnNew);
    }



    @Data
    @AllArgsConstructor
    public static class Student {
        @ExcelProperty({"学号"})
        private String no;
        @ExcelProperty({"姓名"})
        private String name;
        @ExcelProperty({"生日"})
        private String birthday;
        @ExcelProperty({"生日"})
        private Date bday;

    }

    @Autowired
    ExportExcelTool  excelUtil;

    //   ExportExcelTool excelUtil = new ExportExcelTool<TestQRcode.Student>();
  //  String[] headers = {"顺序", "甲方系统","生日","生日"};
//        List<TestQRcode.Student> list = new ArrayList<>();
//        TestQRcode.Student student = new TestQRcode.Student("1", "张三", "2000-01-01",new Date());
//
//        list.add(student);
//        list.add(student);
    @com.alibaba.dubbo.config.annotation.Reference(lazy = true, version = "${dubbo.service.version}")
    MetadataDictApiService metadataDictApiService;
    @com.alibaba.dubbo.config.annotation.Reference(lazy = true, version = "${dubbo.service.version}")

    MetadataFieldApiService metadataFieldApiService;

    @Autowired
    PurchasePlanService purchasePlanService;
    @Autowired
    OrderMasterService orderMasterService;
    String path="C:\\Users\\Administrator\\Desktop\\";
    @Autowired
    ProductService productService;

    //MW用料汇总（EP-0238-20） 02(新AP13)	03(新AP13)	03P(新AP13)	07(新AP13)	57（新AP13)	65（新AP13)	67（新AP13)	68（新AP13)	69（新AP13)	72（新AP13)	77（新AP13)	80（新AP13)	131（16")	110（16")
    //汇总	单位	库存	采购量	供应商	订购数量	回仓数量	发出数量

    @Test
    public void test_0011_exportXls() throws Exception {

        Integer orderId = 66;

        OrderMaster orderMaster = orderMasterService.findById(orderId);
        Integer custId = orderMaster.getCustomerId() ;
        Customer customer=customerService.findById(custId);

        MetadataDictModelDTO metadataDictModelDTO = metadataDictApiService.findByName("purchase_plan");
        MetadataFieldModelQueryDTO query = new MetadataFieldModelQueryDTO();
        query.setLimit(-1);
        query.setParam(new MetadataFieldModelDTO());
        query.getParam().setMetadataId(metadataDictModelDTO.getMetadataId());

        List<MetadataFieldModelDTO> metadataFieldModelDTOS = metadataFieldApiService.query(query);

        PurchasePlan.QueryParam queryParam = new PurchasePlan.QueryParam();
        queryParam.setLimit(-1);
        queryParam.setParam(new PurchasePlan());
        queryParam.getParam().setOrderId(orderId);
        List<PurchasePlan> purchasePlans = purchasePlanService.findByQueryParam(queryParam);

        // List<String> hs = metadataFieldModelDTOS.stream().map(i -> i.getFieldMemo()).collect(Collectors.toList());
        Map<Integer, List<PurchasePlan>> results = purchasePlans.stream().collect(Collectors.groupingBy(PurchasePlan::getRmId));

        List<PurchaseUseSumRptDTO> dtoList = new ArrayList<>();

        for (Integer key : results.keySet()) {
            Product rm = productService.findById(key);

            PurchaseUseSumRptDTO pum = new PurchaseUseSumRptDTO();
            pum.setCode(rm.getCode());
            pum.setName(rm.getName());
            pum.setColor(rm.getColor());
            pum.setUnit(rm.getUnit());

            pum.setMap(new LinkedHashMap<>());
            BigDecimal sum=BigDecimal.ZERO;
            for (PurchasePlan pp : results.get(key)) {
                Integer pid = pp.getProductId();

                Product product = productService.findById(pid);
                pum.getMap().put(product.getCode() + " (" + product.getEpCode() + ")", pp.getTotalQty());
                sum=sum.add(pp.getTotalQty());
            }
            pum.setSum(sum);


            dtoList.add(pum);
        }
        List<PurchaseUseSumRptDTO> sortRptLst = dtoList.stream().sorted(Comparator.comparing(PurchaseUseSumRptDTO::getCode)).collect(Collectors.toList());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        File f = new File(path + customer.getCustName() + "-" + orderMaster.getCustomerOrderCode() + "订单物料采购进度表" + sdf.format(new Date()) + ".xlsx");
        try (OutputStream outputStream = new FileOutputStream(f);) {

            String sheetTitle = orderMaster.getCustomerOrderCode() + "用料汇总" + sdf.format(new Date());
            excelUtil.erpExportExcel(outputStream, sheetTitle, sortRptLst);

        }

    }

    @Autowired
    PurchaseUseSumService purchaseUseSumService;
    @Test
    public void test_0012_exportXls() throws Exception {
        Integer orderId = 66;
        File f = new File(path + "abc.xlsx");


        try (OutputStream outputStream = new FileOutputStream(f);) {
            String fn = purchaseUseSumService.export(outputStream, orderId);
            System.out.println(fn);
        }

    }

}
