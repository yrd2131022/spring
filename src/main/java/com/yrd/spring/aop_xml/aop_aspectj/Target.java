package com.yrd.spring.aop_xml.aop_aspectj;

public class Target {

	
	@SuppressWarnings("unused")
	public void save() {
//		int i = 1/0;
		System.out.println("aop_aspectj-Target===>save running.....");
	}

}
