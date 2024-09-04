package com.ssafy.algo.swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3289 {

	static int A, B;
	static int[] arr;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/3289.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			st = new StringTokenizer(br.readLine().trim());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			arr = new int[A + 1];
			make();

			for (int i = 0; i < B; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int op = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				switch (op) {
				case 0: {
					union(x, y);
					break;
				}

				case 1: {
					if (find(x) == find(y)) {
						sb.append("1");
					} else {
						sb.append("0");
					}
				}
				}
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	private static int find(int x) {
		if (arr[x] != x) {
			arr[x] = find(arr[x]);
		}
		return arr[x];
	}

	private static boolean union(int x, int y) {
		if (find(x) == find(y)) {
			return false;
		}

		arr[find(y)] = find(x);
		return true;
	}

	private static void make() {
		for (int i = 1; i <= A; i++) {
			arr[i] = i;
		}
	}
}