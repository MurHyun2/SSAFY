package com.ssafy.algo.baek.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2630 {

	static int N, wCnt, bCnt;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine().trim());
		arr = new int[N][N];
		wCnt = 0;
		bCnt = 0;

		int sum = 0;

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine().trim());

			for (int c = 0; c < N; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());

				if (arr[r][c] == 1)
					sum++;
			}
		}
		// 입력 끝

		if (sum == N * N) {
			System.out.println(0);
			System.out.println(1);
			return;
		} else if (sum == 0) {
			System.out.println(1);
			System.out.println(0);
			return;
		}

		partition(0, 0, N);

		sb.append(wCnt + "\n" + bCnt);

		System.out.println(sb);
	}

	private static void partition(int r, int c, int size) {
		if (check(r, c, size)) {
			if (arr[r][c] == 0)
				wCnt++;
			else
				bCnt++;

			return;
		}

		int half = size / 2;

		partition(r, c, half); // 2
		partition(r, c + half, half); // 1
		partition(r + half, c, half); // 3
		partition(r + half, c + half, half); // 4
	}

	private static boolean check(int r, int c, int size) {
		int color = arr[r][c];

		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (arr[i][j] != color)
					return false;
			}
		}

		return true;
	}
}
