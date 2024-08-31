package com.ssafy.algo.baek.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baek_1182 {

	static int N, B, cnt;
	static int[] arr, sel;
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		N = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		arr = new int[N];
		sel = new int[N];
		cnt = 0;

		st = new StringTokenizer(br.readLine().trim());

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		subs();

		System.out.println(cnt);
	}

	private static void subs() {
		for (int i = 1; i < (1 << N); i++) {
			list.clear();

			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) != 0) {
					list.add(arr[j]);
				}
			}

			if (list.size() % 2 != 0) {
				Collections.sort(list);
				
				int midVal = list.get(list.size() / 2);

				if (midVal == B) {
					System.out.println(list.toString());
					cnt++;
				}
			}
		}
	}
}
