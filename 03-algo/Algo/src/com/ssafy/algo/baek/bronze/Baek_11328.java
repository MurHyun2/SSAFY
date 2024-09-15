package com.ssafy.algo.baek.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class Baek_11328 {

	static int[] alpCnt;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());

		for (int i = 0; i < N; i++) {
			String str = br.readLine().trim();
			alpCnt = new int[26];

			int spaceIdx = str.indexOf(" ");
			String first = str.substring(0, spaceIdx);
			String second = str.substring(spaceIdx + 1);

			check(first, second);
		}

		System.out.println(sb);
	}

	private static void check(String first, String second) {

		for (char ch : first.toCharArray())
			alpCnt[ch - 'a']++;

		for (char ch : second.toCharArray())
			alpCnt[ch - 'a']--;

		for (int cnt : alpCnt) {
			if (cnt != 0) {
				sb.append("Impossible").append("\n");
				return;
			}
		}

		sb.append("Possible").append("\n");
	}
}
