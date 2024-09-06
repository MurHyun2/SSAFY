package com.ssafy.algo.baek.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baek_11729_2 {

	static int N, cnt;
	static List<int[]> list = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine().trim());

		cnt = 0;

		hanoi(N, 1, 3, 2);

		sb.append(cnt);
		sb.append("\n");

		for (int[] move : list) {
			sb.append(move[0] + " " + move[1]);
			sb.append("\n");
		}

		System.out.println(sb);
	}

	private static void hanoi(int n, int start, int to, int via) {
		if (n == 1) {
			// 원판 하나를 목적지로 이동
			list.add(new int[] { start, to });
			cnt++;
			return;
		}

		// n-1개의 원판을 보조 기둥으로 옮김
		hanoi(n - 1, start, via, to);

		// 가장 큰 원판을 목적지로 옮김
		list.add(new int[] { start, to });
		cnt++;

		// 다시 n-1개의 원판을 목적지로 옮김
		hanoi(n - 1, via, to, start);
	}
}