package com.ssafy.live.divide_conquer;

import java.util.Arrays;

public class 이진검색02_이진검색_재귀 {

	static int[] arr;
	static int key;

	public static void main(String[] args) {
		arr = new int[] { 8, 9, 17, 21, 23, 35, 88, 369 };
		key = 19;

		binarySearch(0, arr.length - 1);

		Arrays.binarySearch(arr, 19); // 배열과 key를 주면 있는지 찾아줌.
	}

	static boolean binarySearch(int left, int right) {
		// 기저 조건
		if (left > right)
			return false;

		// 재귀
		int mid = (left + right) / 2;
		// 같다면
		if (arr[mid] == key)
			return true;
		// 크다면 (중앙 값이) -> 왼쪽 구간으로
		else if (arr[mid] > key)
			return binarySearch(left, mid - 1);
		// 작다면 (중앙 값이)
		else
			return binarySearch(mid + 1, right);
	}
}