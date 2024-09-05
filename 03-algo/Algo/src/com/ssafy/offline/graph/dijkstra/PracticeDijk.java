package com.ssafy.offline.graph.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PracticeDijk {

	static class Node {
		int V, W;

		public Node(int v, int w) {
			super();
			V = v;
			W = w;
		}

	}

	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		int V = sc.nextInt();
		int E = sc.nextInt();
//		int[][] adj = new int[V][V];

		List<Node>[] adj = new ArrayList[V];
		boolean[] v = new boolean[V];

		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			adj[sc.nextInt()].add(new Node(sc.nextInt(), sc.nextInt()));
		}

		int[] D = new int[V];
		Arrays.fill(D, INF);

		D[0] = 0;
		int ans = 0;

		for (int i = 0; i < V; i++) {
			int min = INF;
			int idx = -1;

			for (int j = 0; j < V; j++) {
				if (!v[j] && D[j] < min) {
					min = D[j];
					idx = j;
				}
			}

			if (idx == -1) {
				break;
			}

			v[idx] = true;
			ans += min;

			for (Node node : adj[idx]) {
				if (!v[node.V] && D[node.V] > D[idx] + node.W) {
					D[node.V] = D[idx] + node.W;
				}
			}
		}

		System.out.println("최단 거리 합: " + ans);
		System.out.println("각 노드까지의 최소 거리: " + Arrays.toString(D));

	}

	static String input = "7 11\r\n" + "0 1 32\r\n" + "0 2 31\r\n" + "0 5 60\r\n" + "0 6 51\r\n" + "1 2 21\r\n"
			+ "2 4 46\r\n" + "2 6 25\r\n" + "3 4 34\r\n" + "3 5 18\r\n" + "4 5 40\r\n" + "4 6 51\r\n" + "";
}
