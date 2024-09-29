package com.ssafy.algo.swea.imitation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_4012_2 {

	static int N, min;
	static int[][] arr;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/4012.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			arr = new int[N][N];
			visited = new boolean[N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim());

				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 입력 끝

			min = Integer.MAX_VALUE;

			comb(0, 0);

			System.out.printf("#%d %d\n", tc, min);
		}
	}

	private static void comb(int idx, int cnt) {
		if (cnt == N / 2) {
			min = Math.min(min, cal());
			return;
		}

		for (int i = idx; i < N; i++) {
			visited[i] = true;
			comb(i + 1, cnt + 1);
			visited[i] = false;
		}
	}

	private static int cal() {
		int x = 0;
		int y = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;

				if (visited[i] && visited[j])
					x += arr[i][j];
				else if (!visited[i] && !visited[j])
					y += arr[i][j];
			}
		}

		return Math.abs(x - y);
	}
}
