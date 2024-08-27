package com.ssafy.algo.baek.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baek_2667 {

	static int N, cnt;
	static int[][] map;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int r = 0; r < N; r++) {
			String str = br.readLine().trim();

			for (int c = 0; c < N; c++) {
				map[r][c] = str.charAt(c) - '0';
			}
		}

		List<Integer> arr = new ArrayList<>();

		int result = 0;

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				cnt = 0;
				if (map[r][c] == 1) {
					dfs(r, c);
					arr.add(cnt);
					result++;
				}
			}
		}

		Collections.sort(arr);

		System.out.println(result);

		for (int num : arr) {
			System.out.println(num);
		}

	}

	private static void dfs(int r, int c) {
		map[r][c] = 0;
		cnt += 1;

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr >= 0 && nc >= 0 && nr < N && nc < N && map[nr][nc] == 1) {
				dfs(nr, nc);
			}
		}
	}
}
