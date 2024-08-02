package test01;

import com.google.gson.Gson;

public class Test2 {
	public static void main(String[] args) {
		Gson gson = new Gson();
		String str = "{\"name\":\"luna\", \"age\":4}";
		
		// 문자열 -> 객체 변환시
		// 자스는 따로 타입 지정 x지만
		// 자바는 지정되어야 하므로 타입 정보 넣어줘야 함  
		
		Person obj = gson.fromJson(str, Person.class);
		
				
		System.out.println(str);
		System.out.println(obj);
		
	}
	

}
