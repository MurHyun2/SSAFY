package com.ssafy.algo.baek.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	입력 범위 1 <= M <= 8
	1부터 N까지 중복없이 M개를 고르는 수열
	N개의 숫자들을 M개 까지의 경우의 수를 모두 출력
	dfs 넣고 백트래킹으로 출력
*/
public class Baek_15649 {

	static int N, M;
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	static void dfs(int lvl) {
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[lvl] = i + 1;
				dfs(lvl + 1);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		visited = new boolean[N];

		dfs(0);
	}
}
