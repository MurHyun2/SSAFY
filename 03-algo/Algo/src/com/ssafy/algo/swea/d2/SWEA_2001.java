package com.ssafy.algo.swea.d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2001 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/2001.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];

			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());

				for (int k = 0; k < N; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
				}
			}

			int result = maxKill(map, M);
			System.out.println("#" + i + " " + result);
		}
	}

	static int maxKill(int[][] map, int M) {
		int max = 0;

		for (int r = 0; r <= map.length - M; r++) {
			for (int c = 0; c <= map[r].length - M; c++) {
				int sum = 0;
				
				for (int x = r; x < r + M; x++) {
					for (int y = c; y < c + M; y++) {
						sum += map[x][y];
					}
				}
				
				max = Math.max(max, sum);
			}
		}

		return max;
	}
}
