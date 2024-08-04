package com.ssafy.algo.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1210 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/1210.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++) {
			int T = Integer.parseInt(br.readLine());
			
			int[][] map = new int[T][T];

			int[] dr = { 0, 1, 0, -1 };
			int[] dc = { 1, 0, -1, 0 };

			int r = 0;
			int c = 0;
			int idx = 0;
			
			for (int j = 1; j <= T * T; j++) {
				map[r][c] = j;
				
				if(r + dr[idx] < 0 || r + dr[idx] >= T || c + dc[idx] < 0 || c + dc[idx] >= T || map[r + dr[idx]][c + dc[idx]] != 0)
					idx = (idx + 1) % 4;
				
				r += dr[idx];
				c += dc[idx];
			}

			System.out.println("#" + i);
			
			for (int[] js : map) {
				for (int j : js) {
					System.out.print(j + " ");
				}
				System.out.println();
			}
			
		}
	}
}
