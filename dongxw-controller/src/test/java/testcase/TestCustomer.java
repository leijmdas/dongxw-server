package testcase;


import com.alibaba.fastjson.JSON;
import com.jtest.NodesFactroy.Inject.Inject;
import com.jtest.NodesFactroy.Node.HttpClientNode;
import com.jtest.annotation.JTest;
import com.jtest.annotation.JTestClass;
import com.jtest.testframe.ITestImpl;
import com.kunlong.platform.utils.JsonResult;
import com.kunlong.dongxw.dongxw.domain.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import testcase.pub.ManagerLogin;

import java.io.IOException;

@JTestClass.author("leijm")
public class TestCustomer extends ITestImpl {
	private static final Logger logger = LoggerFactory.getLogger(TestCustomer.class);

	String url_sysuser = "http://127.0.0.1:10080/rest/sysuser";
	String url_cust = "http://127.0.0.1:10081/dongxw/customer";

	@Inject(filename = "node.xml", value = "httpclient")
	HttpClientNode httpclient;


	//MsgRequest req = new MsgRequest();
	public void suiteSetUp() {
	
	}
	
	public void suiteTearDown() throws IOException {
	}

	@Override
	public void setUp() {
//		req = login.defaultReq();
//		token = login.login(req);
//		logger.info("aaa--req:{} ******",req.toJSONStringPretty());
//		logger.info("bbb req:{} ******",req.toJSONStringPretty());
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



		String ret = httpclient.post(url_cust+"/findById/1", "{}", "application/json");
		httpclient.checkStatusCode(200);

		JsonResult<Customer> result = JSON.parseObject(ret,JsonResult.class);
		System.out.println(ret);
		//System.out.println(result.getData());
		System.out.println(result );


	}
	

	public static void main(String[] args) {

		 run(TestCustomer.class,1);

	}


}
		