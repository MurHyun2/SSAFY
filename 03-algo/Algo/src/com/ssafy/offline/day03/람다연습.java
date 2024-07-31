package com.ssafy.offline.day03;

import java.util.Arrays;
import java.util.Comparator;

class Idol {
	String name;
	int age;

	public Idol() {

	}

	public Idol(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Idol [name=" + name + ", age=" + age + "]";
	}

}

class IdolComp implements Comparator<Idol> {
	@Override
	public int compare(Idol o1, Idol o2) {
		return o1.age - o2.age;
	}

}

public class 람다연습 {
	public static void main(String[] args) {
		Idol[] idols = new Idol[6];
		
		idols[0] = new Idol("가나다", 25);
		idols[1] = new Idol("사아자", 31);
		idols[2] = new Idol("라마바", 21);
		idols[3] = new Idol("파하", 18);
		idols[4] = new Idol("타카차", 45);
		idols[5] = new Idol("차카타", 45);
		
//		Arrays.sort(idols, new IdolComp());
//		Arrays.sort(idols, (o1, o2) -> o1.name.compareTo(o2.name));
		Arrays.sort(idols, new Comparator<Idol>() {
			@Override
			public int compare(Idol o1, Idol o2) {
				return o1.age == o2.age ? o1.name.compareTo(o2.name) : o1.age - o2.age;
			}
		});
		
		
		for (Idol idol : idols) {
			System.out.println(idol);
		}
	}
}
