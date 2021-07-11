package com.yrd.spring.aop_xml.aop_aspectj_anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//配置文件中需要添加，如下代码才可以表示当前类是切面类
//<!-- aop 自动代理 -->
//<aop:aspectj-autoproxy/>
@Aspect // 除了添加@Aspect标记，还要在配置文件中需要添加，以上代码才可以表示当前类是切面类
@Component("myAspect-anno")
public class MyAspect {

	// 定义切点表达式
	@Pointcut("execution(* com.yrd.spring.aop_xml.aop_aspectj_anno.*.*(..))")
	public void pointcut() {

	}

	@Before("execution(* com.yrd.spring.aop_xml.aop_aspectj_anno.*.*(..))")
	public void before() {
		System.out.println("MyAspect==>前置增强..........");
	}

	@AfterReturning("pointcut()")
	public void afterReturning() {
		System.out.println("MyAspect==>后置增强..........");
	}

	// Proceeding JoinPoint : 正在执行的连接点==切点
	@Around("pointcut()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("MyAspect==>环绕前增强.......");
		Object object = pjp.proceed();// 切点方法
		System.out.println("MyAspect==>环绕后增强.......");
		return object;
	}

	@AfterThrowing("MyAspect.pointcut()")
	public void afterThrowing() {
		System.out.println("MyAspect==>异常抛出增强..............");
	}

	// 用于配置最终通知。无论增强方式执行是否有异常都会执行
	@After("MyAspect.pointcut()")
	public void after() {
		System.out.println("MyAspect==>最终增强..............");
	}

}
