package com.ssafy.algo.swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1208_2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 1; i <= 10; i++) {
			int T = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			// 배열 생성 후 초기화
			int[] arr = new int[100];

			for (int j = 0; j < 100; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}

			// 평탄화 작업 시작
			for (int j = 0; j < T; j++) {
				Arrays.sort(arr);

				if (arr[99] - arr[0] <= 1)
					break;

				arr[0]++;
				arr[99]--;
			}

			Arrays.sort(arr);

			// TC별 결과값 출력
			System.out.println("#" + i + " " + (arr[99] - arr[0]));
		}
	}
}
