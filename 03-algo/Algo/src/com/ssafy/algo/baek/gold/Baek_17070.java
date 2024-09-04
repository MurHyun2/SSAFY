package com.ssafy.algo.baek.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_17070 {

	static int N, cnt;
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine().trim());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());

			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 입력 끝

		cnt = 0;

		bfs(0, 1, 0);

		System.out.println(cnt);
	}

	private static void bfs(int r, int c, int status) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c, status });

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int nr = now[0];
			int nc = now[1];
			int ns = now[2];

			if (nr == N - 1 && nc == N - 1) {
				cnt++;
				continue;
			}
			int dr = nr + 1;
			int dc = nc + 1;

			// 0 : 가로, 1 : 세로, 2 : 대각
			if (ns == 0 || ns == 2) {
				if (dc < N && arr[nr][dc] == 0) {
					q.add(new int[] { nr, dc, 0 });
				}
			}

			if (ns == 1 || ns == 2) {
				if (dr < N && arr[dr][nc] == 0) {
					q.add(new int[] { dr, nc, 1 });
				}
			}

			if (dr < N && dc < N && arr[dr][nc] == 0 && arr[nr][dc] == 0 && arr[dr][dc] == 0) {
				q.add(new int[] { dr, dc, 2 });
			}
		}
	}
}
