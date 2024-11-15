package com.ssafy.off.day10.live;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class Test10_SerializationTest3 {
	public static void main(String[] args) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("list.dat"))) {
			List<Person> list = (List<Person>) ois.readObject();
			for (Person person : list) {
				System.out.println(person);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}