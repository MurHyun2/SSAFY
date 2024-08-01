package com.ssafy.answer;

import java.util.*;

class SWEA_String_1213 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 1; t++) {
			sc.nextInt(); // 테스트케이스 입력 버리기
			char[] pattern = sc.next().toCharArray();
			char[] text = sc.next().toCharArray();

			int ans = 0;
			int patLen = pattern.length, txtLen = text.length;

			// 전체 검색
			outer: for (int i = 0; i <= txtLen - patLen; i++) {
				for (int j = 0; j < patLen; j++) {
					if (pattern[j] != text[i + j])
						continue outer;
				}
				ans++;
			}
			System.out.println("#" + t + " " + ans);
		}

		sc.close();
	}
}