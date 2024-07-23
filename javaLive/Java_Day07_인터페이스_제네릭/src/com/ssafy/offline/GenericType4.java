package com.ssafy.offline;

/*
 * 와일드카드
*/
class WildBox<T> {
}

class Fruit {
}

class Apple extends Fruit {
}

class Grape extends Fruit {
}

class Banana {
}

public class GenericType4 {
	public static void main(String[] args) {
		WildBox<Fruit> fBox = new WildBox<>();
		WildBox<Apple> aBox = new WildBox<>();
		WildBox<Grape> gBox = new WildBox<>();
		WildBox<Banana> bBox = new WildBox<>();
//		fBox = aBox; //error
		WildBox<?> box1 = new WildBox<>();
		box1 = fBox;
		box1 = aBox;
		box1 = gBox;
		box1 = bBox;

		WildBox<? extends Fruit> box2 = new WildBox<>();
		box2 = fBox;
		box2 = aBox;
		box2 = gBox;
//		box2 = bBox;
//		Type mismatch: cannot convert from WildBox<Banana> to WildBox<? extends Fruit> //상한제한

		WildBox<? super Fruit> box3 = new WildBox<>();
		box3 = fBox;
//		box3 = aBox;
//		Type mismatch: cannot convert from WildBox<Apple> to WildBox<? super Fruit> //하한제한

	}
}
