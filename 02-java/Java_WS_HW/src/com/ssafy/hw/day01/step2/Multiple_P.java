package com.ssafy.hw.day01.step2;

public class Multiple_P {

	public static void main(String[] args) {

//		Scanner sc = new Scanner(System.in);
//
//		System.out.print("숫자를 입력하세요33333 : ");
//		int num = sc.nextInt();
//		// 입력한 숫자 검사
//		// 0을 입력받으면 반복 종료
//		while (num != 0) {
//			// 1부터 9까지 곱해서 출력
//			for (int i = 1; i <= 9; i++) {
//				System.out.println(num + " * " + i + " = " + num * i);
//			}
//			System.out.print("다음 숫자 입력 : ");
//			num = sc.nextInt();
//		}
//		System.out.println("프로그램 종료");

//		/* 구구단 가로 출력 */
//		Scanner sc = new Scanner(System.in);
//
//		System.out.print("숫자를 입력하세요33333 : ");
//		int num = sc.nextInt();
//		// 입력한 숫자 검사
//		// 0을 입력받으면 반복 종료
//		while (num != 0) {
//			// 1부터 9까지 곱해서 출력
//
//			for (int i1 = 1; i1 <= 9; i1++) {
//				for (int i = 2; i <= num; i++) {
////					System.out.print(i + " * " + i1 + " = " + i * i1 + " || ");
//					System.out.printf("%d * %d = %-2d || ", i, i1, i * i1);
//				}
//				System.out.println();
//			}
//			System.out.print("다음 숫자 입력 : ");
//			num = sc.nextInt();
//		}
//		System.out.println("프로그램 종료");
		
		int m = 4620;
		
		int a = m / 1000;
		int b = m % 1000 / 500;
		int c = m % 500 / 100;
		int d = m % 100 / 10;
		
		System.out.printf("%d %d %d %d", a, b, c, d);
	}
}
