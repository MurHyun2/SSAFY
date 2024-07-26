package com.ssafy.off.day10.live;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Test08_SerializationTest {
	public static void main(String[] args) {
		//파일 -> 객체
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("luna.dat"))){
			Object obj = ois.readObject();
			System.out.println(obj);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			// 에러 발생!!!
			// 왜 역직렬화가 안될까?
			// Person 설계도를 수정했기 때문
		}
	}
}
