package com.ssafy.algo.baek.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baek_1158 {

	static int N, K, idx;
	static List<Integer> list = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		idx = 0;

		for (int i = 1; i <= N; i++)
			list.add(i);

		sb.append("<");
		josephus();
		sb.append(">");

		System.out.println(sb.toString());
	}

	private static void josephus() {
		int num = 0;
		while (!list.isEmpty()) {
			num = (num + K - 1) % list.size();

			if (list.size() == 1) {
				sb.append(list.get(num));
				return;
			}

			sb.append(list.get(num) + ", ");
			list.remove(num);
		}
	}
}
