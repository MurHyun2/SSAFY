package com.ssafy.algo.baek.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_1629 {
	static long A, B, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());

		sb.append(recursion(B));
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}

	private static long recursion(long exp) {
		if (exp == 1)
			return A % C;

		long half = recursion(exp / 2) % C;

		if (exp % 2 == 0) {
			return (half * half) % C;
		} else {
			return ((half * half) % C * A % C) % C;
		}
	}
}
