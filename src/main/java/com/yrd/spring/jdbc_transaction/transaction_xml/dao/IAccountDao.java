package com.yrd.spring.jdbc_transaction.transaction_xml.dao;

public interface IAccountDao {
	
	public void out(String outMan,double money);
	
	public void in(String inMan,double money);
	 

}
