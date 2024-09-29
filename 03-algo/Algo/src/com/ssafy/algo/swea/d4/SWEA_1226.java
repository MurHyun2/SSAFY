package com.ssafy.algo.swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_1226 {

	static StringBuilder sb = new StringBuilder();
	static int[][] arr;
	static int[] startIdx;
	static int[] goalIdx;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/1226.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = 10;

		for (int tc = 1; tc <= T; tc++) {
			br.readLine();
			arr = new int[16][16];

			startIdx = new int[2];
			goalIdx = new int[2];

			for (int r = 0; r < 16; r++) {
				char[] ch = br.readLine().toCharArray();

				for (int c = 0; c < 16; c++) {
					arr[r][c] = ch[c] - '0';

					if (arr[r][c] == 2) {
						startIdx[0] = r;
						startIdx[1] = c;
					}

					if (arr[r][c] == 3) {
						goalIdx[0] = r;
						goalIdx[1] = c;
					}
				}

			}

			sb.append("#").append(tc).append(" ").append(bfs()).append("\n");
		}

		// 출력
		System.out.println(sb.toString());
	}

	private static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(startIdx);

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];

			if (x == goalIdx[0] && y == goalIdx[1])
				return 1;

			for (int i = 0; i < 4; i++) {
				int nr = x + dr[i];
				int nc = y + dc[i];

				if (nr < 0 || nc < 0 || nr >= 16 || nc >= 16 || arr[nr][nc] == 1)
					continue;

				arr[nr][nc] = 1;
				q.add(new int[] { nr, nc });
			}
		}

		return 0;
	}
}