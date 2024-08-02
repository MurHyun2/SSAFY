package test01;

import com.google.gson.Gson;

public class Test1 {
	//프로젝트에 Gson 라이브러리를 인식시키는 법
	//1. JRE System Library 폴더에 jar 파일을 복붙 (but 권장x) 
	//2. 플젝 외부에 있는 jar 파일을 링크로 연결
	//	- but 플젝 이사할 때 링크 깨질 수 있음
	//3. 플젝 내부에 jar 파일 복사 -> 수동 
	//	- jar 파일 인식 시켜주기
	// 	- 플젝 우클릭 -> Build path -> Configure build path 
	//	> 라이브러리 탭 > ADD jars.. 
	
	//4. Maven 프로젝트로 만들고 pom.xml에 dependencies에 추가 
	
	public static void main(String[] args) {
		Gson gson = new Gson();
		//자바에서 	객체 -> JSON 문자열
		// 	  JSON 문자열 -> 객체
		
		Person luna = new Person("Luna", 4);
		
		String lunaStr = gson.toJson(luna);
		
		System.out.println(luna);
		System.out.println(lunaStr);
		
	}
	

}
