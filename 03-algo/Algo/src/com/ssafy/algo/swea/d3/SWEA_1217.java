package com.ssafy.algo.swea.d3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class SWEA_1217 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/1217.txt"));
		Scanner sc = new Scanner(System.in);

		for (int i = 1; i <= 10; i++) {
			sc.next();
			int a = sc.nextInt();
			int b = sc.nextInt();

			int result = nSquare(a, b);

			System.out.printf("#%d %d\n", i, result);
		}
	}

	static int nSquare(int a, int b) {
		if (b == 0)
			return 1;

		return a * nSquare(a, b - 1);
	}
}
