package com.ssafy.algo.baek.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_5014 {

	static int F, S, G, U, D;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		arr = new int[F + 1];

		bfs();

		System.out.println(arr[G] == 0 ? "use the stairs" : arr[G] - 1);
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(S);
		arr[S] = 1;
		int[] dr = { U, -D };

		while (!q.isEmpty()) {
			int now = q.poll();

			if (now == G)
				return;

			for (int i = 0; i < 2; i++) {
				int nr = now + dr[i];

				if (nr < 1 || nr >= F + 1 || arr[nr] != 0)
					continue;

				arr[nr] = arr[now] + 1;
				q.add(nr);
			}
		}
	}
}
