package com.ssafy.algo.swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5215 {

	static int N, L, max;
	static int[][] arr;
	static int[] sel;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/5215.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());

			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			arr = new int[N][2];
			sel = new int[N];
			max = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim());

				for (int j = 0; j < 2; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			subset(0);

			System.out.printf("#%d %d\n", tc, max);
		}
	}

	static void subset(int depth) {
		if (depth == N) {
			int sumScore = 0;
			int sumCal = 0;
			for (int i = 0; i < N; i++) {
				if (sel[i] == 0)
					continue;

				sumScore += arr[i][0];
				sumCal += arr[i][1];
			}

			if (sumCal <= L)
				max = Math.max(max, sumScore);
			return;
		}

		sel[depth] = 0;
		subset(depth + 1);

		sel[depth] = 1;
		subset(depth + 1);
	}
}
