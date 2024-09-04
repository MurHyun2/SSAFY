package com.ssafy.algo.swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1251 {

	static int N;
	static double E;
	static StringBuilder sb;
	static int[] parents;

	static class Node {
		int x, y;

		public Node() {
			super();
		}

	}

	static class Edge {
		int from, to;
		double dist;

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", dist=" + dist + "]";
		}

		public Edge(int from, int to, double dist) {
			super();
			this.from = from;
			this.to = to;
			this.dist = dist;
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/1251.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());

			Node[] nodes = new Node[N];
			for (int i = 0; i < N; i++) {
				nodes[i] = new Node();
			}
			parents = new int[N];

			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine().trim());

				for (int j = 0; j < N; j++) {
					int input = Integer.parseInt(st.nextToken());

					if (i == 0) {
						nodes[j].x = input;
					} else {
						nodes[j].y = input;
					}
				}
			}

			E = Double.parseDouble(br.readLine().trim());
			// 입력 끝

			List<Edge> edges = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					edges.add(new Edge(i, j,
							Math.pow(nodes[i].x - nodes[j].x, 2) + Math.pow(nodes[i].y - nodes[j].y, 2)));
				}
			}

			Collections.sort(edges, (o1, o2) -> Double.compare(o1.dist, o2.dist));

			make();

			int cnt = 0;
			double sum = 0;

			for (Edge e : edges) {
				if (!union(e.from, e.to))
					continue;

				sum += E * e.dist;

				if (++cnt == N - 1)
					break;
			}

			sb.append("#").append(tc).append(" ").append(Math.round(sum));
			sb.append("\n");
		}

		System.out.println(sb);
	}

	private static boolean union(int x, int y) {
		int pX = find(x);
		int pY = find(y);

		if (pX == pY)
			return false;

		parents[pY] = pX;
		return true;
	}

	private static int find(int x) {
		if (parents[x] != x) {
			parents[x] = find(parents[x]);
		}

		return parents[x];
	}

	private static void make() {
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
}