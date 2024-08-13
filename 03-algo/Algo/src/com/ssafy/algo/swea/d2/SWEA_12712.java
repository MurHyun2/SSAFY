package com.ssafy.algo.swea.d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_12712 {

	static int n, m;
	static int[][] arr;
	
	static int max;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int[] xdr = { -1, -1, 1, 1 };
	static int[] xdc = { 1, -1, -1, 1 };

	static void maxKill() {
		max = 0;
		
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				int sum = arr[r][c];
				int sum2 = arr[r][c];
				int nr, nc, nr2, nc2;

				for (int i = 0; i < 4; i++) {
					for (int j = 1; j < m; j++) {
						nr = r + dr[i] * j;
						nc = c + dc[i] * j;

						nr2 = r + xdr[i] * j;
						nc2 = c + xdc[i] * j;

						if (nr >= 0 && nr < n && nc >= 0 && nc < n)
							sum += arr[nr][nc];
						if (nr2 >= 0 && nr2 < n && nc2 >= 0 && nc2 < n) {
							sum2 += arr[nr2][nc2];
						}
					}
					max = Math.max(max, Math.max(sum, sum2));
				}
				
			}
			
		}
		
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/12712.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new int[n][n];

			for (int r = 0; r < n; r++) {
				st = new StringTokenizer(br.readLine().trim());

				for (int c = 0; c < n; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			maxKill();
			
			System.out.printf("#%d %d\n", tc, max);
		}

	}
}
