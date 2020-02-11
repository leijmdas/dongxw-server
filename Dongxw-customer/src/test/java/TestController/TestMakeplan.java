package TestController;


import app.support.query.PageResult;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.jtest.NodesFactroy.Inject.Inject;
import com.jtest.NodesFactroy.Node.HttpClientNode;
import com.jtest.annotation.JTest;
import com.jtest.annotation.JTestClass;
import com.jtest.testframe.ITestImpl;
import com.kunlong.dongxw.data.domain.MakePlan;
import com.kunlong.platform.utils.KunlongUtils;
import common.Login;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@JTestClass.author("leijmdas")
public class TestMakeplan extends ITestImpl {

    private static final Logger logger = LoggerFactory.getLogger(TestMakeplan.class);
    String url_base = "http://127.0.0.1:10082/customer/";

    @Inject(filename = "node.xml", value = "httpclient")
    HttpClientNode httpclient;
    Login login = new Login("127.0.0.1", "mw", "1");


    public void suiteSetUp() {

    }

    public void suiteTearDown() throws IOException {
    }

    @Override
    public void setUp() {
        login.loginAuth(httpclient);
        url_base = login.getUrlBase();
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
    @JTestClass.step("test_0002_query")
    @JTestClass.exp("ok")
    public void test_0002_query() {
        String url = url_base + "makeplan/query";

        String ret = httpclient.post(url, "{}", "application/json");
        httpclient.checkStatusCode(200);
        System.out.println(ret);
        PageResult<MakePlan> pageResult = login.parsePageResult(ret);
        System.out.println(KunlongUtils.toJSONStringPretty(pageResult.getData()));

    }

    public static void main(String[] args) {

        run(TestMakeplan.class, 2);
    }


}
		