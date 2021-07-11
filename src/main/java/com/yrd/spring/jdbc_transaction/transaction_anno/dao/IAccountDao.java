package com.yrd.spring.jdbc_transaction.transaction_anno.dao;

public interface IAccountDao {
	
	public void out(String outMan,double money);
	
	public void in(String inMan,double money);
	 

}
