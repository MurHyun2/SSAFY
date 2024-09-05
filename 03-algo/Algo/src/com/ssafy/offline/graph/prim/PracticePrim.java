package com.ssafy.offline.graph.prim;

import java.util.Arrays;
import java.util.Scanner;

public class PracticePrim {

	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		int V = sc.nextInt();
		int E = sc.nextInt();
		int[][] adj = new int[V][V];
		
		
		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();

			adj[A][B] = adj[B][A] = W;
		}

		int[] P = new int[V]; // 부모
		int[] D = new int[V]; // 최소비용
		boolean[] v = new boolean[V]; // 신장트리 포함 여부

		Arrays.fill(P, -1);
		Arrays.fill(D, INF);

		D[0] = 0; // 시작점
		int ans = 0;

		for (int i = 0; i < V; i++) {
			// 최소인 것 찾기
			int min = INF;
			int idx = -1;

			for (int j = 0; j < V; j++) {
				if (!v[j] && D[j] < min) {
					min = D[j];
					idx = j;
				}
			}
			
			v[idx] = true;
			ans += min;

			for (int j = 0; j < V; j++) {
				if (!v[j] && adj[idx][j] != 0 && adj[idx][j] < D[j]) {
					D[j] = adj[idx][j];
					P[j] = idx;
				}
			}
		}
		System.out.println(ans);
	}

	static String input = "7 11\r\n" + "0 1 32\r\n" + "0 2 31\r\n" + "0 5 60\r\n" + "0 6 51\r\n" + "1 2 21\r\n"
			+ "2 4 46\r\n" + "2 6 25\r\n" + "3 4 34\r\n" + "3 5 18\r\n" + "4 5 40\r\n" + "4 6 51\r\n" + "";
}
