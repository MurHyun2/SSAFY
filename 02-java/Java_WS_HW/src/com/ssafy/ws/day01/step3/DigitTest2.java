package com.ssafy.ws.day01.step3;

/**
 * 모래시계 모양의 숫자 출력하는 클래스
 */
public class DigitTest2 {

	public static void main(String[] args) {
		int a = 1;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}

			for (int j = 5; j > i * 2; j--) {
				System.out.print(a + " ");
				a++;
			}
			System.out.println();
		}
		
		for (int i = 1; i < 3; i++) {
			for (int j = 5; j > i * 4; j--) {
				System.out.print(" ");
			}

			for (int j = 0; j < i * 2; j++) {
				System.out.print(a + " ");
				a++;
			}
			System.out.println();
		}
		 
	}
}
