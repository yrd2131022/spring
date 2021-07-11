package com.yrd.spring.jdbc_transaction.transaction_anno.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yrd.spring.jdbc_transaction.transaction_anno.dao.IAccountDao;
import com.yrd.spring.jdbc_transaction.transaction_anno.service.IAccountService;

@Service("accountService_anno")
//配置在类上，表示该类中的所有方法都用该配置进行事务控制（类和方法都配置了，以方法为主）
//@Transactional(isolation = Isolation.REPEATABLE_READ)
public class AccountServiceImpl implements IAccountService {
	
	@Resource(name = "accountDao_anno")
	private IAccountDao accountDao;

	public void setAccountDao(IAccountDao accountDao) {
		this.accountDao = accountDao;
	}
	
	@Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED)
	public void transfer(String outMan,String inMan,double money) {
		//开启事务
		accountDao.out(outMan, money);
		@SuppressWarnings("unused")
		int i = 1/0;
		accountDao.in(inMan, money);
		//提交事务
	}
	
//	@Transactional(isolation = Isolation.REPEATABLE_READ)
//	public void xxx() {
//		
//	}

}
