package com.ssafy.live.divide_conquer;

public class 거듭제곱02_분할정복 {
	public static void main(String[] args) {
		int C = 2;
		int N = 10;

		System.out.println(pow(C, N));
	}

	public static int pow(int C, int N) {
		if (N == 1)
			return C;

		if (N % 2 == 0) {
			int tmp = pow(C, N / 2);
			return tmp * tmp;
		} else {
			int tmp = pow(C, (N - 1) / 2);
			return tmp * tmp * C;
		}
	}
}