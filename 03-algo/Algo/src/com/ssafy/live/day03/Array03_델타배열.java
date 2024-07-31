package com.ssafy.live.day03;

import java.util.Scanner;

public class Array03_델타배열 {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int[][] map = new int[5][5];
	static int r = 2;
	static int c = 2;

	static void printMap() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (r == i && c == j)
					System.out.print('X');
				else
					System.out.print('O');
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		printMap();

		while (true) {
			System.out.println("어디로 이동할까?");
			int d = sc.nextInt();
			
			// 입력값이 배열안에 있는지 확인
			if (d > dr.length - 1 || d > dc.length - 1) {
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
				continue;
				
			// 입력값이 배열안에 있다면 실행
			} else {
				
				// map안의 범위인지 확인
				int nr = r + dr[d];
				int nc = c + dc[d];

				// map안의 범위라면 이동
				if (0 <= nr && nr < map.length && 0 <= nc && nc < map[0].length) {
					r = r + dr[d];
					c = c + dc[d];

					printMap();
					
				// map밖이라면 이동 x
				} else {
					printMap();
					System.out.println("맵밖으로는 나갈 수 없습니다.");
					continue;
				}
			}
		}
	}
}
