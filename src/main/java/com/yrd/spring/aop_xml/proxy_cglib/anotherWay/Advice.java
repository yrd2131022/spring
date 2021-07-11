package com.yrd.spring.aop_xml.proxy_cglib.anotherWay;



//增强或通知
public class Advice {
	
	public void before() {
		System.out.println("前置增强........");
	}
	
	public void afterReturning() {
		System.out.println("后置增强............");
	}

}
