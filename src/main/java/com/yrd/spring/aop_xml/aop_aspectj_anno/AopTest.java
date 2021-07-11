package com.yrd.spring.aop_xml.aop_aspectj_anno;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AopTest {
	
	@Autowired
	@Qualifier("target-anno")
	private Target target;
	
	@Test
	public void test1() {
		target.save();
	}
	

}
