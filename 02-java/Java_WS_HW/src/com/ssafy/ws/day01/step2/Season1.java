package com.ssafy.ws.day01.step2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Season1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 3;
		
		for (int i = 0; i < T; i++) {
			int month = Integer.parseInt(br.readLine());
			
			if(month >= 3 && month <= 5)
				System.out.println(month + "월은 봄입니다.");
			else if(month >= 6 && month <= 8)
				System.out.println(month + "월은 여름입니다.");
			else if(month >= 9 && month <= 11)
				System.out.println(month + "월은 가을입니다.");
			else
				System.out.println(month + "월은 겨울입니다.");
		}
	}

}
