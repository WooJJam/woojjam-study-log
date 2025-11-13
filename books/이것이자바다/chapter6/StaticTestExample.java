package 이것이자바다.chapter6;

public class StaticTestExample {

	static int staticField = staticInit();
	int instanceField = instanceInit();

	static {
		System.out.println("Static block 실행");
	}

	static int staticInit() {
		System.out.println("static 필드 초기화");
		return 1;
	}

	int instanceInit() {
		System.out.println("instance 필드 초기화");
		return 1;
	}

	{
		System.out.println("Instance block 실행");
	}

	public StaticTestExample() {
		System.out.println("생성자 실행");
	}

	public static void main(String[] args) {
		System.out.println("-------------");
		System.out.println("메소드 실행");
		new StaticTestExample();
	}
}
