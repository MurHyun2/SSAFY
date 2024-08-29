package com.ssafy.offline.daily;

import java.util.Arrays;

public class MergeSort_829 {

	static int[] arr = { 7, 5, 13, 2, 79, 12, 35, 42 };
	static int N = arr.length; // 배열의 길이
	static int[] tmp = new int[N];

	public static void main(String[] args) {
		mergeSort(0, N - 1);

		System.out.println(Arrays.toString(arr));
	}

	private static void mergeSort(int left, int right) {
		if (left < right) {
			int mid = left / 2 + right / 2;
			mergeSort(left, mid);
			mergeSort(mid + 1, right);
			merge(left, mid, right);
		}
	}

	private static void merge(int left, int mid, int right) {
		int L = left;
		int R = mid + 1;

		int idx = left;

		while (L <= mid && R <= right) {
			if (arr[L] <= arr[R]) {
				tmp[idx++] = arr[L++];
			} else {
				tmp[idx++] = arr[R++];
			}
		}

		if (L <= mid) {
			for (int i = L; i <= mid; i++) {
				tmp[idx++] = arr[i];
			}
		} else {
			for (int i = R; i <= right; i++) {
				tmp[idx++] = arr[i];
			}
		}

		for (int i = left; i <= right; i++) {
			arr[i] = tmp[i];
		}
	}

}
