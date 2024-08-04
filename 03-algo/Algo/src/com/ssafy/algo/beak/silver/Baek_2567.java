package com.ssafy.algo.beak.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2567 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int[][] map = new int[100][100];

		// 배열에 색종이가 붙은 곳을 1로 초기화.
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int dr = Integer.parseInt(st.nextToken());
			int dc = Integer.parseInt(st.nextToken());

			for (int r = dr; r < dr + 10; r++) {

				for (int c = dc; c < dc + 10; c++) {
					map[r][c] = 1;
				}
				
			}
			
		}

		// 사방탐색 
		int result = 0;

		int dx[] = { 1, -1, 0, 0 };
		int dy[] = { 0, 0, 1, -1 };
		
		for (int r = 0; r < 100; r++) {
			
			for (int c = 0; c < 100; c++) {
				if(map[r][c] == 1) {
					
					for (int i = 0; i < 4; i++) {
						int nr = r + dx[i];
						int nc = c + dy[i];
						
						if(nr < 0 || nc < 0 || nr >= 100 || nc >= 100 || map[nr][nc] == 0)
							result++;
					}
					
				}
			}
			
		}

		System.out.println(result);
	}

}
