package com.yrd.spring.aop_xml.proxy_jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.yrd.spring.aop_xml.proxy_jdk.impl.Target;

public class ProxyTest {

	public static void main(String[] args) {

		//目标对象
		Target target = new Target();
		//增强对象
		Advice advice = new Advice();
		
		/*
		 * 第一个参数：目标对象类加载器 第二个参数：目标对象相同的接口字节码对象数组 第三个参数：InvocationHandler接口
		 */
		// 返回值，就是动态生成的代理对象.返回值类型必须是目标对象的接口类，不能是实现类。
		ITargetInterface proxyInstance = (ITargetInterface) Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(), new InvocationHandler() {
					// 调用代理对象的任何方法，实质执行的都是invoke方法
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						//前置增强
						advice.before();
						
						// 执行目标方法
						Object object = method.invoke(target, args);
						
						//后置增强
						advice.afterReturning();
						return object;
					}
				}
		);
		
		//调用代理对象的方法
		proxyInstance.save();
	}
}
