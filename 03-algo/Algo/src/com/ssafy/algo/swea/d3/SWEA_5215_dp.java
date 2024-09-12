package com.ssafy.algo.swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5215_dp {

	static int N, L, max;
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/5215.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());

		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine().trim());

			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			arr = new int[N][2];
			max = 0;

			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine().trim());
				arr[j][0] = Integer.parseInt(st.nextToken());
				arr[j][1] = Integer.parseInt(st.nextToken());
			}
			// 입력 끝

			dp();

			System.out.printf("#%d %d\n", i, max);
		}
	}

	private static void dp() {

	}
}
