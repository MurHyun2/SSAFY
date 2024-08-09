package com.ssafy.algo.beak.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_1260 {

	static StringBuilder sb = new StringBuilder();
	static int[][] arr;
	static boolean[] check;

	static int node, line, start;

	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		node = Integer.parseInt(st.nextToken());
		line = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());

		// 노드들의 연결을 표현하기 위한 2차원 배열 초기화
		arr = new int[node + 1][node + 1];
		// 방문 여부를 기록할 배열 초기화
		check = new boolean[node + 1];

		for (int i = 0; i < line; i++) {
			st = new StringTokenizer(br.readLine().trim());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// 노드 a와 b가 서로 연결되었음을 대칭적으로 기록
			arr[a][b] = arr[b][a] = 1;
		}

		dfs(start);
		sb.append("\n");
		check = new boolean[node + 1];

		bfs(start);

		System.out.println(sb);

	}

	// 깊이 우선 탐색
	static void dfs(int start) {
		// 현재 노드를 방문했으니 check 배열에 기록
		check[start] = true;

		// 마찬가지로 sb에 기록
		sb.append(start + " ");

		// 모든 노드를 검사
		for (int i = 1; i <= node; i++) {
			// 현재 노드와 노드 i 가 연결되어 있고 & 노드를 방문 하지 않았다면 재귀 호출로 반복
			if (arr[start][i] == 1 && !check[i]) {
				dfs(i);
			}
		}

	}

	// 너비 우선 탐색
	static void bfs(int start) {
		// 현재 노드를 방문했으니 check 배열에 기록
		check[start] = true;
		// 현재 노드를 Queue에 추가
		q.add(start);

		// 큐가 빌 때까지 노드를 꺼내 탐색
		while (!q.isEmpty()) {
			// 큐에서 노드를 꺼내 현재 노드로 설정
			start = q.poll();
			// 현재 노드를 sb에 기록
			sb.append(start + " ");

			// 모든 노드를 검사
			for (int i = 1; i <= node; i++) {
				// 현재 노드와 노드 i 가 연결되어 있고 & 노드를 방문 하지 않았다면
				if (arr[start][i] == 1 && !check[i]) {
					// 큐에 노드 추가 & 해당 노드를 방문했다고 기록
					q.add(i);
					check[i] = true;
				}
			}

		}

	}
}
