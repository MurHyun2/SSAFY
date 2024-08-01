package com.ssafy.answer;

import java.util.Scanner;

public class SWEA_파리퇴치_2001_기본연산 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(), t = 0;
		while (t++ < T) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] map = new int[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = sc.nextInt();
				}
			}

			int ans = 0;
			for (int y = 0; y <= N - M; y++) {
				for (int x = 0; x <= N - M; x++) {
					int sum = 0;
					for (int k = 0; k < M; k++) {
						for (int j = 0; j < M; j++) {
							sum += map[y + k][x + j];
						}
					}

					if (ans < sum) {
						ans = sum;
					}
				}
			}
			System.out.printf("#%d %d%n", t, ans);
		}
		sc.close();
	}
}