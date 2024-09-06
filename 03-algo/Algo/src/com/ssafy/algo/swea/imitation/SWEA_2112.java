package com.ssafy.algo.swea.imitation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_2112 {

	static int D, W, K, min;
	static int[][] arr;
	static boolean[][] visited;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/2112.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());

			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[D][W];

			for (int r = 0; r < D; r++) {
				st = new StringTokenizer(br.readLine().trim());

				for (int c = 0; c < W; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			// 입력 끝

			min = Integer.MAX_VALUE;

			makeFilm(0, 0);

			sb.append("#" + tc + " " + min);
			sb.append("\n");
		}

		System.out.println(sb);
	}

	private static void makeFilm(int idx, int cnt) {
		if (min < cnt)
			return;

		if (idx == D) {
			if (isOk())
				min = Math.min(min, cnt);

			return;
		}

		makeFilm(idx + 1, cnt);

		int[] tmp = new int[W];

		for (int i = 0; i < W; i++)
			tmp[i] = arr[idx][i];

		yak(idx, 0);
		makeFilm(idx + 1, cnt + 1);

		yak(idx, 1);
		makeFilm(idx + 1, cnt + 1);

		for (int i = 0; i < W; i++)
			arr[idx][i] = tmp[i];
	}

	private static void yak(int r, int drug) {
		for (int i = 0; i < W; i++)
			arr[r][i] = drug;
	}

	private static boolean isOk() {
		for (int c = 0; c < W; c++) {
			boolean flag = false;
			int cnt = 1;

			for (int r = 1; r < D; r++) {
				if (arr[r][c] == arr[r - 1][c])
					cnt++;
				else
					cnt = 1;

				if (cnt >= K) {
					flag = true;
					break;
				}
			}

			if (!flag)
				return false;
		}

		return true;
	}
}
