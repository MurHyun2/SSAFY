package com.ssafy.offline.day03;

import java.util.Arrays;

public class 정렬 {
	public static void main(String[] args) {
		int[] arr = { 4, 3, 1, 5, 2 };
		System.out.println(Arrays.toString(arr));
		System.out.println();
//		System.out.println(Arrays.toString(bubbleSort(arr)));
		System.out.println(Arrays.toString(SelectionSort(arr)));
	}

	static int[] bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {

			for (int j = 0; j < arr.length - 1 - i; j++) {

				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					System.out.println(Arrays.toString(arr));
				}
				
			}

		}
		
		System.out.println();
		
		return arr;
	}
	
	static int[] SelectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int minIdx = i;

			for (int j = i + 1; j < arr.length; j++) {
				if(arr[minIdx] > arr[j]) {
					minIdx = j;
				}
				
				int temp = arr[i];
				arr[i] = arr[minIdx];
				arr[minIdx] = temp;
				
			}
			
		}
		System.out.println();
		
		return arr;
	}
}
