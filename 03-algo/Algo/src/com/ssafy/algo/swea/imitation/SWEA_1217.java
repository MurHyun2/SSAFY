package com.ssafy.algo.swea.imitation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class SWEA_1217 {

	static int N, M, result;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/1217.txt"));
		Scanner sc = new Scanner(System.in);

		for (int i = 1; i <= 10; i++) {
			sc.next();
			N = sc.nextInt();
			M = sc.nextInt();
			result = 1;

			nSquare(N, M);

			System.out.printf("#%d %d\n", i, result);
		}

	}

	private static void nSquare(int n, int m) {
		if (m == 0)
			return;

		result *= n;

		nSquare(n, m - 1);
	}
}
