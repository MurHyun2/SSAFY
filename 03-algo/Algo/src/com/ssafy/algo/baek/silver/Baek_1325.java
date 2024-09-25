package com.ssafy.algo.baek.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baek_1325 {

	static int N, M;
	static List<Integer>[] adj;
	static int[] hackingCount;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N + 1];
		hackingCount = new int[N + 1];

		for (int i = 1; i <= N; i++)
			adj[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			adj[a].add(b);
		} // 입력 끝

		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			dfs(i);
		}

		int max = 0;

		for (int i : hackingCount)
			max = Math.max(max, i);

		for (int i = 1; i <= N; i++)
			if (hackingCount[i] == max)
				sb.append(i).append(" ");

		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void dfs(int n) {
		visited[n] = true;

		for (int i : adj[n]) {
			if (!visited[i]) {
				hackingCount[i]++;
				dfs(i);
			}
		}
	}
}
