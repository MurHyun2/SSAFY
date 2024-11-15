package com.ssafy.hw.day03.step2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bridge_P {

	public static void main(String[] args) throws FileNotFoundException {
		FileInputStream f1 = new FileInputStream("data/day03_hw_step02.txt");
		Scanner sc = new Scanner(f1);

		int n = sc.nextInt();
		
		// n * n 크기 배열 선언 ( 지도 )
		int[][] map = new int[n][n];
		
		// 지도 정보 입력 받기
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		// 최대값 저장
		int maxDistance = 0;
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				// 지금 위치가 섬인지 검사
				if ( map[i][j] == 1 ) {
					
					// 섬이면 현재 위치로부터 사방탐색 하여 가로 또는 세로에 있는 섬과 거리 측정, 최대값 저장
					
					// 동쪽이 1인지 검사
					for (int d = 1; d < map.length - j; d++) {
						if (map[i][j + d] == 1) {
							maxDistance = Math.max(maxDistance, d);
							break;
						} else if (map[i][j + d] == 0 && j + d == map.length - 1) {
							maxDistance = Math.max(maxDistance, d);
						}
					}
					
					// 서쪽이 1인지 검사
					for (int d = 1; d <= j; d++) {
						if (map[i][j - d] == 1) {
							maxDistance = Math.max(maxDistance, d);
							break;
						} else if (map[i][j - d] == 0 && j - d == 0) {
							maxDistance = Math.max(maxDistance, d);
						}
					}
					
					// 북쪽이 1인지 검사
					for (int d = 1; d <= i; d++) {
						if (map[i - d][j] == 1) {
							maxDistance = Math.max(maxDistance, d);
							break;
						} else if (map[i - d][j] == 0 && i - d == 0) {
							maxDistance = Math.max(maxDistance, d);
						}
					}
					
					// 남쪽이 1인지 검사
					for (int d = 1; d < map.length - i; d++) {
						if (map[i + d][j] == 1) {
							maxDistance = Math.max(maxDistance, d);
							break;
						} else if (map[i + d][j] == 0 && i + d == map.length - 1) {
							maxDistance = Math.max(maxDistance, d);
						}
					}
				}
			}
		}
		
		System.out.println(maxDistance);
	}
}
