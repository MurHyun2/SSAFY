package com.ssafy.live.day03;

import java.util.Arrays;

public class Array03_2차원배열 {
	public static void main(String[] args) {
		int[][] arr = new int[3][3];

		// 정방향 행 우선순회 하면서 초기화
		int num = 1;
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[r].length; c++) {
				arr[r][c] = num++;
			}
		}

		// 2차원 배열 출력
		System.out.println(Arrays.deepToString(arr));

		// 역방향 행 우선순회
		for (int r = 0; r < arr.length; r++) {
			for (int c = arr[r].length - 1; c >= 0; c--) {
				System.out.print(arr[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		// 정방향 행 우선순회
		for (int c = 0; c < arr[0].length; c++) {
			for (int r = 0; r < arr.length; r++) {
				System.out.print(arr[r][c] + " ");
			}
			System.out.println();
		}
	}
}
