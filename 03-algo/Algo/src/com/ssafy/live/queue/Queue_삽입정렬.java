package com.ssafy.live.queue;

import java.util.Arrays;

public class Queue_삽입정렬 {
	
	static int[] queue = new int[100];
	static int front = -1;
	static int rear = -1;
	
	public static void main(String[] args) {
		
		enQueue(10);
		enQueue(12);
		enQueue(3);
		enQueue(9);
		enQueue(8);
		
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
		

		int[] arr = new int[] { 69, 10, 30, 2, 16, 8, 31, 32 };

		// 삽입 정렬
		// i : 정렬되지 않은 집합의 첫번쨰 원소
		for (int i = 1; i < arr.length; i++) {
			int data = arr[i];
			int j;
			// 정렬된 집합의 뒤에서부터 비교하여 위치 찾아주기
			for (j = i - 1; j >= 0 && arr[j] > data; j--) {
				arr[j + 1] = arr[j];
			}
			arr[j + 1] = data;
		}
		System.out.println(Arrays.toString(arr));
	}
	
	static void enQueue(int data) {
		int i = ++rear;
		int j;
		// 정렬된 집합의 뒤에서부터 비교하여 위치 찾아주기
		for (j = i - 1; j >= 0 && queue[j] > data; j--) {
			queue[j + 1] = queue[j];
		}
		queue[j + 1] = data;
	}
	
	static int deQueue() {
		return queue[++front];
	}
}
