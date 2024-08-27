package com.ssafy.live.powerset;

public class 부분집합_03_재귀함수 {
	static String[] items = { "단무지", "오이", "햄", "시금치" };
	static int N = 4; // 재료의 수
	static boolean[] sel; // 체크 배열

	public static void main(String[] args) {
		N = 4;
		sel = new boolean[N];
		
		powerset(0);
	}

	public static void powerset(int idx) {
		// 기저조건 : base case -> 재귀를 빠져나가는 조건
		if (idx == N) {
			String tmp = "김밥 : ";
			for (int i = 0; i < N; i++) {
				if (sel[i])
					tmp += items[i] + " ";
			}
			System.out.println(tmp);
			return;
		}

		// 재귀 부분
		sel[idx] = true; // 해당 위치의 재료를 사용 o
		powerset(idx + 1);

		sel[idx] = false; // 해당 위치의 재료를 사용 x
		powerset(idx + 1);
	}
}
