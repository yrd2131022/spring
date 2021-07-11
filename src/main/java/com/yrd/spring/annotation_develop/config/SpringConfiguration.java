package com.yrd.spring.annotation_develop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//标志该类是Spring的核心配置类
@Configuration
//注解的组件扫描
//<context:component-scan base-package="com.yrd.spring.annotation_develop"/>
@ComponentScan("com.yrd.spring.annotation_develop")
//<!-- 引入其他配置文件 -->,如果多个{xxx1.class,xxx2.class,xxx3.class}
//<import resource="applicationContext-dataSource.xml" />
@Import({DataSourceConfiguration.class})
public class SpringConfiguration {
	
	

}
