package 이것이자바다.chapter5;

public class ArrayExample {
	public static void main(String[] args) {

		String[] old = {"java", "old", "array"};
		String[] newArray = new String[5];

		System.arraycopy(old, 0, newArray, 0, old.length);

		System.out.println(newArray[0].equals("java"));
		old[0] = "python";
		System.out.println(newArray[0]);
		System.out.println(old[0]);
	}


}
