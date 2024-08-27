package com.ssafy.algo.baek.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_14889 {
	// A팀(N / 2)만 구하면 B팀은 알아서 정해짐
	// 조합을 사용해 팀을 뽑고, a - b의 절댓값을 구한뒤 최소값 업데이트
	// 0일 시 최솟값이니 출력 후 종료

	static int N, min;
	static int[][] arr;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine().trim());
		arr = new int[N][N];
		visited = new boolean[N];
		min = Integer.MAX_VALUE;

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine().trim());

			for (int c = 0; c < N; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		comb(0, 0);

		System.out.println(min);

	}

	// 조합을 사용해 팀 나누기
	static void comb(int start, int depth) {
		if (depth == N / 2) {
			calMin();
			return;
		}

		for (int i = start; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				comb(i + 1, depth + 1);
				visited[i] = false;
			}
		}
	}

	// 최솟값 업데이트
	static void calMin() {
		int a = 0, b = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// i, j가 true라면 a팀
				if (visited[i] && visited[j]) {
					a += arr[i][j];
				}
				// i, j가 false라면 b팀
				else if (!visited[i] && !visited[j]) {
					b += arr[i][j];
				}
			}
		}

		int sum = Math.abs(a - b);

		// sum이 0이라면 최솟값이니 종료
		if (sum == 0) {
			System.out.println(0);
			System.exit(0);
		}

		min = Math.min(min, sum);
	}
}
