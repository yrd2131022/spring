package com.yrd.spring.annotation_develop.web;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.alibaba.druid.pool.DruidDataSource;
import com.yrd.spring.annotation_develop.config.SpringConfiguration;
import com.yrd.spring.annotation_develop.service.IUserService;

public class UserController {

	public static void main(String[] args) {
		
		
		ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfiguration.class);
	
		IUserService userService = (IUserService) app.getBean("userService");
		userService.save();
		
		//测试数据库
		DruidDataSource dataSource = (DruidDataSource) app.getBean("dataSource");
		try {
			Connection connection = dataSource.getConnection();
			System.out.println(connection);
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		((AbstractApplicationContext) app).close();
		
		
		
		
		
		
//		ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//
//		IUserService userService = (IUserService) app.getBean("userService");
//		userService.save();
//
//		((AbstractApplicationContext) app).close();
	}
}
