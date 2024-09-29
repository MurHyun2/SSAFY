package com.ssafy.offline.daily;

public class Hello_0929 {
	static int N, R;
	static int[] arr, sel;
	static boolean[] visited;

	public static void main(String[] args) {
		arr = new int[] { 10, 20, 30, 40 };
		N = 4;
		R = 2;

		sel = new int[R];
		visited = new boolean[N];

//		perm(0);
//		comb(0, 0);
		subs();

	}

	private static void subs() {
		for (int i = 0; i < (1 << N); i++) {
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) != 0) {
					System.out.print(arr[j] + " ");
				}
			}
			System.out.println();
		}
	}

	private static void comb(int idx, int depth) {
		if (depth == R) {
			for (int i : sel) {
				System.out.print(i + " ");
			}

			System.out.println();
			return;
		}

		for (int i = idx; i < N; i++) {
			sel[depth] = arr[i];
			comb(i + 1, depth + 1);
		}
	}

	private static void perm(int depth) {
		if (depth == R) {
			for (int i : sel) {
				System.out.print(i + " ");
			}

			System.out.println();
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				sel[depth] = arr[i];
				perm(depth + 1);
				visited[i] = false;
			}
		}
	}
}
