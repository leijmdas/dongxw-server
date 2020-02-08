package service;

import com.kunlong.dubbo.api.service.FileApiService;
import com.kunlong.dubbo.api.service.MailApiService;
import com.kunlong.data.dao.BomModelMapper;
import com.kunlong.data.entity.BomModel;
import com.kunlong.data.entity.BomModelExample;
import com.kunlong.dongxw.DongxwApp;
import com.kunlong.dongxw.data.dao.OrderLineMapper;
import com.kunlong.dongxw.data.dao.TkCustomerMapper;
import com.kunlong.dongxw.data.domain.Customer;
import com.kunlong.dongxw.data.domain.OrderLine;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.ibatis.session.RowBounds;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import java.io.IOException;
import java.util.List;


/**
 * @author zz  | www.xwparking.com
 * @name BaseTest
 * @date 2018年11月23日
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DongxwApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class TestOrderLine {
    @Autowired
    OrderLineMapper orderLineMapper;

    @Reference(lazy = true)
    private FileApiService fileApiService;

    @Reference(lazy = true, version = "${dubbo.service.version}")
    MailApiService mailApiService;

    @Before
    public void setup() {

    }


    @Test
    public void test0001_service() {
        OrderLine orderLine = orderLineMapper.selectByPK(23);
        System.out.println(orderLine);
        //String ret = KunlongUtils.toJSONStringPretty(metadataField);
        //System.out.println(metadataField);
    }

    @Test
    public void test0002_service() {
        mailApiService.sendEmail("leijmdas_s@163.com","dubbo","duubo");
         
    }


    @Test
    public void test0003_upload() {
        //fileApiService.upload("leijmdas_s@163.com","dubbo",null,null);

    }


//    @Autowired
//    BomModelMapper bomModelMapper;
//
//    @Test
//    public void test0004_bomModelMapper() throws IOException {
//        BomModelExample example = new BomModelExample();
//        example.createCriteria().andBigTypeIsNotNull();
//
//        long count = bomModelMapper.countByExample(example);
//        RowBounds rowBounds = new RowBounds(0, 1);
//
//        List<BomModel> bomModels = bomModelMapper.selectByExampleWithRowbounds(example, rowBounds);
//
//        System.out.println(count);
//        for (BomModel bomModel : bomModels) {
//            System.out.println(bomModel);
//        }
//    }

    @Autowired
    TkCustomerMapper tkCustomerMapper;

    @Test
    public void test0005_tkCustomerMapper() {
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
}

