package com.ssafy.algo.swea.d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_1859 {

	static Stack<Integer> stack = new Stack<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/1859.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine().trim());
			StringTokenizer st = new StringTokenizer(br.readLine().trim());

			for (int i = 0; i < N; i++)
				stack.push(Integer.parseInt(st.nextToken()));

			long max = 0;
			int mNow = 0;

			while (!stack.isEmpty()) {
				if (mNow <= stack.peek())
					mNow = stack.pop();
				else
					max += mNow - stack.pop();
			}

			System.out.printf("#%d %d\n", tc, max);
		}
	}
}
