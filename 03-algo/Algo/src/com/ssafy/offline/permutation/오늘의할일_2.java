package com.ssafy.offline.permutation;

import java.util.Iterator;

public class 오늘의할일_2 {

	static int N, R;
	static int[] sel;
	static int[] data;

	public static void main(String[] args) {
		N = 4;
		R = 2;
		data = new int[] { 10, 20, 30, 40 };

		sel = new int[N];
//		부분집합반복();
//		부분집합재귀(0);

//		부분집합비트마스킹();

//		조합반복문();

		sel = new int[R];
//		조합반복재귀(0, 0);
		조합재귀(0, 0);
	}

	private static void 조합재귀(int depth, int selectIndex) {
		if (selectIndex == R) {
			for (int i = 0; i < R; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}

		if (depth == N)
			return;

		sel[selectIndex] = data[depth];
		조합재귀(depth + 1, selectIndex + 1);

		조합재귀(depth + 1, selectIndex);
	}

	private static void 조합반복재귀(int start, int depth) {
		if (depth == R) {
			for (int i = 0; i < R; i++) {
				System.out.print(data[sel[i]] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i < N - R + depth; i++) {
			sel[depth] = i;
			조합반복재귀(i + 1, depth + 1);
		}

	}

	private static void 조합반복문() {
		for (int i = 0; i < N - R + 0; i++) {
			for (int j = i + 1; j < N - R + 1; j++) {
				System.out.println(data[i] + " " + data[j]);
			}
		}
	}

	private static void 부분집합비트마스킹() {
		for (int i = 0; i < (1 << N); i++) {
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) != 0)
					System.out.print(data[j] + " ");
			}

			System.out.println();
		}
	}

	private static void 부분집합재귀(int idx) {
		if (idx == N) {
			for (int i = 0; i < N; i++) {
				if (sel[i] != 0)
					System.out.print(data[i] + " ");
			}
			System.out.println();
			return;
		}

		sel[idx] = 0;
		부분집합재귀(idx + 1);

		sel[idx] = 1;
		부분집합재귀(idx + 1);
	}

	private static void 부분집합반복() {
		for (int i = 0; i < 2; i++) {
			sel[0] = i;
			for (int j = 0; j < 2; j++) {
				sel[1] = j;
				for (int k = 0; k < 2; k++) {
					sel[2] = k;
					for (int l = 0; l < 2; l++) {
						sel[3] = l;

						for (int n = 0; n < N; n++) {
							if (sel[n] != 0)
								System.out.print(data[n] + " ");
						}
						System.out.println();
					}
				}
			}
		}

	}

}
