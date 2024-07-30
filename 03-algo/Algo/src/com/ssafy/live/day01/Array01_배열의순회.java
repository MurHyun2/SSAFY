package com.ssafy.live.day01;

public class Array01_배열의순회 {
	public static void main(String[] args) {

		int[] arr = new int[6];
		int[] arr2 = { 3, 4, 5, 1, 2 };

		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
		System.out.println();
		for (int i = arr2.length - 1; i >= 0; i--) {
			System.out.print(arr2[i] + " ");
		}

	}
}
