package pub;

import com.jtest.NodesFactroy.Inject.Inject;
import com.jtest.NodesFactroy.Node.HttpClientNode;
import com.jtest.testframe.ITestImpl;
import com.kunlong.dongxw.consts.ApiConstants;
import com.kunlong.platform.support.service.AuthService;
import com.kunlong.platform.utils.KunlongUtils;

public class Login extends ITestImpl {
    String url_login ="http://127.0.0.1:10080/auth/login?username=admin&password=123456";
    String url_auth = "http://127.0.0.1:10080/sys/user/authorization";

    //@Inject(filename = "node.xml", value = "httpclient")
    //HttpClientNode httpclient;


    AuthService.AuthToken authToken;

    public AuthService.AuthToken loginsys( HttpClientNode httpclient) {


        String ret = httpclient.post(url_login, "{}", "application/json");

        authToken = KunlongUtils.parseObject(ret, AuthService.AuthToken .class);
        System.out.println(KunlongUtils.toJSONStringPretty(authToken));
        httpclient.checkStatusCode(200);
        httpclient.addHeader(ApiConstants.AUTH_TOKEN_KEY_WEB, authToken.getToken());
        return authToken;

    }

    void auth( HttpClientNode httpclient) {

        httpclient.addHeader(ApiConstants.AUTH_TOKEN_KEY_WEB, authToken.getToken());
        String ret = httpclient.post(url_auth, "{}", "application/json");

    }
}
