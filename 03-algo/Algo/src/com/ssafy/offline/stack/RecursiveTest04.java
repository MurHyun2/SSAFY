package com.ssafy.offline.stack;

public class RecursiveTest04 {
	public static void main(String[] args) throws InterruptedException {
		solve1(13489);
		solve2(13489);
		System.out.println(solve3(13489, 0));
		System.out.println(solve4(13489));

		int[] arr = { 1, 3, 5, 7, 9 };
		System.out.println(solve5(arr, arr.length - 1));
	}

	private static int solve5(int[] arr, int idx) {
		if (idx == 0) {
			return arr[idx];
		}

		return arr[idx] + solve5(arr, idx - 1);
	}

	private static int solve4(int i) {
		if (i <= 0)
			return i;

		return (i % 10) + solve4(i / 10);
	}

	private static int solve3(int i, int sum) {
		if (i <= 0)
			return sum;

		return solve3(i / 10, sum += i % 10);
	}

	static int sum = 0;

	private static void solve2(int num) {
		sum += num % 10;

		if (num < 10) {
			System.out.println(sum);
			return;
		}

		solve2(num /= 10);
	}

	// 각 자리 숫자의 합 출력 25
	private static void solve1(int num) {
		String str = Integer.toString(num);
		char[] c = str.toCharArray();
		int sum = 0;

		for (char d : c) {
			sum += d - '0';
		}

		System.out.println(sum);
	}
}
