package com.ssafy.test.sep3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test2_대전_04_이대현 {
	static int N, M, B, O, W;
	static char[][] arr;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
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
			arr = new char[N][M];
			visited = new boolean[N][M];

			// 배열을 초기화
			for (int r = 0; r < N; r++) {
				char[] ch = br.readLine().toCharArray();

				for (int c = 0; c < M; c++) {
					arr[r][c] = ch[c];
				}
			} // 입력 끝

			// 검은 색, 오렌지 색, 흰색 영역의 수를 초기화
			B = 0;
			O = 0;
			W = 0;

			// 색깔 별 영역을 구하기 위해 반복문 실행
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					// 이미 방문했던 곳은 방문하지 않음
					if (visited[r][c])
						continue;

					// 방문하지 않았다면 bfs를 돌면서 영역 계산
					bfs(r, c, arr[r][c]);
				}
			}

			// 출력 형식에 맞게 StringBuilder에 입력
			sb.append("#").append(tc).append(" ");
			sb.append(B).append(" ");
			sb.append(O).append(" ");
			sb.append(W).append(" ");
			sb.append("\n");
		} // tc 끝

		// StringBuilder 출력
		System.out.println(sb.toString());
	}

	// 색깔 별 영역을 구하기 위한 bfs 메서드
	private static void bfs(int x, int y, char selColor) {
		// Queue 생성
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y, selColor });

		// q가 빌때까지 반복
		while (!q.isEmpty()) {
			// q에 값을 poll
			int[] now = q.poll();
			int r = now[0];
			int c = now[1];
			int color = now[2];
			// 방문처리
			visited[r][c] = true;

			// 영역탐색을 위한 사방탐색 반복문
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				// 배열 범위에 벗어나거나, 방문했거나, 같은 색깔이 아니라면 continue
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc] || arr[nr][nc] != color)
					continue;

				// 색깔이 같다면 방문 처리 후 q에 추가
				visited[nr][nc] = true;
				q.add(new int[] { nr, nc, color });
			}
		}

		// 해당하는 색깔에 영역 갯수를 계산하기 위해 조건문 처리
		if (selColor == 'B')
			B++;
		else if (selColor == 'O')
			O++;
		else
			W++;
	}
}
