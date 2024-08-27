package com.ssafy.live.powerset;

public class 부분집합_02_비트마스킹 {
	static String[] items = { "단무지", "오이", "햄", "시금치" };
	static int N = 4; // 재료의 수
	static int[] sel = new int[N]; // 체크 배열

	public static void main(String[] args) {
		// 2**N만큼 반복한다.
		for (int i = 0; i < (1 << N); i++) {
			// 재료 확인 for문 필요하다.
			String tmp = "";
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) > 0) {
					// 해당 재료가 있다
					tmp += items[j] + " ";
				}
			} // 재료 확인 끝
			System.out.println(tmp);
		}
	}
}