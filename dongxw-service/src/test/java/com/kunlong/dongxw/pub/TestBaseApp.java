package com.kunlong.dongxw.pub;

import com.jtest.testframe.ITestImpl;
import com.kunlong.service.DongxwServiceApp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * @name BaseTest
 * @author ljm  | www.xwparking.com
 * @date 2018年11月23日  
 * @description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DongxwServiceApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class TestBaseApp extends ITestImpl {



    @Before
    public void setup() {

    }



}
