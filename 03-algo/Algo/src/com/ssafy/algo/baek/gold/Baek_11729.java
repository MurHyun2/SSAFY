package com.ssafy.algo.baek.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Baek_11729 {

	static int N, cnt;
	static Queue<Integer> one = new LinkedList<>();
	static Queue<Integer> two = new LinkedList<>();
	static Queue<Integer> three = new LinkedList<>();
	static List<int[]> list = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine().trim());
		cnt = (int) (Math.pow(2, N) - 1);

		for (int i = 0; i < cnt; i++)
			one.add(i);
		// 입력 끝

		hanoi();

		sb.append(cnt);

		System.out.println(sb);
		for (int[] is : list) {
			System.out.println(is[0] + " " + is[1]);
		}
	}

	private static void hanoi() {
		if (N % 2 == 1) {
			while (!one.isEmpty()) {
				int now = one.poll();

				if (three.isEmpty()) {
					three.add(now);
					list.add(new int[] { 1, 3 });
				} else if (two.isEmpty()) {
					two.add(now);
					list.add(new int[] { 1, 2 });
				} else if (two.size() == three.size()) {
					two.add(three.poll());
					list.add(new int[] { 3, 2 });
				} else if (two.size() > three.size()) {
					while (!two.isEmpty())
						three.add(two.poll());

					list.add(new int[] { 2, 3 });
				} else {
					while (!three.isEmpty())
						two.add(three.poll());

					list.add(new int[] { 3, 2 });
				}
			}
			
			return;
		}

		while (!one.isEmpty()) {
			int now = one.poll();

			if (two.isEmpty()) {
				two.add(now);
				list.add(new int[] { 1, 2 });
			} else if (three.isEmpty()) {
				three.add(now);
				list.add(new int[] { 1, 3 });
			} else if (two.size() == three.size()) {
				two.add(three.poll());
				list.add(new int[] { 3, 2 });
			} else if (two.size() > three.size()) {
				while (!two.isEmpty())
					three.add(two.poll());

				list.add(new int[] { 2, 3 });
			} else {
				while (!three.isEmpty())
					two.add(three.poll());

				list.add(new int[] { 3, 2 });
			}
		}
	}
}
