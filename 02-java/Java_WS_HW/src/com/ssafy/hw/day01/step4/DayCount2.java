package com.ssafy.hw.day01.step4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.StringTokenizer;

public class DayCount2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int month = Integer.parseInt(st.nextToken());
		int day = Integer.parseInt(st.nextToken());
		int ans = 0;
		
		int year = LocalDate.now().getYear();
		
		LocalDate date = LocalDate.of(year, month, day);
		ans = date.getDayOfYear() - 1;
		
		System.out.println(ans);
	}

}
