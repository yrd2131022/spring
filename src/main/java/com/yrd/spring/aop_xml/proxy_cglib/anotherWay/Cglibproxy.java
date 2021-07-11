package com.yrd.spring.aop_xml.proxy_cglib.anotherWay;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class Cglibproxy implements MethodInterceptor {

	// 代理方法
	public Object createProxy(Object target) {
		// 返回值，就是动态生成的代理对象.基于cglib。
		// 1.创建增强器,创建一个动态类对象
		Enhancer enhancer = new Enhancer();
		// 2.确定需要增强的类，设置其父类（目标）
		enhancer.setSuperclass(target.getClass());
		// 3.设置回调
		enhancer.setCallback(this);
		// 4.返回创建的代理类
		return enhancer.create();
	}
	
	
	/**
	 * proxy CGlib 根据指定父类生成的代理对象
	 * method 拦截的方法
	 * args 拦截方法的参数数组
	 * methodProxy 方法的代理对象，用于执行父类的方法
	 */

	@Override
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		// TODO Auto-generated method stub
		// 创建切面类对象
		Advice advice = new Advice();
		//前置增强
		advice.before();
		//目标方法执行
		Object object = methodProxy.invokeSuper(proxy, args);
		//后置增强
		advice.afterReturning();
		
		return object;
	}
	
	
	public static void main(String[] args) {
		//创建代理对象
		Cglibproxy cglibproxy = new Cglibproxy();
		//创毡口标对象
		Target target = new Target();
		//获取增强后的门标对象
		Target proxyObject = (Target) cglibproxy.createProxy(target);
		//执行方法
		proxyObject.save();
	}

}
