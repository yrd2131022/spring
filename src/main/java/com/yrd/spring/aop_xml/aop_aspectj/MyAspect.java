package com.yrd.spring.aop_xml.aop_aspectj;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
	
	public void before() {
		System.out.println("MyAspect==>前置增强..........");
	}
	
	public void afterReturning() {
		System.out.println("MyAspect==>后置增强..........");
	}
	
	//Proceeding JoinPoint : 正在执行的连接点==切点
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("MyAspect==>环绕前增强.......");
		Object object = pjp.proceed();//切点方法
		System.out.println("MyAspect==>环绕后增强.......");
		return object;
	}
	
	public void afterThrowing() {
		System.out.println("MyAspect==>异常抛出增强..............");
	}
	
	//用于配置最终通知。无论增强方式执行是否有异常都会执行
	public void after() {
		System.out.println("MyAspect==>最终增强..............");
	}

}
