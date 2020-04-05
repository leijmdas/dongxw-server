package TestDubbo;

import com.kunlong.dubbo.api.model.KunlongApiModel;
import com.kunlong.dubbo.api.service.AuthApiService;
import com.kunlong.dubbo.api.service.MailApiService;
import com.kunlong.dongxw.CustomerApp;
import com.kunlong.platform.model.KunlongModel;
import com.kunlong.platform.support.service.AuthService;
import com.kunlong.platform.utils.KunlongUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zz  | www.xwparking.com
 * @name BaseTest
 * @date 2018年11月23日
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CustomerApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class TestAuth {


    @Reference(lazy = true, version = "${dubbo.service.version}")
    MailApiService mailApiService;
    @Reference(lazy = true, version = "${dubbo.service.version}")
    AuthApiService authApiService;

    @Before
    public void setup() {

    }

    //mailApiService.sendEmail("leijmdas_s@163.com","dubbo","duubo");

    @Test
    public void test0001_service_checkExists() {

        Boolean b = authApiService.checkExists("111");
        System.err.print(b);
    }

    @Test
    public void test0002_service_createToken() {

        AuthService.AuthToken authToken = authApiService.createToken("111", "1", "1", 12);
        System.err.print(KunlongUtils.toJSONStringPretty(authToken));

    }


}

