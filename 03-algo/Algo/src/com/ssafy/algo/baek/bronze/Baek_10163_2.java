package com.ssafy.algo.baek.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_10163_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] map = new int[1001][1001];
		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int dr = Integer.parseInt(st.nextToken());
			int dc = Integer.parseInt(st.nextToken());

			for (int x = r; x < r + dr; x++) {
				for (int y = c; y < c + dc; y++) {
					map[x][y] = i;
				}
			}

		}

		int[] arr = new int[T + 1];

		for (int[] js : map) {
			for (int j : js) {
				arr[j]++;
			}
		}

		for (int j = 1; j < arr.length; j++) {
			System.out.println(arr[j]);
		}
		
	}
}

// 색종이의 개수 T
// 색종이가 배열을 넘는 경우는 없으니 예외처리 필요 x
// (r,c)에서 시작해서 r + dr / c + dc 까지 i로 초기화
// 시간 복잡도를 줄이기 위해서 count 배열을 만들어, 한 번 읽을 때 1 ~ T의 개수를 전부 구함.
// 1 ~ T의 개수를 출력