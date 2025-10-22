package 이것이자바다.chapter5;

public class NullPointerExceptionExample {
	public static void main(String[] args) {
		int[] arr = null;
		// arr[0] = 10;

		String str = null;
		System.out.println("총 문자 수 : " + str.length());
	}
}
