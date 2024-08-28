package com.ssafy.algo.baek.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_10872 {

	static int T;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		System.out.println(cal(T));
	}

	private static int cal(int t) {
		if (t == 0)
			return 1;

		return t * cal(t - 1);
	}
}
