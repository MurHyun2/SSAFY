package com.ssafy.algo.baek.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek_17298 {

	static int N;
	static int[] arr, result;
	static Stack<Integer> stack = new Stack<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine().trim());
		arr = new int[N];
		result = new int[N];

		st = new StringTokenizer(br.readLine().trim());

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		Oknsu();

		for (int i : result)
			sb.append(i + " ");

		System.out.println(sb.toString());
	}

	private static void Oknsu() {
		for (int i = N - 1; i >= 0; i--) {
			while (!stack.isEmpty() && arr[i] >= stack.peek())
				stack.pop();

			if (stack.isEmpty())
				result[i] = -1;
			else
				result[i] = stack.peek();

			stack.push(arr[i]);
		}
	}
}
