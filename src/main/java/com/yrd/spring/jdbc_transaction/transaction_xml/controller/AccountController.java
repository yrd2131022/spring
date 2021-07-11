package com.yrd.spring.jdbc_transaction.transaction_xml.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yrd.spring.jdbc_transaction.transaction_xml.service.IAccountService;

public class AccountController {
	
	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		IAccountService accountService = app.getBean(IAccountService.class);
		
		accountService.transfer("Jack", "rose", 500);
		
		((AbstractApplicationContext) app).close();
	}
}
