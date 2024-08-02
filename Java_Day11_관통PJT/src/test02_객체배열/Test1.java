package test02_객체배열;

import java.util.Arrays;

import com.google.gson.Gson;

public class Test1 {
	public static void main(String[] args) {
		
		//객체배열
		Person arr[ ] = new Person[3];
		arr[0] = new Person("luna", 3);
		arr[1] = new Person("max", 4);
		arr[2] = new Person("Daisy", 5);
		
		System.out.println(Arrays.toString(arr));
		
		//객체 -> JSON
		
		Gson gson = new Gson();
		String arrStr = gson.toJson(arr);
		System.out.println(arrStr);
		
	}

}
