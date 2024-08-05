package com.ssafy.algo.swea.d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1204 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());

			// 학생들의 점수를 배열에 입력
			int[] students = new int[1000];

			for (int j = 0; j < 1000; j++) {
				students[j] = Integer.parseInt(st.nextToken());
			}

			// 점수의 갯수를 저장할 배열 생성
			int[] scores = new int[101];

			for (int j = 0; j < 1000; j++) {
				scores[students[j]]++;
			}

			// 가장 빈도수가 많은 점수를 찾아 출력
			int maxCount = 0;
			int result = 0;

			for (int j = 0; j < 101; j++) {
				if (maxCount <= scores[j]) {
					maxCount = scores[j];
					result = j;
				}
			}

			System.out.println("#" + i + " " + result);
		}
	}
}
