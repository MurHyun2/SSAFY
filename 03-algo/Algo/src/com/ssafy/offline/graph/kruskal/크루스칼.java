package com.ssafy.offline.graph.kruskal;

import java.util.Arrays;
import java.util.Scanner;

public class 크루스칼 {

	static int V, E;
	static int[] parents;

	static class Edge {
		int from, to, weight;

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		V = sc.nextInt();
		E = sc.nextInt();
		parents = new int[V];
		Edge[] edgeList = new Edge[E];

		for (int i = 0; i < E; i++) {
			edgeList[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}

		Arrays.sort(edgeList, (o1, o2) -> o1.weight - o2.weight);

		int cnt = 0; // 선택된 간선의 수
		int sum = 0;
		make();

		for (Edge e : edgeList) {
			if (!union(e.from, e.to))
				continue;
			
			sum += e.weight;

			if (++cnt == V - 1)
				break;
		}

		System.out.println(sum);
	}

	private static boolean union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);

		if (rootX == rootY)
			return false;

		parents[rootY] = rootX;
		return true;
	}

	private static int find(int x) {
		if (parents[x] != x) {
			parents[x] = find(parents[x]);
		}

		return parents[x];
	}

	private static void make() {
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}

	static String input = "7 11\r\n" + "0 1 32\r\n" + "0 2 31\r\n" + "0 5 60\r\n" + "0 6 51\r\n" + "1 2 21\r\n"
			+ "2 4 46\r\n" + "2 6 25\r\n" + "3 4 34\r\n" + "3 5 18\r\n" + "4 5 40\r\n" + "4 6 51";
}
