package com.ssafy.live.backtracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5215_햄버거다이어트 {
	static int N, L; // R : 재료의 개수, L : 제한 칼로리
	static int[] cals, scores;
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/5215.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			scores = new int[N];
			cals = new int[N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				scores[i] = Integer.parseInt(st.nextToken());
				cals[i] = Integer.parseInt(st.nextToken());
			} // input 끝
			ans = 0;

			makeBurger(0, 0, 0);

			System.out.printf("#%d %d", tc, ans);
		} // tc
	}// main

	static void makeBurger(int idx, int sumScore, int sumCal) {

		// 백트래킹
		if (sumCal > L) {
			return;
		}

		// 기저조건
		if (idx == N) {
			// 모든 재료를 전부다 고려했음
			if (sumCal <= L && ans < sumScore)
				ans = sumScore;
			return;
			// 베스트인지 판단해라
		}

		// 재귀부분
		// 이번엔 idx 재료를 사용했다!
		makeBurger(idx + 1, sumScore + scores[idx], sumCal + cals[idx]);
		// 이번엔 재료를 사용하지 않았다. -> 다음 재료로 가야하니 idx는 + 1 해줘야함
		makeBurger(idx + 1, sumScore, sumCal);
	}
}
