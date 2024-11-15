package com.ssafy.hw.day01.step4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DayCount {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("월과 일을 입력하세요.");
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		
		int month = Integer.parseInt(st.nextToken());
		int day = Integer.parseInt(st.nextToken());
		int ans = 0;
		
		for (int i = 0; i < month - 1; i++) {
			ans += days[i];
		}
		ans += day;
		
		System.out.printf("%d월 %d일은 %d번째 날입니다.", month, day, ans);
	}

}
