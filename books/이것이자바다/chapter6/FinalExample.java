package 이것이자바다.chapter6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FinalExample {

	static class Car {
		private int curPosition = 3;

		public void changePosition(int newPosition) {
			curPosition = newPosition;
		}
	}

	public static void main(String[] args) {

		final Car car = new Car();

		car.changePosition(10);
		System.out.println("변경 완료");

		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");

		List<String> immutableList = Collections.unmodifiableList(new ArrayList<String>(list));

		list.add("d");
		System.out.println(immutableList.get(3));
	}

}
