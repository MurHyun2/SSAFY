package com.ssafy.algo.baek.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_15652 {
	static int N, M;
	static int[] arr;
	static boolean visited[];
	static StringBuilder sb;

	static void dupliComb(int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]).append(" ");
			}

			sb.append("\n");
			visited[arr[0]] = true;
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				arr[depth] = i;
				dupliComb(depth + 1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		visited = new boolean[N + 1];

		dupliComb(0);

		System.out.println(sb);
	}
}
