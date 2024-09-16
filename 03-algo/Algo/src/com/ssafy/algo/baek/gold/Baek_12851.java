package com.ssafy.algo.baek.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_12851 {

	static int N, K, min, cnt;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[100_001];

		bfs();

		System.out.println(min);
		System.out.println(cnt);
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		arr[N] = 1;
		min = Integer.MAX_VALUE;
		cnt = 0;

		while (!q.isEmpty()) {
			int now = q.poll();

			// 현재 위치에서 최단 시간으로 K에 도착한 경우
			if (now == K) {
				min = arr[now] - 1;
				cnt++;
				continue;
			}

			int[] dr = { now + 1, now - 1, now * 2 };

			for (int i = 0; i < 3; i++) {
				int nr = dr[i];

				if (nr < 0 || nr > 100_000)
					continue;

				// 아직 방문하지 않은 경우
				if (arr[nr] == 0) {
					arr[nr] = arr[now] + 1;
					q.add(nr);
				}
				// 최단 경로에 해당하는 경우
				else if (arr[nr] == arr[now] + 1) {
					q.add(nr);
				}
			}
		}
	}
}
