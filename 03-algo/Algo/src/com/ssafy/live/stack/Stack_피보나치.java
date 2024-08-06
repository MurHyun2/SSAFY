package com.ssafy.live.stack;

public class Stack_피보나치 {
	public static void main(String[] args) {

		System.out.println(memoizationFibo(499));
		System.out.println(fibonacci2(499));
		System.out.println(fibonacci(46));
	}

	static int fibonacci(int N) {
		if (N <= 1)
			return N;

		return fibonacci(N - 1) + fibonacci(N - 2);
	}

	static int fibonacci2(int N) {
		int[] arr = new int[N + 1];
		arr[0] = 0;
		arr[1] = 1;
		for (int i = 2; i <= N; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}

		return arr[N];
	}

	static int[] dp = new int[500];
	
	static {
		dp[1] = 1;
	}

	static int memoizationFibo(int N) {
		if (N <= 1)
			return N;

		if (dp[N] > 0)
			return dp[N];

		return dp[N] = memoizationFibo(N - 1) + memoizationFibo(N - 2);
	}

}
