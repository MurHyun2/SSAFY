package com.ssafy.class1;

public class Test08_Array2 {

	public static void main(String[] args) {
		{
			int[] arr = new int[4];
			arr[0] = 10;
			arr[1] = 20;
			arr[2] = 30;
			arr[3] = 40;

			for (int i : arr) {
				System.out.println(i);
			}
		}

		{
			int[] arr = { 10, 20, 30, 40 };

			for (int i : arr) {
				System.out.println(i);
			}
		}
		
		{
			int[] arr = new int[] { 10, 20, 30, 40 };
			
			for (int i : arr) {
				System.out.println(i);
			}
		}
	}

}
