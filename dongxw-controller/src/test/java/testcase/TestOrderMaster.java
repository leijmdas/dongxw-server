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
import com.kunlong.dongxw.data.domain.OrderMaster;
import com.kunlong.platform.support.service.AuthService;
import com.kunlong.platform.utils.JsonResult;
import com.kunlong.platform.utils.KunlongUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pub.Login;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@JTestClass.author("leijmdas")
public class TestOrderMaster extends ITestImpl {

    private static final Logger logger = LoggerFactory.getLogger(TestOrderMaster.class);

    String url_login ="http://127.0.0.1:10080/auth/login?username=admin&password=123456&verifyCode=";
    String url_auth = "http://127.0.0.1:10080/sys/user/authorization";

    String url_cust = "http://127.0.0.1:10081/data/customer";
    String url_order = "http://127.0.0.1:10081/data/ordermaster";

    @Inject(filename = "node.xml", value = "httpclient")
    HttpClientNode httpclient;

    AuthService.AuthToken authToken;
    Login login=new Login();

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
        login.loginsys(httpclient);
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
    @JTestClass.step("test_0006_export")
    @JTestClass.exp("ok")
    public void test_0006_export() throws IOException {
        OrderMaster.QueryParam queryParam=new OrderMaster.QueryParam ();
        queryParam.setParam(new OrderMaster());
        queryParam.setLimit(1);

        byte[] ret = httpclient.postHttpEntity(url_order + "/export", KunlongUtils.toJSONString(queryParam),"application/json");
        httpclient.checkStatusCode(200);
        System.out.println(new String(ret));
        File f=new File("l:/1.xlsx");
        try(FileOutputStream out=new FileOutputStream(f)){
            out.write(ret);
        }

    }
    @JTest
    @JTestClass.title("获取列表")
    @JTestClass.pre("")
    @JTestClass.step("test_0007_mailExport")
    @JTestClass.exp("ok")
    public void test_0007_mailExport() {


        String ret = httpclient.post(url_order + "/exportMail", "{}", "application/json");
        httpclient.checkStatusCode(200);
        System.out.println(ret);


    }
    public static void main(String[] args) {

        run(TestOrderMaster.class, 7);

    }


}
		