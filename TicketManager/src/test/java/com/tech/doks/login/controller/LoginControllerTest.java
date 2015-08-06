package com.tech.doks.login.controller;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tech.doks.login.svc.impl.LoginServiceImplDsSpring;

public class LoginControllerTest {

	@org.junit.Test
	public final void test() {
	    //executed only once, before the first test
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("test-data-access.xml");
        
        //Get the EmployeeDAO Bean
        LoginServiceImplDsSpring loginServiceImplDsSpring = ctx.getBean("loginServiceImplDsSpring", LoginServiceImplDsSpring.class);
         System.out.println("--->" + loginServiceImplDsSpring);
        
         System.out.println("LoginServiceImplDsSpringTest in setUpClass method--->");
 		String userName = "test";
 		String password = "test";
 		boolean result = loginServiceImplDsSpring.authenticate(userName, password);
 		System.out.println("result--->" +result);
 		System.out.println("DONE");
 		ctx.close();
	}
}
