package com.ssafy.live.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 그래프_03_간선배열 {
	static class Edge {
		int A, B, W; // 시작, 끝, 가중치

		public Edge(int a, int b, int w) {
			super();
			A = a;
			B = b;
			W = w;
		}

		@Override
		public String toString() {
			return "Edge [A=" + A + ", B=" + B + ", W=" + W + "]";
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// V, E의 갯수를 준다.
		int V = sc.nextInt(); // 정점의 갯수(0 or 1로 시작한다.)
		int E = sc.nextInt(); // 간선의 갯수

		// 방식 1
		Edge[] edges = new Edge[E]; // 객체 배열

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();

			edges[i] = new Edge(A, B, W);
		}

		////////////////////////////////

		// 방식 2
		List<Edge> edges2 = new ArrayList<>();
		for (int i = 0; i < E; i++) {
			edges2.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}

		///////////////////////////////
//		굳이? 객체까지 만들어야 하나..

		// 방식 3
		int[][] edges3 = new int[E][3];

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();

			edges3[i][0] = A; // [0] : 시작정점
			edges3[i][1] = B; // [1] : 도착정점
			edges3[i][2] = W; // [2] : 가중치
		}

	}
}