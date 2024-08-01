package com.ssafy.algo.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SWEA_1216 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src\\com\\ssafy\\algo\\swea\\input\\1216.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력
		for (int i = 1; i <= 10; i++) {
			int T = Integer.parseInt(br.readLine());
			char[][] map = new char[100][100];

			for (int j = 0; j < map.length; j++) {
				char[] input = br.readLine().toCharArray();

				for (int k = 0; k < map[j].length; k++) {
					map[j][k] = input[k];
				}

			}

			// 출력
			int result = searchPalindrome(map);

			System.out.printf("#%d %d\n", T, result);
		}
	}

	static int searchPalindrome(char[][] map) {

		List<Integer> list = new ArrayList<>();

		// 가로행 계산
		for (int r = 0; r < map.length; r++) {

			for (int c = 0; c < map[r].length; c++) {
				int lastIdx = 99;

				while (c < lastIdx) {
					if (map[r][c] == map[r][lastIdx]) {
						int idx = 1;

						while (c + idx < lastIdx - idx && map[r][c + idx] == map[r][lastIdx - idx])
							idx++;

						if ((lastIdx - idx) - (c + idx) < 1) {
							list.add(lastIdx - c + 1);
							break;
						}
					}

					lastIdx--;
				}
			}

		}

		// 세로열 계산
		for (int c = 0; c < map.length; c++) {

			for (int r = 0; r < map[c].length; r++) {
				int lastIdx = 99;

				while (r < lastIdx) {
					if (map[r][c] == map[lastIdx][c]) {
						int idx = 1;

						while (r + idx < lastIdx - idx && map[r + idx][c] == map[lastIdx - idx][c])
							idx++;

						if ((lastIdx - idx) - (r + idx) < 1) {
							list.add(lastIdx - r + 1);
							break;
						}
					}

					lastIdx--;
				}
			}

		}

		return Collections.max(list);
	}
}
