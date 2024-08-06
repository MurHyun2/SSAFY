package com.ssafy.offline.stack;

public class RecursiveTest02 {
	// N을 입력 받아서 1 ~ N까지 출력하는 프로그램 작성

	public static void main(String[] args) throws InterruptedException {
		int N = 10;
		System.out.println("반복문 활용");
		solve1(N);
		System.out.println();
		
		System.out.println("재귀 활용");
		solve2(N);
		
		System.out.println("재귀 활용 2");
		solve3(1, N);
	}

	private static void solve3(int i, int n) {
		if(i > n)
			return;
		
		System.out.print(i + " ");
		
		solve3(i + 1, n);
		
	}

	private static void solve2(int n) {
		if (n == 0)
			return;

		solve2(n - 1);
		
		System.out.print(n + " ");
	}

	private static void solve1(int n) {
		for (int i = 1; i <= n; i++) {
			System.out.print(i + " ");
		}
		
	}
}
