package com.ssafy.algo.baek.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_2636 {

	static int N, M, cnt;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine().trim());

			for (int c = 0; c < M; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		} // 입력 끝
		
		
		for (int r = 0; r < N; r++) {
			loop : for (int c = 0; c < M; c++) {
				if(arr[r][c] == 1) {
//					bfs(r,c);
					visited[r][c] = true;
					
					for (int i = 0; i < 4; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						
						if(nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc])
							continue;
						
						if(arr[nr][nc] == 0) {
							arr[r][c] = 0;
							continue loop;
						}
					}
				}
			}
		}
		
		for (int[] is : arr) {
			System.out.println(Arrays.toString(is));
		}
	}

	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		
	}
}
