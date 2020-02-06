package service;

import com.kunlong.api.service.MailApiService;
import com.kunlong.dongxw.DongxwApp;
import com.kunlong.dongxw.data.dao.OrderLineMapper;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


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
    //    @Autowired
    //    private FileApiService fileApiService;

    @Reference(lazy = true, version = "${dubbo.service.version}")
    MailApiService mailApiService;

    @Before
    public void setup() {

    }


    @Test
    public void test0001_service() {
        orderLineMapper.selectByPK(1);
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

//
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
}

