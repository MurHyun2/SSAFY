package com.ssafy.offline.stack;

public class RecursiveTest05 {
	public static void main(String[] args) throws InterruptedException {
		int[] arr = { 1, 3, 5, 7, 9 };
		System.out.println(solve5(arr, arr.length - 1));
	}

	private static int solve5(int[] arr, int idx) {
		if (idx == 0) {
			return arr[idx];
		}

		return arr[idx] + solve5(arr, idx - 1);
	}
}
