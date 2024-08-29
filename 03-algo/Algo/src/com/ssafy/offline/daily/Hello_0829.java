package com.ssafy.offline.daily;

public class Hello_0829 {

	static int N, R;
	static int[] sel;
	static int[] data;

	public static void main(String[] args) {
		N = 4;
		R = 2;
		data = new int[] { 10, 20, 30, 40 };

//		sel = new int[R];
//		조합반복();
//		조합반복재귀(0, 0);
//		조합재귀(0, 0);

		sel = new int[N];
//		부분집합반복();
//		부분집합재귀(0);
		부분집합비트마스킹();

	}

	private static void 부분집합비트마스킹() {
		for (int i = 0; i < (1 << N); i++) {
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) != 0) {
					System.out.print(data[j] + " ");
				}
			}
			System.out.println();
		}
	}

	private static void 부분집합재귀(int depth) {
		if (depth == N) {
			for (int i = 0; i < N; i++) {
				if (sel[i] != 0)
					System.out.print(data[i] + " ");
			}
			System.out.println();
			return;
		}

		sel[depth] = 0;
		부분집합재귀(depth + 1);

		sel[depth] = 1;
		부분집합재귀(depth + 1);
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

						for (int m = 0; m < N; m++) {
							if (sel[m] != 0)
								System.out.print(data[m] + " ");
						}
						System.out.println();

					}
				}
			}

		}
	}

	private static void 조합재귀(int selectIdx, int depth) {
		if (selectIdx == R) {
			for (int i = 0; i < R; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}

		if (depth == N)
			return;

		sel[selectIdx] = data[depth];
		조합재귀(selectIdx + 1, depth + 1);
		조합재귀(selectIdx, depth + 1);
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
			sel[depth] = data[i];
			조합반복재귀(i + 1, depth + 1);
		}
	}

	private static void 조합반복() {
		for (int i = 0; i <= N - R; i++) {
			for (int j = i + 1; j <= N - R + 1; j++) {
				System.out.println(data[i] + " " + data[j]);
			}
		}
	}
}
