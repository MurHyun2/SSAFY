package com.ssafy.off.day10.live;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Test09_SerializationTest2 {
	public static void main(String[] args) {
		List<Person> list = new ArrayList<>();
		
		list.add(new Person("daisy", 3));
		list.add(new Person("max", 4));
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("list.dat"))){
			oos.writeObject(list);
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}
