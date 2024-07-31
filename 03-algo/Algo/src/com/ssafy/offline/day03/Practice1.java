package com.ssafy.offline.day03;

public class Practice1 {
	public static void main(String[] args) {
		int[][] map = new int[5][5];

		// 배열 초기화
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				map[r][c] = (int) (Math.random() * 25);
			}
		}

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		int absSum = 0;
		for (int r = 0; r < map.length; r++) {
			
			for (int c = 0; c < map[r].length; c++) {
				
				for (int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					
					if(nr >= 0 && nr < map.length && nc >= 0 && nc < map[r].length)
						absSum += Math.abs(map[nr][nc] - map[r][c]);
				}
				
			}
			
		}
		
		System.out.println(absSum);
	}
}
