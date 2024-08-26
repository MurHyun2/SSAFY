package com.ssafy.algo.baek.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_15649 {

	static int N, M;
	static int[] out;
	static boolean[] visited;
	static StringBuilder sb;

	static void permutation(int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++)
				sb.append(out[i]).append(" ");

			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				out[depth] = i;
				permutation(depth + 1);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N + 1];
		out = new int[N];

		permutation(0);

		System.out.println(sb);
	}
}
