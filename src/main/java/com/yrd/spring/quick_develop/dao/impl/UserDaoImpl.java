package com.yrd.spring.quick_develop.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.yrd.spring.quick_develop.dao.IUserDao;
import com.yrd.spring.quick_develop.domain.User;

public class UserDaoImpl implements IUserDao {
	
	private List<String> strList;
	private Map<String, User> userMap;
	private Properties properties;
	
	private String username;
	private int age;
	
	public UserDaoImpl() {
		System.out.println("UserDaoImpl创建.....");
	}
	
	public void save() {
		System.out.println("UserDaoImpl-->save running.....username:"+username+"====age:"+age);
		System.out.println("UserDaoImpl-->strList:"+strList);
		System.out.println("UserDaoImpl-->userMap:"+userMap);
		System.out.println("UserDaoImpl-->properties:"+properties);
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setStrList(List<String> strList) {
		this.strList = strList;
	}

	public void setUserMap(Map<String, User> userMap) {
		this.userMap = userMap;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	
	
	
	
//	public void init() {
//		System.out.println("UserDaoImpl初始化方法....");
//	}
//	
//	public void destroy() {
//		System.out.println("UserDaoImpl销毁方法....");
//	}


}
