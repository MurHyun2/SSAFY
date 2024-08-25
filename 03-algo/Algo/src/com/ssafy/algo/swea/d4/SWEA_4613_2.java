package com.ssafy.algo.swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4613_2 {
	static int N, M;
	static char arr[][];
	static int min;

	static int toColor(char color, int r) {
		int cnt = 0;

		for (int c = 0; c < M; c++) {
			if (arr[r][c] != color)
				cnt++;
		}

		return cnt;
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/4613.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new char[N][M];

			for (int r = 0; r < N; r++) {
				char[] ch = br.readLine().toCharArray();

				for (int c = 0; c < M; c++) {
					arr[r][c] = ch[c];
				}
			}

			int wCnt = 0;
			int bCnt;
			int rCnt;
			min = Integer.MAX_VALUE;

			for (int i = 0; i < N - 2; i++) {
				wCnt += toColor('W', i);
				bCnt = 0;

				for (int j = i + 1; j < N - 1; j++) {
					bCnt += toColor('B', j);
					rCnt = 0;

					for (int k = j + 1; k < N; k++) {
						rCnt += toColor('R', k);
					}

					min = Math.min(min, wCnt + bCnt + rCnt);
				}
			}

			System.out.printf("#%d %d\n", tc, min);
		}
	}

}