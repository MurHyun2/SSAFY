package com.ssafy.algo.baek.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_4179 {

	static int R, C;
	static char[][] arr;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static Queue<int[]> queue = new LinkedList<int[]>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		int startingR = 0;
		int startingC = 0;

		for (int i = 0; i < R; i++) {
			String str = br.readLine().trim();
			char[] ch = str.toCharArray();

			for (int j = 0; j < C; j++) {
				arr[i][j] = ch[j];
				if (arr[i][j] == 'J') {
					startingR = i;
					startingC = j;
				}

				if (arr[i][j] == 'F') {
					queue.add(new int[] { i, j, 1, 0 });
				}
			}
		}
		queue.add(new int[] { startingR, startingC, 1, 1 });
		// 입력 끝

		bfs();
	}

	private static void bfs() {
		int result = 0;
		boolean impossible = true;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int x = now[0];
			int y = now[1];
			int time = now[2];
			int status = now[3];

			if (status == 1) {
				if (x == 0 || y == 0 || x == R - 1 || y == C - 1) {
					impossible = false;
					result = time;
					break;
				}

				for (int i = 0; i < 4; i++) {
					int nr = x + dr[i];
					int nc = y + dc[i];

					if (nr < 0 || nc < 0 || nr >= R || nc >= C || arr[nr][nc] != '.')
						continue;

					queue.add(new int[] { nr, nc, time + 1, status });
					arr[nr][nc] = 'J';
				}
			} else {
				for (int i = 0; i < 4; i++) {
					int nr = x + dr[i];
					int nc = y + dc[i];

					if (nr < 0 || nc < 0 || nr >= R || nc >= C || arr[nr][nc] != '.')
						continue;

					queue.add(new int[] { nr, nc, time + 1, status });
					arr[nr][nc] = 'F';
				}
			}
		}

		if (impossible)
			System.out.println("IMPOSSIBLE");
		else
			System.out.println(result);
	}
}