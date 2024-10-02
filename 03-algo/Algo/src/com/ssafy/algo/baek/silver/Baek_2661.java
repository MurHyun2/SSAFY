package com.ssafy.algo.baek.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baek_2661 {

	static int N, X, Y;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine().trim());

		st = new StringTokenizer(br.readLine().trim());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());

		int M = Integer.parseInt(br.readLine().trim());
		arr = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			arr[y] = x;
		}
		// 입력 끝

		List<Integer> pathX = findPath(X);
		List<Integer> pathY = findPath(Y);

		int same = findSame(pathX, pathY);

		int xCnt = pathX.indexOf(same);
		int yCnt = pathY.indexOf(same);

		int result = xCnt + yCnt;

		if (result < 0)
			System.out.println(-1);
		else
			System.out.println(result);
	}

	private static int findSame(List<Integer> pathX, List<Integer> pathY) {
		for (Integer x : pathX) {
			if (pathY.contains(x))
				return x;
		}

		return -1;
	}

	private static List<Integer> findPath(int x) {
		List<Integer> path = new ArrayList<>();

		while (arr[x] != x) {
			path.add(x);
			x = arr[x];
		}

		path.add(x);

		return path;
	}
}
