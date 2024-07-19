package com.ssafy.movie;

public class Animal {
	String name;
	int age;
	String catOrDog;
	
	public Animal(String name, int age, String catOrDog) {
		if(!catOrDog.equals("고양이") || !catOrDog.equals("개") ) {
			System.out.println("잘못된 입력입니다. 기본값 : 고양이");
			catOrDog = "고양이";
		}
		
		this.name = name;
		this.age = age;
		this.catOrDog = catOrDog;
	}
	
	void getInfo() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("고양이 OR 개 : " + catOrDog);
	}
}
