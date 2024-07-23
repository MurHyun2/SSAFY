package com.ssafy.offline;

import java.util.HashMap;
import java.util.Map;

/*
 * Object 사용
 * 장점 : 여러가지 타입을 받을 수 있다.
 * 단점 : 값을 꺼낼 때 마다 타입 캐스팅 해야한다.
 * 	  	특정 데이터 타입으로 제한할 수 없다.
 * 		실행시점에서야 에러가 발생하는 것을 알 수 있다.
 * 
 * Generic을 이용한 해결
 * 
*/
class Box {
	Object data;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}

/*
 * class 클래스이름<타입 파라미터>
 * 권장하는 1차 후보 이름
 * T : (Reference)Type
 * E : Element
 * K : Key
 * V : Value
 * N : Number
 * 
 * 		class Box -> Box b = new Box();
 * 		class GenericBox<T> -> GenericBox<String> b = new GenericBox<>();
*/
class GenericBox<T> {
	T data;
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
}

class DoubleBox<T, E> {
	T data;
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
}

public class GenericTest {
	public static void main(String[] args) {
		Box numberBox = new Box();
		numberBox.setData("문자열 데이터");
//		numberBox.setData(1);
		String data = (String) numberBox.getData();
		System.out.println(data);
		
		GenericBox<Integer> genericBox = new GenericBox<>();
		genericBox.setData(123);
		System.out.println(genericBox.getData());
	}
}
