package com.yrd.spring.aop_xml.proxy_jdk.impl;

import com.yrd.spring.aop_xml.proxy_jdk.ITargetInterface;

public class Target implements ITargetInterface {

	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("Jdk-Target===>save running.....");
	}

}
