package com.ssafy.offline.stack;

public class RecursiveTest06 {
	public static void main(String[] args) throws InterruptedException {
		int[] arr = { 1, 3, 5, 7, 9 };

		System.out.println(solve1(arr, 7, arr.length - 1)); // 재귀 :: 순차검색 : 3. 찾지 못한 경우 -1 출력;
		System.out.println(solve2(arr, 9, 0)); // 재귀 :: 순차검색 : 3. 찾지 못한 경우 -1 출력;
	}

	private static int solve2(int[] arr, int num, int idx) {
		if (idx >= arr.length)
			return -1;

		if (arr[idx] == num)
			return idx;

		return solve2(arr, num, idx + 1);
	}

	private static int solve1(int[] arr, int num, int idx) {
		if (idx < 0)
			return -1;

		if (arr[idx] == num)
			return idx;

		return solve1(arr, num, idx - 1);
	}
}
