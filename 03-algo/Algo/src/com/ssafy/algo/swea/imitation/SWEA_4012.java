package com.ssafy.algo.swea.imitation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_4012 {

	static int N, min;
	static int[][] arr;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/4012.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());

			N = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			visited = new boolean[N];
			min = Integer.MAX_VALUE;

			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine().trim());

				for (int c = 0; c < N; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			comb(0, 0);

			bw.append("#" + tc + " " + min);
			bw.newLine();
		}

		bw.flush();
		bw.close();
	}

	static void comb(int start, int depth) {
		if (depth == N / 2) {
			calMin();
			return;
		}

		for (int i = start; i < N; i++) {
			visited[i] = true;
			comb(i + 1, depth + 1);
			visited[i] = false;
		}
	}

	static void calMin() {
		int a = 0;
		int b = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i] && visited[j]) {
					a += arr[i][j];
				} else if (!visited[i] && !visited[j]) {
					b += arr[i][j];
				}
			}
		}

		min = Math.min(min, Math.abs(a - b));
	}
}
