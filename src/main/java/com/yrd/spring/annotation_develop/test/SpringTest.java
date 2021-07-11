package com.yrd.spring.annotation_develop.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yrd.spring.quick_develop.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
//@ContextConfiguration(classes = {SpringConfiguration.class})
public class SpringTest {
	
	@Autowired
	ApplicationContext app;
	
	@Autowired
	@Qualifier("userService")
	private IUserService userService;
	
	@Test
	public void test0() {
		userService.save();
	}
	
	
	@Test//使川 execute ()方法执行 SQL 语句，创建用户账户管理表 account
	public void test1() {
		
		
		//加载配置文件
//		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//		ApplicationContext app = AppUtils.getApplicationContext();
		JdbcTemplate jdbcTemplate = (JdbcTemplate) app.getBean("jdbcTemplate");
		
		String sql="create table tbl_account( "
				+ "id int primary key auto_increment,"
				+ "username varchar(30),"
				+ "balance double)";
		jdbcTemplate.execute(sql);
		System.out.println("账户表 tbl_account 创建成功!");
	
//		app.close();
	}
	

	

}
