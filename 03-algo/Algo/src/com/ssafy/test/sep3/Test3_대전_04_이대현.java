package com.ssafy.test.sep3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test3_대전_04_이대현 {
	static int N, M, min, totalSum;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// TestCase의 개수 T를 초기화
		int T = Integer.parseInt(br.readLine().trim());

		// T만큼 반복
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());

			// 각 변수들을 초기화
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N][M];
			visited = new boolean[N][M];
			totalSum = 0;

			// 배열을 초기화
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine().trim());

				for (int c = 0; c < M; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());

					// totalSum에 전체 영토의 값을 입력
					totalSum += arr[r][c];
				}
			} // 입력 끝

			// 전체 영토합이 최댓값이니, 초기 min 값을 totalSum으로 설정 ->
			min = totalSum;

			// 반복문을 돌면서 모든 경우의 수를 탐색
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					// min이 0이라면 이미 최솟값이니 continue;
					if (min == 0)
						continue;
					// 방문 처리
					visited[r][c] = true;
					// dfs로 두 구획의 양분의 합의 차이의 최솟값을 계산
					dfs(r, c, arr[r][c], 0);
				}
			}

			// 출력 형식에 맞게 StringBuilder에 입력
			sb.append("#").append(tc).append(" ");
			sb.append(min);
			sb.append("\n");
		} // tc 끝

		// StringBuilder 출력
		System.out.println(sb.toString());
	}

	// 두 구획의 양분의 합의 차이의 최솟값을 계산하는 dfs 메서드
	private static void dfs(int r, int c, int area, int depth) {
		// 각 구획은 적어도 1 칸 이상의 땅을 가지고 있어야 하므로, depth가 N * M - 1 이라면 return.
		if (depth == N * M - 1)
			return;

		// 두 구획의 양분의 합의 차이의 최솟값을 업데이트.
		min = Math.min(min, Math.abs(area - (totalSum - area)));

		// min이 0이라면 이미 최솟값이니 continue;
		if (min == 0)
			return;

		// 구획을 구하기 위한 사방탐색 반복문 진행
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			// 배열 범위를 벗어나거나 이미 방문했다면 continue
			if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc])
				continue;

			// 백트래킹을 위한 방문 처리
			visited[nr][nc] = true;
			// 방문하지 않았다면 dfs 진행
			dfs(nr, nc, area + arr[nr][nc], depth + 1);
			// 방문 처리 취소
			visited[nr][nc] = false;
		}
	}
}