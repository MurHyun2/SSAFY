package com.ssafy.algo.baek.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_10026 {

	static int N, cntNM, cntCB;
	static char[][] arr, arrCB;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine().trim());
		arr = new char[N][N];
		arrCB = new char[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine().trim();
			char[] ch = str.toCharArray();

			for (int j = 0; j < N; j++) {
				arr[i][j] = ch[j];

				if (ch[j] == 'R' || ch[j] == 'G')
					arrCB[i][j] = 'R';
				else
					arrCB[i][j] = ch[j];
			}
		}
		// 입력 끝
		cntNM = cntCB = 0;

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (arr[r][c] != 'V') {
					bfs(r, c, arr[r][c], arr);
					cntNM++;
				}

				if (arrCB[r][c] != 'V') {
					bfs(r, c, arrCB[r][c], arrCB);
					cntCB++;
				}
			}
		}

		System.out.println(cntNM + " " + cntCB);
	}

	private static void bfs(int r, int c, char color, char[][] divideArr) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { r, c });
		divideArr[r][c] = 'V';

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int x = now[0];
			int y = now[1];

			for (int i = 0; i < 4; i++) {
				int nr = x + dr[i];
				int nc = y + dc[i];

				if (nr < 0 || nc < 0 || nr >= N || nc >= N || divideArr[nr][nc] != color)
					continue;

				queue.add(new int[] { nr, nc });
				divideArr[nr][nc] = 'V';
			}
		}
	}
}
