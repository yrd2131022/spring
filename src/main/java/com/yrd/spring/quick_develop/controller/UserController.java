package com.yrd.spring.quick_develop.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yrd.spring.quick_develop.service.IUserService;

public class UserController {

	public static void main(String[] args) {
//第一种获取userService对象
//		IUserService userService = new UserServiceImpl();
//		userService.save();

		//第二种获取userService对象,允许获取两个相同类型的bean，只要 <bean id="userService"的id不同即可。
		ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

		IUserService userService = (IUserService) app.getBean("userService");
		userService.save();

		((AbstractApplicationContext) app).close();
		
		//第三种获取userService对象，这种不好。使用app.getBean(IUserService.class);该类型只能有一个
		//（class="com.yrd.spring.quick_develop.service.impl.UserServiceImpl"）
//		ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//		IUserService userService =  app.getBean(IUserService.class);
//		userService.save();
//		((AbstractApplicationContext) app).close();
	}

}
