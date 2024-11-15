package com.ssafy.off;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FileInputStream fl = new FileInputStream("data/input1220.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fl));

		// 교착상태 갯수;
		int ans = 0;

		// 반복 횟수 10회
		for (int i = 0; i < 10; i++) {

			// 배열 크기 T*T
			int T = Integer.parseInt(br.readLine());
			int[][] map = new int[T + 1][T + 1];

			// 첫번째 줄을 N극(1)로 초기화
			for (int j = 0; j < T; j++) {
				map[0][j] = 1;
			}

			// 마지막 줄을 S극(2)로 초기화
			for (int j = 0; j < T; j++) {
				map[T][j] = 2;
			}

			// map에 입력값 대입
			for (int j = 1; j < T; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int k = 0; k < T; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
				}
			}

			int half = T / 2;
			
			for (int j = 0; j < T; j++) {
				for (int k = 1; k < half; k++) {
					int first = 1;
					int last = T - 1;
					
					if(map[first][j] == 2) {
					
					} else {
						
					}
					
					if(map[last][j] == 2) {
						
					} else {
						
					}
				}
			}
			
			System.out.println("#" + i + " " + ans);
		}
	}
}
