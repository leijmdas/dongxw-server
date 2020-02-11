package TestController;


import com.alibaba.fastjson.JSON;
import com.jtest.NodesFactroy.Inject.Inject;
import com.jtest.NodesFactroy.Node.HttpClientNode;
import com.jtest.annotation.JTest;
import com.jtest.annotation.JTestClass;
import com.jtest.testframe.ITestImpl;
import com.kunlong.dongxw.customer.consts.ApiConstants;
import com.kunlong.dongxw.customer.context.CurrentRequestContext;
import com.kunlong.dongxw.data.domain.Customer;
import com.kunlong.platform.consts.RequestContextConst;
import com.kunlong.platform.support.service.AuthService;
import com.kunlong.platform.utils.JsonResult;
import com.kunlong.platform.utils.KunlongUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.IOException;

@JTestClass.author("leijmdas")
public class TestAuth extends ITestImpl {

    private static final Logger logger = LoggerFactory.getLogger(TestAuth.class);

    String url_login = "http://127.0.0.1:10082/customer/auth/login?username=mw&password=1";
    String url_auth = "http://127.0.0.1:10082/customer/auth/authorization";
    String url_login_test = "http://120.77.172.83:10082/customer/auth/login?username=mw&password=1";
//    String url_auth = "http://120.79.98.67:82/customer/auth/authorization";
//    String url_login = "http://120.79.98.67:82/customer/auth/login?username=mw&password=1";

    @Inject(filename = "node.xml", value = "httpclient")
    HttpClientNode httpclient;

    AuthService.AuthToken authToken;

    public AuthService.AuthToken loginsys() {


        String ret = httpclient.post(url_login, "{}", "application/json");

        authToken = KunlongUtils.parseObject(ret, AuthService.AuthToken .class);
        System.out.println(KunlongUtils.toJSONStringPretty(authToken));
        httpclient.checkStatusCode(200);
        httpclient.addHeader(ApiConstants.AUTH_TOKEN_KEY_WEB, authToken.getToken());
        return authToken;

    }

    void auth() {

        httpclient.addHeader(ApiConstants.AUTH_TOKEN_KEY_WEB, authToken.getToken());
        String ret = httpclient.post(url_auth, "{}", "application/json");

    }

    public void suiteSetUp() {

    }

    public void suiteTearDown() throws IOException {
    }

    @Override
    public void setUp() {
        loginsys();
        auth();

    }

    @Override
    public void tearDown() {

    }

    @JTest
    @JTestClass.title("获取列表")
    @JTestClass.pre("")
    @JTestClass.step("test_0001_login")
    @JTestClass.exp("ok")
    public void test_0001_login() {



    }
    @JTest
    @JTestClass.title("获取列表")
    @JTestClass.pre("")
    @JTestClass.step("test_0001_login")
    @JTestClass.exp("ok")
    public void test_0002_login() {
        String ret = httpclient.post(url_login, "{}", "application/json");
        httpclient.checkStatusCode(200);

        JsonResult<Customer> result = JSON.parseObject(ret, JsonResult.class);
        System.out.println(ret);
        System.out.println(result);


    }

    public static void main(String[] args) {

        run(TestAuth.class, 1);
        //CurrentRequestContext.getContext().setAttribute(RequestContextConst.KEY_SESSIONKEY,"11");
        //System.out.print( CurrentRequestContext.getContext());
    }


}
		