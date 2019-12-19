package com.kunlong.dongxw.testcase;

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
	 	System.out.print(1);
        Customer c=customerService.findById(1);
	 	System.out.print(c);
		
	}


	@Test public void test002(){
	    customerService.countByQueryParam(new Customer.QueryParam());
    }
}

