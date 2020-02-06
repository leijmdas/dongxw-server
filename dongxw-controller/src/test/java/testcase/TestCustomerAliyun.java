package testcase;


import app.support.query.PageResult;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.jtest.NodesFactroy.Inject.Inject;
import com.jtest.NodesFactroy.Node.HttpClientNode;
import com.jtest.annotation.JTest;
import com.jtest.annotation.JTestClass;
import com.jtest.testframe.ITestImpl;
import com.kunlong.dongxw.consts.ApiConstants;
import com.kunlong.dongxw.data.domain.Customer;
import com.kunlong.platform.support.service.AuthService;
import com.kunlong.platform.utils.JsonResult;
import com.kunlong.platform.utils.KunlongUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@JTestClass.author("leijmdas")
public class TestCustomerAliyun extends ITestImpl {

    private static final Logger logger = LoggerFactory.getLogger(TestCustomerAliyun.class);

    String url_login ="http://120.78.136.63:10080/auth/login?username=admin&password=111111";
    String url_auth = "http://120.78.136.63:10080/sys/user/authorization";

    String url_dongxw  = "http://120.78.136.63:8098/api/data/customer";
    String url_cust = "http://120.78.136.63:10081/data/customer";
    String url_manager = "http://120.78.136.63:10081/data/manager";

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
        //auth();

    }

    @Override
    public void tearDown() {

    }

    @JTest
    @JTestClass.title("获取列表")
    @JTestClass.pre("")
    @JTestClass.step("test_0001_custFindById")
    @JTestClass.exp("ok")
    public void test_0001_custFindById() {


        String ret = httpclient.post(url_cust + "/findById/1", "{}", "application/json");
        httpclient.checkStatusCode(200);

        JsonResult<Customer> result = JSON.parseObject(ret, JsonResult.class);
        System.out.println(ret);
        //System.out.println(result.getData());
        System.out.println(result);


    }

    //url_manager
    @JTest
    @JTestClass.title("获取列表")
    @JTestClass.pre("")
    @JTestClass.step("test_0002_managerFindDictDatatypeById")
    @JTestClass.exp("ok")
    public void test_0002_managerFindDictDatatypeById() {


    }
    //url_manager
    @JTest
    @JTestClass.title("获取列表")
    @JTestClass.pre("")
    @JTestClass.step("test_0003_findCustDongxw")
    @JTestClass.exp("ok")
    public void test_0003_findCustDongxw() {


    }

    public <T> PageResult<T> parsePageResult(String text, Class<T> clazz) {
        PageResult<T> result = JSON.parseObject(text, new

                TypeReference<PageResult<T>>() {

                });
        return result;
    }

    @JTest
    @JTestClass.title("获取列表")
    @JTestClass.pre("")
    @JTestClass.step("test_0004_custQry")
    @JTestClass.exp("ok")
    public void test_0004_custQry() {

        //httpclient.addHeader(consts.AUTH_TOKEN_KEY_WEB, authToken.getToken());
        String ret = httpclient.post(url_cust + "/query", "{}", "application/json");
        httpclient.checkStatusCode(200);
        System.out.println(ret);

        PageResult<Customer> result  = JSON.parseObject(ret, new
                TypeReference<PageResult<Customer>>() {   });
        result = parsePageResult(ret,Customer.class);

        System.out.println(result.getData());
    }

    public <T> JsonResult<T> parseJsonResult(String text, Class<T> clazz) {
        JsonResult<T> result = JSON.parseObject(text, new

                TypeReference<JsonResult<T>>() {

                });
        return result;
    }

    @JTest
    @JTestClass.title("获取列表")
    @JTestClass.pre("")
    @JTestClass.step("test_0005_custSave")
    @JTestClass.exp("ok")
    public void test_0005_custSave() {

        String ret = httpclient.post(url_cust + "/findById/12", "{}", "application/json");
        httpclient.checkStatusCode(200);

        JsonResult<Customer> result  = JSON.parseObject(ret, new

                TypeReference<JsonResult<Customer>>() {

                });
        //result=parseJsonResult(ret,Customer.class);
        Customer customer = result.getData();//JSONObject.parseObject(result.getData().toString(), Customer.class);
        System.out.println(customer);
        customer.setId(null);
        customer.setCustNo(null);

        ret = httpclient.post(url_cust + "/save", customer.toString(), "application/json");
        httpclient.checkStatusCode(200);
        System.out.println(ret);

        JsonResult<Integer> retSave = JSON.parseObject(ret, JsonResult.class);

        System.out.println(retSave.getData());




    }

    @JTest
    @JTestClass.title("获取列表")
    @JTestClass.pre("")
    @JTestClass.step("test_0006_custExport")
    @JTestClass.exp("ok")
    public void test_0006_custExport() {


        String ret = httpclient.post(url_cust + "/export", "{}", "application/json");
        httpclient.checkStatusCode(200);
        System.out.println(ret);


    }

    public static void main(String[] args) {

        run(TestCustomerAliyun.class, 4);

    }


}
		