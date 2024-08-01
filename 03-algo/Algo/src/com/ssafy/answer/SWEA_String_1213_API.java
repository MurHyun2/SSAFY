package com.ssafy.answer;

import java.io.IOException;
import java.util.Scanner;

class SWEA_String_1213_API {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 1; t++) {
			sc.nextInt(); // 테스트케이스 입력 버리기

			String pattern = sc.next();
			String text = sc.next();
			int ans = 0;
			while (text.length() >= pattern.length()) {
				if (text.startsWith(pattern))
					ans++;

				text = text.substring(1);
			}
			System.out.println("#" + t + " " + ans);
		}
		sc.close();
	}
}
