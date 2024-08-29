package com.ssafy.live.permutation;

import java.util.Arrays;

public class 순열03_방문체크 {
	static int[] nums, sel;
	static int N;
	// 추가적인 공간 필요
	static boolean[] visited;

	public static void main(String[] args) {
		nums = new int[] { 0, 1, 2 };
		N = nums.length;
		visited = new boolean[N];
		sel = new int[N];

		perm(0);
	}

	private static void perm(int idx) {
		if (idx == N) {
			System.out.println(Arrays.toString(sel));
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				sel[idx] = nums[i];
				perm(idx + 1);
				visited[i] = false;
			}
		}
	}
}
