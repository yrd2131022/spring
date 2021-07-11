package com.yrd.spring.quick_develop.factory;

import com.yrd.spring.quick_develop.dao.IUserDao;
import com.yrd.spring.quick_develop.dao.impl.UserDaoImpl;

public class StaticFactory {
	
	public static IUserDao getUserDao() {
		return new UserDaoImpl();
	}

}
