package com.ssafy.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		int result = 0;
		
		result = A + B - C;
		System.out.println(result);
		
		
		result = Integer.parseInt(Integer.toString(A) + Integer.toString(B)) - C;
		System.out.println(result);
	}
}
