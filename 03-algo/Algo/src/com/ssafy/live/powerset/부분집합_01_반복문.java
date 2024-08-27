package com.ssafy.live.powerset;

import java.util.Arrays;

public class 부분집합_01_반복문 {
	static String[] items = { "단무지", "오이", "햄", "시금치" };
	static int N = 4; // 재료의 수
	static int[] sel = new int[N]; // 체크 배열

	public static void main(String[] args) {
		// 재료가 4개니, 반복문 4개
		for (int i = 0; i <= 1; i++) { // 단무지
			sel[0] = i;
			for (int j = 0; j <= 1; j++) { // 오이
				sel[1] = j;
				for (int k = 0; k <= 1; k++) { // 햄
					sel[2] = k;
					for (int l = 0; l <= 1; l++) { // 시금치
						sel[3] = l;
						System.out.println(Arrays.toString(sel));
					}
				}
			}
		}
	}
}
