package com.ssafy.live.day02;

public class Array02_이진검색 {
	public static void main(String[] args) {
		int[] nums = { 2, 4, 7, 9, 11, 19, 23 };
		
		System.out.println(binarySearch(nums, 11));
	}

	static int binarySearch(int[] arr, int key) {
		int left = 0;
		int right = arr.length - 1;
		while(left <= right) {
			int mid = (left + right) / 2;
			if(arr[mid] == key) {
				return mid;
			} else if (arr[mid] < key) {
				left = mid +1;
			} else {
				right = mid - 1;
			}
		}
		return - 1;
	}
}
