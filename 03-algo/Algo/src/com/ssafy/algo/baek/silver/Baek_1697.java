package com.ssafy.algo.baek.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_1697 {

	static int N, K;
	static int[] dist = new int[100001];;

	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		dist[N] = 1;

		while (!q.isEmpty()) {
			int now = q.poll();

			int[] nextPositions = { now - 1, now + 1, now * 2 };

			for (int next : nextPositions) {
				if (next >= 0 && next < 100001 && dist[next] == 0) {
					dist[next] = dist[now] + 1;
					q.add(next);

					if (next == K)
						return;
				}
			}

//			int minArr = now - 1;
//			int plusArr = now + 1;
//			int mulArr = now * 2;
//
//			if (minArr >= 0 && dist[minArr] == 0) {
//				dist[minArr] = dist[now] + 1;
//				q.add(minArr);
//			}
//
//			if (plusArr < 100001 && dist[plusArr] == 0) {
//				dist[plusArr] = dist[now] + 1;
//				q.add(plusArr);
//			}
//
//			if (mulArr < 100001 && dist[mulArr] == 0) {
//				dist[mulArr] = dist[now] + 1;
//				q.add(mulArr);
//			}
//
//			if (dist[K] != 0)
//				return;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		bfs();

		System.out.println(dist[K] - 1);
	}
}
