package com.ssafy.off.day10.live;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Test05_InputTest {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// InputStreamReader -> byte 데이터를 character 타입으로 변환.
		// BufferedReader -> Buffer 기능 추가
		
//		FileInputStream file = new FileInputStream("data/input_txt.txt");
//		System.setIn(new FileInputStream("data/input_txt.txt"));
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("data/input_txt.txt")));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		System.out.println(Arrays.toString(nums));
	}
}
