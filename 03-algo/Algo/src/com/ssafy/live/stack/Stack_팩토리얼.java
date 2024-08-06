package com.ssafy.live.stack;

public class Stack_팩토리얼 {
	public static void main(String[] args) {

		System.out.println(factorial2(5));
	}

	static int factorial1(int N) {
		// 1부터 N까지의 곱을 return
		int result = 1;
		for (int i = 1; i <= N; i++) {
			result *= i;
		}
		return result;
	}

	static int factorial2(int N) {
		if (N == 1 || N == 0) {
			return 1;
		}

		return N * factorial2(N - 1);
	}
}
