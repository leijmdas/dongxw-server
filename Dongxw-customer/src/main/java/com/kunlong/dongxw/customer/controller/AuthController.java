package com.kunlong.dongxw.customer.controller;

import com.alibaba.fastjson.JSON;
import com.kunlong.api.service.AuthApiService;
import com.kunlong.dongxw.customer.consts.ApiConstants;
import com.kunlong.dongxw.customer.consts.SessionKeyEnum;
import com.kunlong.dongxw.dongxw.domain.Customer;
import com.kunlong.dongxw.dongxw.service.CustomerService;
import com.kunlong.platform.model.KunlongModel;
import com.kunlong.platform.support.service.AuthService;
import com.kunlong.platform.utils.KunlongUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping(ApiConstants.AUTH_API_WEB_CUSTOMER+"/auth")
@Controller
public class AuthController extends BaseController {

	private static final long TOKEN_TIMEOUT = 7200;
	@Reference(lazy = true, version = "${dubbo.service.version}")
	AuthApiService authApiService;

	@Autowired
		 CustomerService customerService;

		 Customer checkPasswd(String username, String password) {
			 Customer.QueryParam queryParam = new Customer.QueryParam();
			 queryParam.setParam(new Customer());
			 queryParam.getParam().setLoginName(username);
			 List<Customer> customers = customerService.findByQueryParam(queryParam);
			 if (customers == null || customers.size() == 0) {
				 throw new RuntimeException("Customer login info error!");
			 }
			 if (!customers.get(0).getLoginPassword().equalsIgnoreCase(password)) {
				 throw new RuntimeException("Customer login info error!");
			 }
			 return customers.get(0);
		 }

		 /**
		  * 登录
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value="login",method = RequestMethod.POST)
	public @ResponseBody
	AuthService.AuthToken login(String username, String password, String verifyCode) {

		Customer customer = checkPasswd(username, password);
		return authApiService.createToken("web:customer:" + customer.getId(),
				SessionKeyEnum.WEB_CUSTOMER.getKey(), customer, TOKEN_TIMEOUT);
	}


	@PostMapping("authorization")
	public @ResponseBody
	Map<String, Object> authorization(String token, HttpServletResponse response) {
		Object map = authApiService.getAttribute(token, SessionKeyEnum.WEB_CUSTOMER.getKey());
		System.out.println(KunlongUtils.toJSONStringPretty(map));
		MiniCustomer customer = JSON.parseObject(KunlongUtils.toJSONStringPretty(map), MiniCustomer.class);
		if (customer == null) {
			response.setStatus(401);
			return null;
			//writeError(401, "authorization_fail", "TOKEN不存在或已失效", rsp);
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("customer", customer);
		return resultMap;
	}

	public static class MiniCustomer extends KunlongModel {
		private Integer id;

		private String custNo;


		private String custName;

		private String headerImg;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getCustNo() {
			return custNo;
		}

		public void setCustNo(String custNo) {
			this.custNo = custNo;
		}

		public String getCustName() {
			return custName;
		}

		public void setCustName(String custName) {
			this.custName = custName;
		}

		public String getHeaderImg() {
			return headerImg;
		}

		public void setHeaderImg(String headerImg) {
			this.headerImg = headerImg;
		}



	}
}
