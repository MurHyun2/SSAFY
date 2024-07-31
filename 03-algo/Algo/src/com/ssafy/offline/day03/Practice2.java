package com.ssafy.offline.day03;

public class Practice2 {
	public static void main(String[] args) {
		//다시 풀어보기
		int[][] map = { { 1, 2, 3, 4, 5 }, { 16, 17, 18, 19, 6 }, { 15, 24, 25, 20, 7 }, { 14, 23, 22, 21, 8 },
				{ 13, 12, 11, 10, 9 } };

		int[] dr = { 0, 1, 0, -1 }; // 방향 배열 (오른쪽, 아래, 왼쪽, 위)
		int[] dc = { 1, 0, -1, 0 }; // 방향 배열 (오른쪽, 아래, 왼쪽, 위)

		int r = 0;
		int c = 0;
		int i = 0; // 방향 인덱스
		int visitedCount = 0; // 방문한 요소의 개수

		while (visitedCount < map.length * map[0].length) {
			System.out.print(map[r][c] + " ");
			map[r][c] = -1; // 방문한 위치를 -1로 표시
			visitedCount++;

			int nr = r + dr[i];
			int nc = c + dc[i];

			// 다음 위치가 배열 범위 안에 있는지와 방문하지 않았는지 확인
			if (nr >= 0 && nr < map.length && nc >= 0 && nc < map[nr].length && map[nr][nc] != -1) {
				r = nr;
				c = nc;
			} else {
				i = (i + 1) % 4; // 방향 변경
				r = r + dr[i];
				c = c + dc[i];
			}
		}
	}
}