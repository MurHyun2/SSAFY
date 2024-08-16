package com.ssafy.offline.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 봉사활동 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine().trim());

		for (int i = 1; i <= tc; i++) {
			st = new StringTokenizer(br.readLine().trim());

			int N = Integer.parseInt(st.nextToken());
			int min = Integer.parseInt(st.nextToken());
			int max = Integer.parseInt(st.nextToken());
			int avg = N / 3;

			int[] arr = new int[N];

			st = new StringTokenizer(br.readLine().trim());

			for (int j = 0; j < N; j++)
				arr[j] = Integer.parseInt(st.nextToken());

			Arrays.sort(arr);
			List<Integer> count1 = new ArrayList<>();
			List<Integer> count2 = new ArrayList<>();
			List<Integer> count3 = new ArrayList<>();

			Queue<Integer> q = new LinkedList<>();

			for (int j = 0; j < arr.length; j++)
				q.add(arr[j]);

			while (!q.isEmpty()) {
				int now = q.poll();

				if (count1.size() < avg || count1.getLast() == now) {
					count1.add(now);
				} else if (count2.size() < avg || count2.getLast() == now) {
					count2.add(now);
				} else {
					count3.add(now);
				}
			}

			int size1 = count1.size();
			int size2 = count2.size();
			int size3 = count3.size();

			int maxResult = Math.max(size1, Math.max(size2, size3));
			int minResult = Math.min(size1, Math.min(size2, size3));

			int result = maxResult - minResult;

			if (count1.size() < min || count2.size() < min || count3.size() < min || count1.size() > max
					|| count2.size() > max || count3.size() > max) {
				result = -1;
			}

			System.out.printf("#%d %d\n", i, result);
		}

	}
}

// 1시간 15분
