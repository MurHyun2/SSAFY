package com.ssafy.algo.baek.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_1697_2 {

	static int N, K;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[100_001];

		bfs();

		System.out.println(arr[K] - 1);
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		arr[N] = 1;

		while (!q.isEmpty()) {
			int now = q.poll();

			int[] nr = { now - 1, now + 1, now * 2 };

			for (int i = 0; i < 3; i++) {
				if (nr[i] >= 0 && nr[i] < 100_001 && arr[nr[i]] == 0) {
					arr[nr[i]] = arr[now] + 1;
					q.add(nr[i]);

					if (nr[i] == K)
						return;
				}
			}
		}
	}
}
