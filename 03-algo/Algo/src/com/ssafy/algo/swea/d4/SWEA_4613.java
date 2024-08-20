package com.ssafy.algo.swea.d4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_4613 {

	static int T, N, M;
	static char[][] arr;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/4613.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new char[N][M];
			min = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				arr[i] = br.readLine().toCharArray();
			}

			// 완전탐색 시작

			int wCnt = 0;
			int bCnt;
			int rCnt;

			for (int i = 0; i < N - 2; i++) {
				wCnt += toColor('W', i);
				bCnt = 0;

				for (int j = i + 1; j < N - 1; j++) {
					bCnt += toColor('B', j);
					rCnt = 0;

					for (int k = j + 1; k < N; k++)
						rCnt += toColor('R', k);

					min = Math.min(min, wCnt + bCnt + rCnt);
				}

			}

			bw.append("#" + tc + " " + min);
			bw.newLine();
		}

		bw.flush();
		bw.close();
	}

	// 하나의 행에 대해 색칠해야될 개수 반환
	static int toColor(char color, int r) {
		int cnt = 0;

		for (int c = 0; c < M; c++) {
			if (arr[r][c] != color)
				cnt++;
		}

		return cnt;
	}
}
