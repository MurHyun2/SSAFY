package com.ssafy.class1;

public class Test04_Condition {
	public static void main(String[] args) {
		// 조건식 if, switch

		{
			System.out.println("1.4 버전 이전 체크");

			int num = 1;
			int result = 0;
			// double num = 3;
			// Cannot switch on a value of type double.
			// Only convertible int values, strings or enum variables are permitted
			switch (num) { // byte, char, short, int
			case 1:
				result += 10;
				break;
			case 2:
				result += 20;
				break;
			case 3:
				result += 30;
				break;
			}
			System.out.println(result);
		}

		// 다른데 정의 되어 있는 값
		final String SEASON_SPRING = "spring";
		final String SEASON_SUMMER = "summer";
		final String SEASON_FALL = "fall";
		final String SEASON_WINTER = "winter";

		{
			System.out.println("1.7 버전 - String 가능");
			String season = "spring";
			switch (season) {
			case SEASON_SPRING:
				System.out.println(SEASON_SPRING);
				break;
			case SEASON_SUMMER:
				System.out.println(SEASON_SUMMER);
				break;
			case SEASON_FALL:
				System.out.println(SEASON_FALL);
				break;
			case SEASON_WINTER:
				System.out.println(SEASON_WINTER);
				break;
			}
		}

		{
			System.out.println("1.5 버전 - enum 가능");
			Season season = Season.SUMMER;
			switch (season) {
			case SPRING:
				System.out.println(SEASON_SPRING);
				break;
			case SUMMER:
				System.out.println(SEASON_SUMMER);
				break;
			case FALL:
				System.out.println(SEASON_FALL);
				break;
			case WINTER:
				System.out.println(SEASON_WINTER);
				break;
			}
		}
	}
	enum Season {
		SPRING, SUMMER, FALL, WINTER
	}
}
