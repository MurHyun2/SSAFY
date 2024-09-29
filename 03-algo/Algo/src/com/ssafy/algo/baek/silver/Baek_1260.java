package com.ssafy.algo.baek.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_1260 {

	static StringBuilder sb = new StringBuilder();
	static int N, M, V;
	static int[][] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[a][b] = arr[b][a] = 1;
		} // 입력 끝

		visited = new boolean[N + 1];
		dfs(V);
		sb.append("\n");

		visited = new boolean[N + 1];
		bfs(V);

		System.out.println(sb.toString());
	}

	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;

		while (!q.isEmpty()) {
			int now = q.poll();
			sb.append(now).append(" ");

			for (int i = 1; i <= N; i++) {
				if (visited[i] || arr[now][i] == 0)
					continue;

				visited[i] = true;
				q.add(i);
			}
		}
	}

	private static void dfs(int node) {
		visited[node] = true;
		sb.append(node).append(" ");

		for (int i = 1; i <= N; i++) {
			if (visited[i] || arr[node][i] == 0)
				continue;

			dfs(i);
		}
	}
}
