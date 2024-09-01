package com.ssafy.offline.daily;

import java.util.Arrays;

public class Hello_0831 {
	static int N, R;
	static int[] arr, sel;
	static boolean[] visited;

	public static void main(String[] args) {
		arr = new int[] { 10, 20, 30, 40 };
		N = 4;
		R = 2;

		sel = new int[R];
//		조합
//		조합반복문();
//		조합반복재귀(0,0);
//		조합재귀(0, 0);

		sel = new int[N];
//		부분집합
//		부분집합반복문();
//		부분집합재귀(0);
//		부분집합비트마스킹();

		sel = new int[R];
		visited = new boolean[N];
//		순열 
//		순열반복문();
		순열방문체크(0);

	}

	private static void 순열방문체크(int depth) {
		if (depth == R) {
			for (int i = 0; i < R; i++) {
				System.out.print(sel[i] + " ");
			}

			System.out.println();
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				sel[depth] = arr[i];
				순열방문체크(depth + 1);
				visited[i] = false;
			}
		}
	}

	private static void 순열반복문() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i != j) {
					System.out.println(arr[i] + " " + arr[j]);
				}
			}
		}
	}

	private static void 부분집합비트마스킹() {
		for (int i = 0; i < (1 << N); i++) {
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) != 0) {
					System.out.print(arr[j] + " ");
				}
			}

			System.out.println();
		}
	}

	private static void 부분집합재귀(int idx) {
		if (idx == N) {
			for (int i = 0; i < N; i++) {
				if (sel[i] != 0)
					System.out.print(arr[i] + " ");
			}

			System.out.println();
			return;
		}

		sel[idx] = 0;
		부분집합재귀(idx + 1);

		sel[idx] = 1;
		부분집합재귀(idx + 1);
	}

	private static void 부분집합반복문() {
		for (int i = 0; i < 2; i++) {
			sel[0] = i;

			for (int j = 0; j < 2; j++) {
				sel[1] = j;

				for (int k = 0; k < 2; k++) {
					sel[2] = k;

					for (int l = 0; l < 2; l++) {
						sel[3] = l;

						for (int m = 0; m < N; m++) {
							if (sel[m] != 0)
								System.out.print(arr[m] + " ");
						}

						System.out.println();
					}
				}
			}
		}
	}

	private static void 조합재귀(int idx, int selectIdx) {
		if (selectIdx == R) {
			for (int i = 0; i < R; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}

		if (idx == N)
			return;

		sel[selectIdx] = arr[idx];
		조합재귀(idx + 1, selectIdx + 1);
		조합재귀(idx + 1, selectIdx);
	}

	private static void 조합반복재귀(int start, int depth) {
		if (depth == R) {
			for (int i = 0; i < R; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i < N; i++) {
			sel[depth] = arr[i];
			조합반복재귀(i + 1, depth + 1);
		}
	}

	private static void 조합반복문() {
		for (int i = 0; i <= N - R; i++) {
			for (int j = i + 1; j <= N - R + 1; j++) {
				System.out.println(arr[i] + " " + arr[j]);
			}
		}
	}

}
