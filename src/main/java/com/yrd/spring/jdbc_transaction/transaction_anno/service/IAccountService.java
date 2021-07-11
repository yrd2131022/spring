package com.yrd.spring.jdbc_transaction.transaction_anno.service;

public interface IAccountService  {
	public void transfer(String outMan,String inMan,double money);
}
