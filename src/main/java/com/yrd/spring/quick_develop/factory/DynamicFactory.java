package com.yrd.spring.quick_develop.factory;

import com.yrd.spring.quick_develop.dao.IUserDao;
import com.yrd.spring.quick_develop.dao.impl.UserDaoImpl;

public class DynamicFactory {
	
	public IUserDao getUserDao() {
		return new UserDaoImpl();
	}

}
