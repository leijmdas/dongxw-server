package com.kunlong.dongxw.testcase;

import com.jtest.utility.testlog.TestLog;
import com.kunlong.dongxw.pub.TestBaseApp;
import com.kunlong.service.dongxw.domain.Customer;
import com.kunlong.service.dongxw.service.CustomerService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestDongxw extends TestBaseApp {

    @Autowired
    CustomerService customerService;
	/**
	 * 按时长计费
	 */
	@Test
	public void test001() {
        Customer c=customerService.findById(1);
	 	TestLog.logJtest("Customer",c);
		
	}


	@Test public void test002(){
	    customerService.countByQueryParam(new Customer.QueryParam());
    }
}

