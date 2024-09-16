package com.ssafy.algo.baek.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_13549 {

	static int N, K, min, cnt;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[100_001];

		Arrays.fill(arr, -1);

		bfs();

		System.out.println(arr[K]);
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		arr[N] = 0;

		while (!q.isEmpty()) {
			int now = q.poll();

			int[] dr = { now * 2, now + 1, now - 1 };

			for (int i = 0; i < 3; i++) {
				int nr = dr[i];
				int nextTime = (i == 0 ? arr[now] : arr[now] + 1);

				if (nr < 0 || nr > 100_000)
					continue;

				if(arr[nr] == -1 || arr[nr] > nextTime) {
					arr[nr] = nextTime;
					q.add(nr);
				}
			}
		}
	}
}
