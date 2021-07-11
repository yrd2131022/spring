package com.yrd.spring.jdbc_transaction.transaction_xml.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import com.yrd.spring.jdbc_transaction.transaction_xml.dao.IAccountDao;

public class AccountDaoImpl implements IAccountDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void out(String outMan,double money) {
		jdbcTemplate.update("update account set money = money-? where name = ? ", money,outMan);
	}
	
	public void in(String inMan,double money) {
		jdbcTemplate.update("update account set money = money+? where name = ? ", money,inMan);
	}
}
