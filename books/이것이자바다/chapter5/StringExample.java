package 이것이자바다.chapter5;

public class StringExample {

	public static void main(String[] args) {
		equalsExample();
	}

	private static void equalsExample() {
		String strVal1 = "우재민";
		String strVal2 = "우재민";

		if (strVal1 == strVal2) {
			System.out.println("strVal1 과 strVal2의 참조가 같음.");
		} else {
			System.out.println("strVal1 과 strVal2의 참조가 다름.");
		}

		if (strVal1.equals(strVal2)) {
			System.out.println("strVal1 과 strVal2 의 문자열이 같음.");
		}

		String strVal3 = new String("우재민");
		String strVal4 = new String("우재민");

		if (strVal3 == strVal4) {
			System.out.println("strVal1 과 strVal2가 참조가 같음.");
		} else {
			System.out.println("strVal1 과 strVal2가 참조가 다름.");
		}

		if (strVal3.equals(strVal4)) {
			System.out.println("strVal1 과 strVal2가 문자열이 같음.");
		}
	}
}
