package com.ssafy.algo.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2001 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];

			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());

				for (int k = 0; k < N; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
				}
			}

			int result = maxKill(map);
			System.out.println("#" + i + " " + result);
		}
	}

	static int maxKill(int[][] map) {
		int max = 0;
		int n = map.length;

		// 팔방탐색으로 값 구하기
		int[] dr = { 0, 1, 1, 1, 0, -1, -1, -1 };
		int[] dc = { 1, 1, 0, -1, -1, -1, 0, 1 };

		for (int r = 0; r < n; r++) {
			
			for (int c = 0; c < n; c++) {
				int count = map[r][c];
				
				for (int k = 0; k < 8; k++) {
					int nr = r + dr[k];
					int nc = c + dc[k];
					
					if(nr >= 0 && nr < n && nc >= 0 && nc < n)
						count += map[nr][nc];
				}
				
				if(max < count)
					max = count;

			}
			
		}

		return max;
	}
}
