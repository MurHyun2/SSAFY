package com.ssafy.off.day09;

/*class MyCheckedException extends Exception {
} // checked exception 예외 처리 강제 o(강제적)

class MyUnCheckedException extends RuntimeException {
} // unchecked exception 예외 처리 강제 x(선택적)
*/

class CarPriceException extends RuntimeException {
	public CarPriceException() {
		// TODO Auto-generated constructor stub
		super("CarPice는 0보다 작을 수 없습니다.");
	}
	public CarPriceException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
}

class Car {
	String name;
	int price;

	public Car(String name, int price) throws CarPriceException {
		if (price < 0) {
			// throw new CarPriceException();
			throw new CarPriceException("가격은 0보다 커야합니다. Price : " + price);
		}

		this.name = name;
		this.price = price;
	}
}

public class ExceptionTest02 {
	public static void main(String[] args) {
		try {
			System.out.println(1 / 0);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		try {
			Car c1 = new Car("모닝", 1000);
			Car c2 = new Car("테슬라", -1);
		} catch (CarPriceException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		// throw > 예외 발생 선언
//		throw new MyCheckedException();
//		throw new MyUnCheckedException();
	}
}
