package com.ssafy.offline.stack;

public class RecursiveExam01 {
	// N을 입력 받아서 1 ~ N까지 출력하는 프로그램 작성

	public static void main(String[] args) throws InterruptedException {
		int num = 2;
		int cnt = 5;

		// 반복
		solve1(num, cnt);

		// 재귀
		solve2(num, cnt);

	}

	static int result = 1;
	
	private static void solve2(int num, int cnt) {
		if (cnt == 0) {
			System.out.println(result);
			return;
		}
		
		result *= num;
		solve2(num, cnt - 1);
	}

	private static void solve1(int num, int cnt) {
		int result = 1;
		for (int i = 1; i <= cnt; i++) {
			result *= num;
		}
		
		System.out.println(result);
	}
}
