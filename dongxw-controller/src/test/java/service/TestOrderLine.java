package service;

import com.kunlong.dongxw.DongxwControllerApp;
import com.kunlong.dongxw.dongxw.dao.OrderLineMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 
 * @name BaseTest
 * @author zz  | www.xwparking.com
 * @date 2018年11月23日  
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DongxwControllerApp.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class TestOrderLine {
 @Autowired
 OrderLineMapper orderLineMapper;
    @Before
    public void setup() {
       
    }
    
    public static void println(Object obj){
    }

       @Test
       public void test0001_service() {
           orderLineMapper.selectByPK(1);
           //String ret = KunlongUtils.toJSONStringPretty(metadataField);
           //System.out.println(metadataField);
       }



}

