package common;

import app.support.query.PageResult;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.jtest.NodesFactroy.Node.HttpClientNode;
import com.kunlong.dongxw.customer.consts.ApiConstants;
import com.kunlong.dongxw.data.domain.MakePlan;
import com.kunlong.platform.support.service.AuthService;
import com.kunlong.platform.utils.JsonResult;

public class Login {
    String host = "127.0.0.1";
    String user = "mw";
    String pwd = "1";
    String urlBase = "http://127.0.0.1:10082/customer/";

    public String getUrlBase() {
        String urlBase = String.format("http://%s:10082/customer/", host);
        return urlBase;
    }

    public String getUrlLogin() {
        String urlLogin = getUrlBase() + String.format("auth/login?username=%s&password=%s",user,pwd);
        return urlLogin;
    }

    public String getUrlAuth() {
        String urlAuth = getUrlBase() + "auth/authorization";
        return urlAuth;
    }

    String urlLogin = getUrlBase() + "auth/login?username=mw&password=1";
    String urlAuth = getUrlBase() + "auth/authorization";

    public Login(String host, String user, String pwd) {
        this.host = host;
        this.user = user;
        this.pwd = pwd;
    }

    AuthService.AuthToken authToken;
    public  PageResult<MakePlan> parsePageResult(String text) {
        return JSON.parseObject(text, new TypeReference<PageResult<MakePlan>>() {
        });

    }
    public JsonResult<AuthService.AuthToken> parseJsonResult(String text) {
        return JSON.parseObject(text, new TypeReference<JsonResult<AuthService.AuthToken>>() {
        });

    }
    public AuthService.AuthToken loginAuth (HttpClientNode httpclient) {
        login(httpclient);
        auth(httpclient);
        return authToken;
    }

    public AuthService.AuthToken login (HttpClientNode httpclient) {


        String ret = httpclient.post(getUrlLogin(), "{}", "application/json");
        JsonResult<AuthService.AuthToken> jsonResult = parseJsonResult(ret);

        httpclient.checkStatusCode(200);
        authToken = jsonResult.getData();
        httpclient.addHeader(ApiConstants.AUTH_TOKEN_KEY_WEB, authToken.getToken());
        return authToken;


    }

    public String auth(HttpClientNode httpclient) {

        return httpclient.post(getUrlAuth(), "{}", "application/json");

    }

}
