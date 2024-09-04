package com.ssafy.algo.swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class SWEA_7465 {

	static int N, M;
	static StringBuilder sb;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/7465.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N + 1];

			make();
			int cnt = 0;

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				if (union(x, y))
					continue;
			}
			
			for (int i = 1; i <= N; i++) {
				if(find(i) == i)
					cnt++;
			}

			sb.append(cnt);
			sb.append("\n");
		}

		System.out.println(sb);
	}

	private static boolean union(int x, int y) {
		int pX = find(x);
		int pY = find(y);

		if (pX == pY)
			return false;

		arr[pY] = pX;
		return true;
	}

	private static int find(int x) {
		if (arr[x] != x) {
			arr[x] = find(arr[x]);
		}

		return arr[x];
	}

	private static void make() {
		for (int i = 1; i <= N; i++) {
			arr[i] = i;
		}
	}
}