package com.yrd.spring.jdbc_transaction.transaction_anno.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yrd.spring.jdbc_transaction.transaction_anno.dao.IAccountDao;


@Repository("accountDao_anno")
public class AccountDaoImpl implements IAccountDao {

	@Autowired
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
