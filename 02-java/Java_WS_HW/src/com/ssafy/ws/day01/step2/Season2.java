package com.ssafy.ws.day01.step2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Season2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = 3;
		while (T > 0) {
			int month = Integer.parseInt(br.readLine());

			switch (month) {
			case 12:
			case 1:
			case 2:
				System.out.println(month + "월은 겨울입니다.");
				break;
			case 3:
			case 4:
			case 5:
				System.out.println(month + "월은 봄입니다.");
				break;
			case 6:
			case 7:
			case 8:
				System.out.println(month + "월은 여름입니다.");
				break;
			case 9:
			case 10:
			case 11:
				System.out.println(month + "월은 가을입니다.");
				break;
			}
		}
	}
}
