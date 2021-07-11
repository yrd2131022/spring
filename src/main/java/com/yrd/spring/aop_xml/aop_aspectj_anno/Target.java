package com.yrd.spring.aop_xml.aop_aspectj_anno;

import org.springframework.stereotype.Component;

@Component("target-anno")
public class Target {

	
	public void save() {
//		int i = 1/0;
		System.out.println("aop_aspectj-Target===>save running.....");
	}

}
