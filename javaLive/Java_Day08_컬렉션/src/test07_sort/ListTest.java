package test07_sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListTest {
	static class Idol implements Comparable<Idol> {
		String name;
		int age;

		public Idol(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}

		@Override
		public int compareTo(Idol idol) {
			if (this.age == idol.age) {
				return this.name.compareTo(idol.name);
			}
			return this.age - idol.age;
		}

		@Override
		public String toString() {
			return "Idol [name=" + name + ", age=" + age + "]";
		}

	}

	public static void main(String[] args) {
		List<Idol> list = new ArrayList<>();
		list.add(new Idol("김카리나", 24));
		list.add(new Idol("윈터", 23));
		list.add(new Idol("림윈터", 24));
		list.add(new Idol("장욱", 27));
		list.add(new Idol("딤장욱", 24));
		list.add(new Idol("딤장욱", 24));
		list.add(new Idol("진종수", 30));

		// Comparable Interface 타입이어야 한다.
		Collections.sort(list);

		for (Idol idol : list) {
			System.out.println(idol);
		}
	}
}
