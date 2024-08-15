package com.ssafy.algo.baek.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2606 {

	static int node, line, sum;
	static int[][] arr;
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		node = Integer.parseInt(br.readLine().trim());
		line = Integer.parseInt(br.readLine().trim());

		arr = new int[node + 1][node + 1];

		for (int x = 0; x < line; x++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[a][b] = arr[b][a] = 1;
		}
		// 입력 종료

		check = new boolean[node + 1];
		sum = 0;
		dfs(1);
		System.out.println(sum);
	}

	static void dfs(int start) {
		check[start] = true;

		for (int i = 0; i <= node; i++) {
			if (arr[start][i] == 1 && !check[i]) {
				sum++;
				dfs(i);
			}
		}

	}
}
