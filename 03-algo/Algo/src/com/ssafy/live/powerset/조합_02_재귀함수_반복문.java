package com.ssafy.live.powerset;

import java.util.Arrays;

public class 조합_02_재귀함수_반복문 {
	static String[] items = { "상추", "패티", "치즈", "토마토" };
	static int N, R; // N : 재료의 수, R : 내가 뽑고 싶은 재료의 수
	static String[] sel; // 뽑은 재료들을 저장할 배열

	public static void main(String[] args) {
		N = 4;
		R = 2;
		sel = new String[R];

		combination(0, 0);
	}

	static void combination(int idx, int sidx) {
		// 기저조건
		if (sidx == R) {
			System.out.println(Arrays.toString(sel));
			return;
		}

		for (int i = idx; i <= N - R + sidx; i++) {
			sel[sidx] = items[i]; // 뽑았음
			combination(i + 1, sidx + 1);
		}
	}
}
