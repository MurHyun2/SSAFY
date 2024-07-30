package com.ssafy.live.day02;

import java.util.Arrays;

public class Array02_순차검색 {
	public static void main(String[] args) {

		int[] arr = { 4, 9, 11, 23, 2, 19, 7 };
		int key = 25;
		
		for (int i : arr) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		System.out.println(searchForNoSort(arr, key));
		System.out.println(searchWhileNoSort(arr, key));
		
		Arrays.sort(arr);
		for (int i : arr) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		System.out.println(searchForSort(arr, key));
		System.out.println(searchWhileSort(arr, key));
	}

	static int searchForNoSort(int[] arr, int key) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key)
				return i;
		}
		return -1;
	}

	static int searchWhileNoSort(int[] arr, int key) {
		int now = 0;

		while (now < arr.length) {
			if (arr[now] == key)
				return now;
			now++;
		}
		return -1;
	}

	static int searchForSort(int[] arr, int key) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key)
				return i;
			else if (arr[i] > key)
				return i;
		}
		return -1;
	}

	static int searchWhileSort(int[] arr, int key) {
		int i = 0;
		while (i < arr.length) {
			if (arr[i] == key)
				return i;
			else if (arr[i] > key)
				return i;
			i++;
		}
		
		return -1;
	}
}
