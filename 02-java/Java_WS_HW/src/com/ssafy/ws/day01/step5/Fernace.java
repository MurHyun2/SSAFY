package com.ssafy.ws.day01.step5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Fernace {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int T = Integer.parseInt(br.readLine());

		int[] arr = new int[T];
		int ans = Integer.MAX_VALUE;
		int minus = Math.abs(A - B);

		for (int i = 0; i < T; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		for (int val : arr) {
			int min = Math.abs(B - val);

			if (ans > min)
				ans = min;
		}

		ans += 1;

		if (ans >= minus)
			ans = minus;

		if (ans >= 600)
			ans = -1;

		System.out.println(ans);
	}

}
