package com.yrd.spring.quick_develop.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yrd.spring.quick_develop.dao.IUserDao;


public class SpringTest {
	


	// 测试scope属性
	@Test
	public void testScope() {

		ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserDao userDao = (IUserDao) app.getBean("userDao");
//		IUserDao userDao2 = (IUserDao) app.getBean("userDao");
//		IUserDao userDao3 = app.getBean("userDao",IUserDao.class);
		System.out.println(userDao);
//		System.out.println(userDao2);

		((AbstractApplicationContext) app).close();

	}

	// 测试scope属性,无参“构造”方法实例化
	@Test
	public void testScope1() {

		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserDao userDao = (IUserDao) app.getBean("userDao");
		System.out.println(userDao);

		app.close();

	}


	// 测试scope属性,工厂“静态”方法实例化
	@Test
	public void testStaticFactory() {

		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserDao userDao = (IUserDao) app.getBean("userDao_staticFactory");
		System.out.println(userDao);

		app.close();

	}
	
	// 测试工厂“实例”方法实例化
	@Test
	public void testDynamicFactory() {

		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserDao userDao = (IUserDao) app.getBean("userDao_dynamicFactory");
		System.out.println(userDao);

		app.close();

	}

}
