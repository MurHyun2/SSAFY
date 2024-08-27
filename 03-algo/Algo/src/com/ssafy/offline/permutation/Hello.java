package com.ssafy.offline.permutation;

import java.util.Arrays;

public class Hello {

	static int N, R;
	static int[] arr1, arr2, data;

	public static void main(String[] args) {
		N = 4;
		R = 3;
		data = new int[] { 10, 20, 30, 40 };
		arr1 = new int[R];
		arr2 = new int[N];

//		조합반복문();
//		조합반복재귀(0, 0);
//		조합재귀(0, 0);

//		부분집합반복();
//		부분집합재귀(0);
		부분집합비트마스킹();
	}

	private static void 부분집합비트마스킹() {
		for (int i = 0; i < (1 << N); i++) {
			for (int j = 0; j < N; j++) {
				if ((i & 1 << j) != 0) {
					System.out.print(data[j] + " ");
				}
			}
			System.out.println();
		}
	}

	private static void 부분집합재귀(int idx) {
		if (idx == R) {
			for (int i = 0; i < R; i++) {
				if (arr1[i] == 0)
					continue;

				System.out.print(data[i] + " ");
			}
			System.out.println();
			return;
		}

		arr1[idx] = 0;
		부분집합재귀(idx + 1);

		arr1[idx] = 1;
		부분집합재귀(idx + 1);
	}

	private static void 부분집합반복() {
		for (int i = 0; i < 2; i++) {
			arr2[0] = i;
			for (int j = 0; j < 2; j++) {
				arr2[1] = j;
				for (int k = 0; k < 2; k++) {
					arr2[2] = k;
					for (int l = 0; l < 2; l++) {
						arr2[3] = l;

						for (int m = 0; m < N; m++) {
							if (arr2[m] == 0)
								continue;

							System.out.print(data[m] + " ");
						}
						System.out.println();
					}
				}
			}
		}
	}

	private static void 조합반복재귀(int start, int depth) {
		if (depth == R) {
			for (int i = 0; i < R; i++) {
				System.out.print(arr1[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i <= N - R + depth; i++) {
			arr1[depth] = data[i];
			조합반복재귀(i + 1, depth + 1);
		}
	}

	private static void 조합반복문() {
		for (int i = 0; i < N - R + 0; i++) {
			for (int j = 0; j < N - R + 1; j++) {
				for (int k = 0; k < N - R + 2; k++) {
					System.out.printf("%d %d %d\n", data[i], data[j], data[k]);
				}
			}
		}

	}

	private static void 조합재귀(int idx, int selectIndex) {
		if (selectIndex == R) {
			System.out.println(Arrays.toString(arr1));
			return;
		}

		if (idx == N) {
			return;
		}

		arr1[selectIndex] = data[idx];
		조합재귀(idx + 1, selectIndex + 1);

		조합재귀(idx + 1, selectIndex);

	}
}
