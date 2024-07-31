package com.ssafy.live.day03;

import java.util.Arrays;

public class Array03_연습문제01 {
	public static void main(String[] args) {

		int N = 5;
		int[][] board = new int[N][N];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				board[r][c] = (int) (Math.random() * 100);
			}
		}

		System.out.println(Arrays.deepToString(board));

		// 25개 각 요소에 대해서 이웃한 요소와의 차이의 총합을 구하는 것
		int[][] sum = new int[N][N];

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = r + dc[d];
					if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
						sum[r][c] += Math.abs(board[nr][nc] - board[r][c]);
					}
				}

//				if (r - 1 >= 0)
//					sum[r][c] += Math.abs(board[r - 1][c] - board[r][c]);
//				if (r + 1 < N)
//					sum[r][c] += Math.abs(board[r + 1][c] - board[r][c]);
//				if (c - 1 >= 0)
//					sum[r][c] += Math.abs(board[r][c - 1] - board[r][c]);
//				if (c + 1 < N)
//					sum[r][c] += Math.abs(board[r][c + 1] - board[r][c]);
			}
		}
		System.out.println(Arrays.deepToString(sum));
	}
}
