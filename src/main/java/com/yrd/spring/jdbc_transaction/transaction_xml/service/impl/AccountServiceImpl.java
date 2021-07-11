package com.yrd.spring.jdbc_transaction.transaction_xml.service.impl;

import com.yrd.spring.jdbc_transaction.transaction_xml.dao.IAccountDao;
import com.yrd.spring.jdbc_transaction.transaction_xml.service.IAccountService;

public class AccountServiceImpl implements IAccountService {
	
	private IAccountDao accountDao;

	public void setAccountDao(IAccountDao accountDao) {
		this.accountDao = accountDao;
	}
	
	public void transfer(String outMan,String inMan,double money) {
		//开启事务
		accountDao.out(outMan, money);
		@SuppressWarnings("unused")
		int i = 1/0;
		accountDao.in(inMan, money);
		//提交事务
	}

}
