package com.ssafy.offline.daily;

public class Hello_0828 {

	static int N, R;
	static int[] sel;
	static int[] data;

	public static void main(String[] args) {
		N = 5;
		R = 3;
		data = new int[] { 10, 20, 30, 40, 50 };

		// 부분집합
		sel = new int[N];
//		부분집합반복();
//		부분집합재귀(0);
//		부분집합비트마스킹();

		// 조합
		sel = new int[R];
//		조합반복문();
//		조합반복재귀(0, 0);
		조합재귀(0, 0);
	}

	private static void 조합재귀(int depth, int selectIdx) {
		if(selectIdx == R) {
			for (int i = 0; i < R; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}
		
		if(depth == N)
			return;
		
		sel[selectIdx] = data[depth];
		조합재귀(depth + 1, selectIdx + 1);
		
		조합재귀(depth + 1, selectIdx);
		
	}

	private static void 조합반복재귀(int start, int depth) {
		if (depth == R) {
			for (int i = 0; i < R; i++) {
				System.out.print(data[sel[i]] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i < N; i++) {
			sel[depth] = i;
			조합반복재귀(i + 1, depth + 1);
		}
	}

	private static void 조합반복문() {
		for (int i = 0; i <= N - R + 0; i++) {
			for (int j = i + 1; j <= N - R + 1; j++) {
				for (int k = j + 1; k <= N - R + 2; k++) {
					System.out.println(data[i] + " " + data[j] + " " + data[k]);
				}
			}
		}

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
				if (sel[i] == 0)
					continue;

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
						for (int m = 0; m < 2; m++) {
							sel[4] = m;

							for (int n = 0; n < N; n++) {
								if (sel[n] != 0) {
									System.out.print(data[n] + " ");
								}
							}
							System.out.println();
						}
					}
				}

			}

		}
	}
}
