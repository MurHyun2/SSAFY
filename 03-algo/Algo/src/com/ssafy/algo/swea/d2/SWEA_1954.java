package com.ssafy.algo.swea.d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1954 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/1954.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];

			int[] dr = { 0, 1, 0, -1 };
			int[] dc = { 1, 0, -1, 0 };
			int r = 0;
			int c = 0;
			int idx = 0;

			for (int j = 1; j <= N * N; j++) {
				map[r][c] = j;

				int nr = r + dr[idx];
				int nc = c + dc[idx];

				if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] != 0)
					idx = (idx + 1) % 4;

				r += dr[idx];
				c += dc[idx];
			}

			System.out.println("#" + i);
			
			for (int[] js : map) {
				for (int j : js) {
					System.out.print(j + " ");
				}
				
				System.out.println();
			}
			
		}
	}
}
