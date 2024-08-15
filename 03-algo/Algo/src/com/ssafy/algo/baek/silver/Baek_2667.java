package com.ssafy.algo.baek.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Baek_2667 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int[][] map = new int[T][T];

		for (int i = 0; i < T; i++) {
			String str = br.readLine().trim();
			char[] c = str.toCharArray();

			for (int j = 0; j < T; j++) {
				map[i][j] = c[j] - '0';
			}

		}
		// 입력

		List<Integer> list = new ArrayList<>();

		int[] dr = { 1, -1, 0, 0 };
		int[] dc = { 0, 0, 1, -1 };

		for (int r = 0; r < T; r++) {

			for (int c = 0; c < T; c++) {
				int sum = 0;
				int x = r;
				int y = c;

				while (map[r][c] == 1) {
					map[r][c] = 0;
					for (int i = 0; i < 4; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];

						if (nr >= 0 && nr < T && nc >= 0 && nc < T && map[nr][nc] == 1) {
							map[nr][nc] = 0;
							sum++;
							r = nr;
							c = nc;
						}
					}
				}

				if (sum != 0)
					list.add(sum);
				
				r = x;
				y = c;

			}

		}

		System.out.println(list.size());
	}
}
