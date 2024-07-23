package com.ssafy.offline;
/*
 * 타입 파라미터의 제한
*/
class GenericNumberBox<T extends Number> {
	
}

public class GenericType3 {
	public static void main(String[] args) {
//		GenericNumberBox<String> box = new GenericNumberBox<>();
//		Bound mismatch: The type String is not a valid substitute for the bounded parameter <T extends Number> of the type GenericNumberBox<T>
		GenericNumberBox<Integer> box2 = new GenericNumberBox<>();
		GenericNumberBox<Double> box3 = new GenericNumberBox<>();
	}
}
