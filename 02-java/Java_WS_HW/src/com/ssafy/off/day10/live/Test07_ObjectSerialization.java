package com.ssafy.off.day10.live;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Test07_ObjectSerialization {
	public static void main(String[] args) {
		Person p = new Person("luna", 5);

		// 객체 => 파일에 저장
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("luna.dat"))) {

			oos.writeObject(p);

		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}

class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}