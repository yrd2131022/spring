package com.yrd.spring.jdbc_transaction.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceTest {
	


	// druid数据源(spring容器产生数据源对象 )
	@SuppressWarnings("resource")
	@Test
	public void test4() {

		ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		DruidDataSource dataSource = (DruidDataSource) app.getBean("dataSource");

		DruidPooledConnection connection = null;
		try {
			connection = dataSource.getConnection();
			System.out.println(connection);
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// druid数据源(加载配置文件 )
	@SuppressWarnings("resource")
	@Test
	public void test3() {
		// 读取配置文件,getBundle的参数为baseName（不需要扩展名即.properties）
		ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc");
		String driver = resourceBundle.getString("jdbc.driver");
		String url = resourceBundle.getString("jdbc.url");
		String username = resourceBundle.getString("jdbc.username");
		String password = resourceBundle.getString("jdbc.password");

		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);

		DruidPooledConnection connection = null;
		try {
			connection = dataSource.getConnection();
			System.out.println(connection);
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// druid数据源
	@SuppressWarnings("resource")
	@Test
	public void test2() {

		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/day14");
		dataSource.setUsername("root");
		dataSource.setPassword("root");

		DruidPooledConnection connection = null;
		try {
			connection = dataSource.getConnection();
			System.out.println(connection);
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// c3p0数据源
	@Test
	public void test1() throws Exception {

		ComboPooledDataSource dataSource = new ComboPooledDataSource();

		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/day14");
		dataSource.setUser("root");
		dataSource.setPassword("root");

		Connection connection = dataSource.getConnection();
		System.out.println(connection);
		connection.close();

	}

}
