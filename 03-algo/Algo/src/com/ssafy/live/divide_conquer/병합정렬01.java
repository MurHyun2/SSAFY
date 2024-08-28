package com.ssafy.live.divide_conquer;

import java.util.Arrays;

public class 병합정렬01 {

	static int[] arr = { 7, 5, 13, 2, 79, 12, 35, 42 };
	static int N = arr.length; // 배열의 길이
	static int[] tmp = new int[N]; // 추가적인 공간

	public static void main(String[] args) {
		mergeSort(0, N - 1);
		System.out.println(Arrays.toString(arr));
	}

	// left : 구간의 시작 위치 / right : 구간의 끝
	static void mergeSort(int left, int right) {
//		if (left >= right)
//			return;
//		int mid = (left + right) / 2;
//		mergeSort(left, mid);
//		mergeSort(mid + 1, right);

		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(left, mid);
			mergeSort(mid + 1, right);
			merge(left, mid, right);
		}

	}

	// left는 시작 구간, right는 끝구간 mid 는 왼쪽 구간의 끝
	// mid + 1 은 오른쪽 구간의 첫 번째
	private static void merge(int left, int mid, int right) {
		int L = left; // 왼쪽 구간의 시작 포인트
		int R = mid + 1; // 오른쪽 구간의 시작 포인트

		int idx = left; // tmp 배열의 인덱스

		// L과 R 모두 끝구간에 도착하지 못했다 -> 정렬할게 남았다.
		while (L <= mid && R <= right) {
			if (arr[L] <= arr[R]) {
				tmp[idx++] = arr[L++];
			} else {
				tmp[idx++] = arr[R++];
			}
		}

		// 왼쪽구간의 값이 남았음
		if (L <= mid) {
			for (int i = L; i <= mid; i++) {
				tmp[idx++] = arr[i];
			}
		}
		// 오른쪽구간의 값이 남았음
		else {
			for (int i = R; i <= right; i++) {
				tmp[idx++] = arr[i];
			}
		}

		// 월본배열에 반영
		for (int i = left; i <= right; i++) {
			arr[i] = tmp[i];
		}
	}
}
