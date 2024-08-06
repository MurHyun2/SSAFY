package com.ssafy.offline.stack;

public class RecursiveTest03 {
	// N을 입력 받아서 1 ~ N까지 출력하는 프로그램 작성

	public static void main(String[] args) throws InterruptedException {
		int N = 5;
		System.out.println("반복문 활용한 합 구하기");
		solve1(N);

		System.out.println("재귀 활용한 합 구하기");
		solve2(N, 0);
		
		System.out.println("재귀 활용한 합 구하기 2");
		solve3(N);
		
		System.out.println("재귀 활용한 합 구하기 3");
		solve4(1, N);
		
		int sum = solve5(N);
		System.out.println("합계 : " + sum);
	}
	
	private static int solve5(int n) {
		if(n == 1)
			return 1;
		
		return n + solve5(n - 1);
	}

	static int sum1 = 0;
	
	private static void solve4(int i, int n) {
		if(i > n) {
			System.out.println(sum1);
			return;
		}
		sum1 += i;
		
		solve4(i + 1, n);
	}

	static int sum = 0;
	
	private static void solve3(int n) {
		if (n == 0) {
			System.out.println(sum);
			return;
		}
		
		sum += n;
		solve3(n - 1);
	}

	private static void solve2(int n, int sum) {
		if (n == 0) {
			System.out.println(sum);
			return;
		}

		solve2(n - 1, sum + n);
	}

	private static void solve1(int n) {
		int sum = 0;

		for (int i = 1; i <= n; i++) {
			sum += i;
		}

		System.out.println(sum);
	}
}
