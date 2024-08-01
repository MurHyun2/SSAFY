package com.ssafy.live.day04;

public class String_atoi {
	public static void main(String[] args) {

		String strNum = "521234";
		System.out.println(0 + strNum);

		// 문자열 -> 정수
		int num = Integer.parseInt(strNum);
		System.out.println(0 + num);
		
		System.out.println(atoi(strNum));
	}

	static int atoi(String str) {
		int N = str.length();
		int num = 0;
		for (int i = 0; i < N; i++) {
			char c = str.charAt(i);
			if ('0' <= c && c <= '9')
				num = num * 10 + (c - '0');
		}

		return num;
	}
}
