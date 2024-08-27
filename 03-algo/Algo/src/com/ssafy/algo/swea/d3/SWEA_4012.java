package com.ssafy.algo.swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4012 {

	static int N, R, avg;
	static int[][] arr;
	static int[][] sel;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/4012.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());

			N = Integer.parseInt(st.nextToken());
			R = 2;
			arr = new int[N][N];
			sel = new int[N][N];
			avg = Integer.MAX_VALUE;

			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine().trim());

				for (int c = 0; c < N; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			comb();

//			System.out.printf("#%d %d\n", tc, cnt);
		}

	}

	static void comb() {
		for (int i = 0; i <= N - R + 0; i++) {

			for (int j = i + 1; j <= N - R + 1; j++) {
				int sum = 0;
				sum += arr[i][j];
				sum += arr[j][i];
				sel[i][j] = sum;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (sel[i][j] != 0) {
					
				}
			}
		}
	}
}
