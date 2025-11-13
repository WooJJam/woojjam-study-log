# Chapter 7 - 상속

## 7.1. 개념

- 부모 클래스가 자신의 필드와 메소드를 자식 클래스에가 물려주는 것
- 한 클래스가 다른 클래스의 필드와 메소드를 재정의 없이 자동으로 사용할 수 있도록 하는 메커니즘
- 코드 재사용으로 인한 중복 코드 감소, 개발 시간 단축
- 다중 상속 불가능
- is - a 관계

<details>
<summary>상속 vs 컴포지션</summary>

상속은 단순히 어떤 클래스의 기능을 가져다 쓰는것이 아니다. 

제대로 사용하기 위해서는 부모 클래스의 내부 동작 방식과 구현에 의존해야 하기 때문에 자식 클래스는 상위 클래스의 변경에 **구조적으로 종속**되기 때문에 결합도가 높아질 수 밖에 없다.

따라서 결합도를 낮추기 위해서는 상속보다 컴포지션을 활용해야 한다.

#### 컴포지션
- 객체 내부에 다른 객체를 포함해서 기능을 위임
- has - a 관계
- 정 기능을 필요에 따라 조합하고 변경
- 결합도를 낮추고 변경에 유연

따라서 결합도를 낮추고, 변경에 유연하며 테스트 가능한 구조를 만들기 위해서는 상속보다 컴포지션을 우선적으로 고려하는 것이 좋다. 또한 자바 8 이후에는 인터페이스에 `deafult` 메서드가 추가됨에 따라 기능 재사용 조차도 인터페이스 기반으로 대체할 수 있어 상속의 필요성이 더욱 줄어들게 되었다.
</details>

## 7.3. 부모 생성자 호출

자식 객체를 생성하면 부모 객체가 먼저 생성된 다음 자식 객체가 생성된다.

```java
자식 클래스 변수 = new 자식 클래스();
```

그렇다면 자식 부모 객체의 생성자는 언제 호출이 되는 것일까?

저답은 자식 생성자에 있는데 
```java
public 자식클래스(...) {
	super();
}
```
부모 생성자는 자식 생성자의 맨 첫줄에 숨겨진 `super()`에 의해 성생된다. 이는 컴파일러에 의해서 자동으로 추가된다.

따라서 만약 부모 클래스에 기본 생성자가 없고, 매개변수룰 갖는 생성자만 있다면 `super(매개값...)` 와 같은 형태의 코드를 직접 작성해주어야 한다.

## protected 접근 제어자

같은 패키지 내 에서는 default 처럼 동작하지만, 다른 패키지라면 자식 클래스만 접근을 허용한다.

```java
package ex1;

public class Parent {
    protected String name = "WooJJam";

	protected void sayHello() {
		System.out.println("Hello from Parent : " + name);
	}
}
```
```java
package ex2;

import ex1.Parent;

public class Child extends Parent {
	
	protected String name = "WooJJam";
	
	protected void testAccess() {
		System.out.println(name);
		sayHello();
	}
}
```

다음과 같이 부모 클래스를 상속 받은 경우에는 다른 패지키라도 자식 클래스에서 부모 클래스로 접근이 가능하다.

하지만 외부에서 자식 객체를 통해 직접 접근하는건 불가능하다.

```java
package ex2;

public class Main {
    public static void main(String[] args) {
        Child c = new Child();
        c.testAccess();       // ✅ 가능 — 자식 내부에서 접근하니까
        System.out.println(c.name);  // ❌ 컴파일 에러!
        c.sayHello();         // ❌ 컴파일 에러!
    }
}
```
이처럼 상속 관계 내부에서 사용되는건 허용되지만 외부에서 자식 객체를 통해 부모 객체의 내부를 들여다보는건 허용되지 않는다.
