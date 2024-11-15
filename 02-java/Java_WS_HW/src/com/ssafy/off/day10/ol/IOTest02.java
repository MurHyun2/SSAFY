package com.ssafy.off.day10.ol;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class User implements Serializable {
	private String name;
	private int age;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}

}

public class IOTest02 {
	public static void main(String[] args) {
		User u1 = new User("가나다", 25);
		User u2 = new User("라마바", 23);

		List<User> uList = new ArrayList<>();
		uList.add(u1);
		uList.add(u2);

		try (FileOutputStream fos = new FileOutputStream("data/user.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(uList);
			System.out.println("END");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		method();
	}

	public static void method() {
		try (FileInputStream fio = new FileInputStream("data/user.dat");
				ObjectInputStream ois = new ObjectInputStream(fio)) {
			List<User> uList = (List<User>) ois.readObject();
			for (User user : uList) {
				System.out.println(user);
			}
		} catch (IOException | ClassNotFoundException e) {
			// TODO: handle exception
		}
	}
}
