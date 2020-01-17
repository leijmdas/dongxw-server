package com.kunlong.dongxw.customer.web;


import app.support.query.PageResult;
//import com.kunlong.dongxw.annotation.DateRewritable;
import com.kunlong.dongxw.customer.consts.ApiConstants;
import com.kunlong.dongxw.dongxw.domain.Customer;
import com.kunlong.dongxw.dongxw.service.CustomerService;
import com.kunlong.platform.support.service.AuthService;
import com.kunlong.platform.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.SessionHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * cust类
 * Package:
 * Author: cch/leijiming
 * Date: Created in 2018/8/23 16:50
 */
@RestController
@RequestMapping(ApiConstants.AUTH_API_WEB_DONGXW+"/customer")
public final class CustomerController    {
    @Autowired
    CustomerService customerService;

    //@Reference(lazy = true, version = "${dubbo.service.version}")
    //AuthApiService authApiService;

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value="login",method = RequestMethod.POST)
    public @ResponseBody
    AuthService.AuthToken login(String username, String password) {
//        MerchantInfoDTO m = this.merchantInfoService.checkPasswd(username,password);
//
//        AuthToken at  = this.authService.createToken("merchant:"+m.getId());
//        SessionHolder sholder =SessionHolder.create(at.getToken());
//        sholder.setAttribute(SessionKeyEnum.WEB_MERCHANT_ID.getKey(), m.getId());
        return null;
    }

    @RequestMapping("authorization")
    public @ResponseBody
    Map<String,Object> authorization(String token) {
//        Object merchantIdObj = SessionHolder.getInstance(token).getAttribute(SessionKeyEnum.WEB_MERCHANT_ID.getKey());
//        Integer merchantId = merchantIdObj == null?-1:(Integer)merchantIdObj;
//        MerchantInfoDTO m = this.merchantInfoService.findById(merchantId);
//        MiniUser miniUser = new MiniUser();
//        miniUser.setId(m.getId());
//        miniUser.setUsername(m.getName());
//        miniUser.setHeaderImg(m.getLogo());
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("user", null);
        return map;
    }


    @RequestMapping("/findById/{id}")
    public JsonResult<Customer> findById(@PathVariable("id") Integer id,HttpServletResponse response) throws IOException {
       return   JsonResult.success(customerService.findById(id))    ;
    }


    @RequestMapping("/query")
    public PageResult<Customer> query(@RequestBody Customer.QueryParam queryParam) throws IOException {
        PageResult<Customer> pageResult = new PageResult<Customer>();
        // Customer.QueryParam qp = BeanMapper.getInstance().map(pageResult, Customer.QueryParam.class);

        pageResult.setTotal(customerService.countByQueryParam(queryParam));
        pageResult.setData(customerService.findByQueryParam(queryParam));
        //System.err.println(authApiService.checkExists("1111"));
        return pageResult;
    }





}

