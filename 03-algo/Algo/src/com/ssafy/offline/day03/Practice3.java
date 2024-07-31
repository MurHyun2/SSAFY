package com.ssafy.offline.day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		int[][] map = new int[T][T];

		for (int r = 0; r < T; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int c = 0; c < T; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(maximumNutrition(map));
	}

	static int maximumNutrition(int[][] map) {
		int max = 0;
		int n = map.length;

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		for (int r = 0; r < n; r++) {
			
			for (int c = 0; c < n; c++) {
				int count = map[r][c];
				
				for (int j = 0; j < 4; j++) {
					int nr = r + dr[j];
					int nc = c + dc[j];

					if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
						count += map[nr][nc];
					}
				}
				
				if(max < count)
					max = count;
			}
			
		}

		return max;
	}
}
