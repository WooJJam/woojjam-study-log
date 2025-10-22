package 이것이자바다.chapter5;

public class GcTest {

	public static void main(String[] args) {
		User u1 = new User("A");
		User u2 = new User("B");

		u1 = null;   // (1) 참조 제거
		u2 = new User("C");  // (2) 기존 객체 참조 잃음

		System.gc(); // GC 요청 (참고용)
	}

	static class User {
		String name;

		public User(final String name) {
			this.name = name;
		}
	}

}
