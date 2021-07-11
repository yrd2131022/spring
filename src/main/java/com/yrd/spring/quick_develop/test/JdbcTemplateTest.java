package com.yrd.spring.quick_develop.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yrd.spring.quick_develop.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class JdbcTemplateTest {
	
	@Autowired
	ApplicationContext app;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	

	@Test//使川 execute ()方法执行 SQL 语句，创建用户账户管理表 account
	public void test1() {
		
		//加载配置文件
//		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//		JdbcTemplate jdbcTemplate = (JdbcTemplate) app.getBean("jdbcTemplate");
		
		String sql="create table tbl_account( "
				+ "id int primary key auto_increment,"
				+ "username varchar(30),"
				+ "balance double)";
		jdbcTemplate.execute(sql);
		System.out.println("账户表 tbl_account 创建成功!");
	
//		app.close();
	}
	
	@Test
	public void test2() {
		jdbcTemplate.update("insert into tbl_account(username,balance) values(?,?)","tom",2000);
	}
	
	@Test
	public void test3() {
		jdbcTemplate.update("delete from tbl_account(username) values(?)","tom");
	}
	
	@Test
	public void testQueryAll() {
		String sql = "select username as name,balance,'天津' as addr from tbl_account";
		List<User> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper<User>(User.class));
		System.out.println(list);
	}
	
	@Test
	public void testQueryOne() {
		String sql = "select username as name,balance,'天津' as addr from tbl_account where username = ? ";
		 User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), "tom");
		System.out.println(user);
	}
	
	@Test
	public void testQueryCount() {
		String sql = "select count(*) from tbl_account";
		Long long1 = jdbcTemplate.queryForObject(sql, Long.class);
		System.out.println(long1);
	}
	

	

}
