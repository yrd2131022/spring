package com.yrd.spring.quick_develop.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yrd.spring.quick_develop.dao.IUserDao;

public class UserDaoDemo {
	
	public static void main(String[] args) {
		
		ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		IUserDao userDao = (IUserDao) app.getBean("userDao");
		userDao.save();
		
		((AbstractApplicationContext) app).close();
		
		
	}

}
