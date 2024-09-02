package com.ssafy.offline.solution.sep2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo2 {

	static int N, M, K, cnt;
	static int[] arr, sel;
	static boolean[] visited;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();

		// TestCase의 갯수를 받기 위한 변수 T를 초기화
		int T = Integer.parseInt(br.readLine().trim());

		// TestCase 수 만큼 반복
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());

			// 각 변수들을 초기화
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[N];
			sel = new int[M];
			visited = new boolean[M];
			cnt = 0;

			st = new StringTokenizer(br.readLine().trim());

			for (int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			// 입력 끝

			// 조합을 먼저 구한 다음에 해당 조합에 대해서 순서만 바꾸는 연산(팩토리얼)을 해주면
			// 순열을 사용할때 보다 속도가 훨씬 빠르다.
			comb(0, 0);

			// 경우의 수가 없을 경우(0), -1 출력을 위한 조건문
			if (cnt == 0)
				cnt = -1;

			// 출력 형식에 맞게 가공 후 sb에 저장
			sb.append("#").append(tc).append(" ").append(cnt * fact());
			sb.append("\n");
		}

		// sb 출력
		System.out.println(sb.toString());
	}

	private static int fact() {
		int sum = 1;
		
		for (int i = 2; i <= M; i++)
			sum *= i;

		return sum;
	}

	private static void comb(int now, int depth) {
		if (depth == M) {
			int sum = 0;

			for (int i = 0; i < M; i++)
				sum += sel[i];

			if (sum == K)
				cnt++;
			return;
		}

		for (int i = now; i < N; i++) {
			sel[depth] = arr[i];
			comb(i + 1, depth + 1);
		}
	}
}