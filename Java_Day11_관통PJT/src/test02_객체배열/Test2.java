package test02_객체배열;

import java.lang.reflect.Type;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Test2 {
	public static void main(String[] args) {

		String str = "[{\"name\":\"luna\",\"age\":3},{\"name\":\"max\",\"age\":4},{\"name\":\"Daisy\",\"age\":5}]";

		// JSON 문자 배열 => 객체 배열

		Gson gson = new Gson();
		Person[] arr = gson.fromJson(str, Person[].class);
		
		System.out.println(Arrays.toString(arr));
		
		
		//JSON 문자열 => 객체 리스트
		// TypeToken을 만들어서 타입으로 따로 표현해줘야
		
		Type personListType = new TypeToken<ArrayList<Person>>(){}.getType();
		ArrayList<Person> list = gson.fromJson(str, personListType);
		System.out.println(list);
		list.add(new Person("luna", 19));
		System.out.println(list);
		
		
		
		
	}

}
