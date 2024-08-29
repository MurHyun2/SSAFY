package com.ssafy.live.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 순열04_비트마스킹 {
	static int[] nums, sel;
	static int N;
	static List<int[]> list = new ArrayList<>();

	public static void main(String[] args) {
		nums = new int[] { 0, 1, 2 };
		N = nums.length;
		sel = new int[N];

		perm(0, 0);

		// 얕은 복사를 하기 떄문에 같은값이 나옴. 깊은 복사로 처리해야된다.
		for (int[] is : list) {
			System.out.println(Arrays.toString(is));
		}
	}

	private static void perm(int idx, int visited) {
//		if (visited == (1 << N) - 1) {
//			System.out.println(Arrays.toString(sel));
//			return;
//		}
		if (idx == N) {
//			System.out.println(Arrays.toString(sel));
			// 얕은 복사를 하기 때문에 마지막 값만 여러번 나옴
//			list.add(sel);
			// 깊은 복사를 했기 때문에 원하는 결과가 list에 저장된다.
			list.add(Arrays.copyOf(sel, 3));
			return;
		}

		for (int i = 0; i < N; i++) {
			if ((visited & (1 << i)) == 0) {
				sel[idx] = nums[i];
				perm(idx + 1, visited | (1 << i));
			}
		}
	}
}
