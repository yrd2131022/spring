package com.yrd.spring.quick_develop.service.impl;

import com.yrd.spring.quick_develop.dao.IUserDao;
import com.yrd.spring.quick_develop.service.IUserService;

public class UserServiceImpl implements IUserService {
	
	private IUserDao userDao;
	
	//无参构造函数
	public UserServiceImpl() {
		System.out.println("UserServiceImpl 创建了。。");
	}
	
	//有参构造函数
	public UserServiceImpl(IUserDao userDao) {
		this.userDao = userDao;
		System.out.println("UserServiceImpl 创建了。。");
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void save() {
		
		System.out.println("UserServiceImpl...save  running...");
		
		userDao.save();

	}

}
