package com.ssafy.off.day08;

public class Idol /* implements Comparable<Idol> */{
	String name;
	int age;
	int fanCount;

	public Idol(String name, int age, int fanCount) {
		this.name = name;
		this.age = age;
		this.fanCount = fanCount;
	}

	@Override
	public String toString() {
		return "Idol [name=" + name + ", age=" + age + ", fanCount=" + fanCount + "]";
	}

//	@Override
//	public int compareTo(Idol idol) {
//		if (this.age == idol.age) {
//			return this.name.compareTo(idol.name);
//		}
//		return (this.age - idol.age) * -1;
//	}
}