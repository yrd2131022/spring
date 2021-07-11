package com.yrd.spring.quick_develop.domain;

public class User {

	private String name;
	private String addr;
	private double balance; 

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "User {\"name\"=\"" + name + "\", \"addr\"=\"" + addr + "\", \"balance\"=\"" + balance + "\"}";
	}

	

}
