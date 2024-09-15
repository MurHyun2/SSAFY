package com.ssafy.algo.baek.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Baek_1021 {

	static int N, M, cnt;
	static int[] arr;
	static Deque<Integer> deque = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];

		for (int i = 1; i <= N; i++)
			deque.add(i);

		st = new StringTokenizer(br.readLine().trim());

		for (int i = 0; i < M; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		// 입력 끝

		cnt = 0;

		rotation();

		System.out.println(cnt);
	}

	private static void rotation() {
		for (int i : arr) {
			int idx = 0;

			for (Integer num : deque) {
				if (num == i)
					break;

				idx++;
			}

			if (idx <= (deque.size() / 2)) {
				while (deque.peekFirst() != i) {
					deque.addLast(deque.pollFirst());
					cnt++;
				}
			} else {
				while (deque.peekFirst() != i) {
					deque.addFirst(deque.pollLast());
					cnt++;
				}
			}

			deque.pollFirst();
		}
	}
}