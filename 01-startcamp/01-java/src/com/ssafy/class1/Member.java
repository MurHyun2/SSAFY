package com.ssafy.class1;

public class Member {
	String name;
	int age;
	
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void print() {
		System.out.println(name);
		System.out.println(age);
		System.out.println("=========");
	}
}