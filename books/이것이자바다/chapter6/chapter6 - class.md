# Chapter 6 - 클래스

## 6.1. 객체 지향 프로그래밍

- 객체들 간의 상호작용을 통해서 문제를 해결하는 프로그래밍 기법

#### 객체
- 현실 세계의 사물이나 개념을 프로그램 안에서 표현한 것
- 데이터(속성, 필드)와 행동(기능, 메소드)을 하나로 묶은 독립적인 단위

### 특징

#### 1. 추상화

> 불필요한 세부 사항은 숨기고, 핵심적인 특징만 모델링 하는 것

- 현실의 복잡한 개념을 코드로 단순화하는 과정

```java
class Car {
	void drive() {...} // 주행 가능만 표현
}

```

#### 2. 캡슐화

> 필드와 메서드를 하나로 묶고, 외부 접근을 제한하는 것

- 외부에서 객체 내부 데이터를 직접 바꾸지 못하게 막음
- `private`, `public`, `protect` 를 통해 제어

```java
class Account {
	private int balance;
	
	public void deposit(int amount) {
		balance += amount;
    }
	
	public int getBalance() {
		return balance;
    }
}
```

#### 3. 상속

> 부모 클래스의 필드와 메소드들을 자식 클래스가 물려받는 것

- 코드의 중복을 줄이고, 공통 로직 재사용 가능

```java
class Vehicle {
    void move() { System.out.println("이동 중..."); }
}

class Car extends Vehicle {
    void horn() { System.out.println("빵빵!"); }
}
```

#### 4. 다형성

> 같은 메서드 이름이 객체에 따라 다르게 동작하는 것

```java
class Animal {
    void sound() { System.out.println("동물이 소리냄"); }
}

class Dog extends Animal {
    void sound() { System.out.println("멍멍!"); }
}

class Cat extends Animal {
    void sound() { System.out.println("야옹~"); }
}
```

## 📌 필드 vs 로컬 변수

#### 로컬 변수

- 생성자와 메소드 블록에서 선언
- 생성자, 메소드 호출시에만 존재
- 생성자, 메소드 블록 내부에서만 사용

#### 필드

- 클래스 블록에서 선언
- 객체 내부에 존재
- 객체 내,외부 어디든 사용

## 6.7. 생성자 선언과 호출

### 1. 생성자 오버로딩

- 오버로딩: 매개 변수를 달리하는 같은 이름의 메소드를 여러 개 선언하는 것
- 생성자 오버로딩: 매개 변수를 달리하는 생성자를 여러 개 선언하는 것

```java
public class Calculator {
    public int add(int a, int b) { return a + b; }
    public double add(double a, double b) { return a + b; }
    public int add(int a, int b, int c) { return a + b + c; }
}
```

#### 🔍 컴파일 타임에 결정

자바 컴파일러가 어떤 메소드를 호출해야 할지 코드 작성 시점에서 이미 결정해버리기 때문에 런타임 중에 어떤 인스턴지가 들어올지를 보고 결정하지 않고, 컴파일 시점에 결장나게 된다. (반면, 오버라이딩은 런타임 시점에 결정)

## 6.9. 인스턴스 멤버

- 객체에 속하며 객체 생성시 생성되고, 객체마다 존재
- 객체에 소속된 멤버로 일반적인 필드와 메소드가 여기에 해당

인스턴스 멤버는 객체에 '소속' 된 거지 '포함' 된거라고 볼 순 없다. 필드의 경우 객체에 소속된 멤버가 분명하지만 메소드의 경우 코드 덩어리 이므로 객체마다 저장한다면 메모리 효율이 매우 떨어질 것 이다. 그러므로 메소드 코드는 메소드 영역에 두어 공유해서 사용하되 객체 없이는 접근 할 수 없도록 제한을 걸어둔 것이다.

## 6.10. 정적 멤버

- 정적 멤버는 클래스 자체에 속하며 클래스가 처음 로딩될 때 딱 한번 생성됨
- 객체를 생성할 필요 없이 클래스 이름으로 바로 사용 가능
- `static` 키워드를 추가하면 됨

자바는 클래스 로더를 통해 클래스를 메소드 영역에 저장하고 사용하는데, 정적 멤버는 클래스 내에서 고정적으로 위치하는 멤버이다. 그러므로 객체 생성 없이 바로 사용이 가능한 것이다.

### 정적 블록

일반적으로 정적 필드는 필드 선언과 동시에 초기화한다. 하지만 정적 멤버에 복잡한 초기화 로직이 필요하다면 정적 블록을 사용해야한다.

```java
static {
    ...	
}
```

정적 필드는 클래스 로딩 시점에 메서드 영역에 올라가며, 이때 초기화도 이루어지게 된다. 하지만 생성자의 경우 인스턴스 생성 후 실행되기 때문에, 정적 필드를 생성자에서 초기화할 수 없는 것이다. 

`static` 블록은 클래스 로딩 후 초기화 시점에 실행되기 때문에 인스턴스 생성 후 초기화되는 **인스턴스 멤버에 접근할 수 없는 것이다.**

### 📍 추가 정보

#### 1. 클래스 초기화 순서 (static 필드, static 블록, 인스턴스 초기화 블록, 생성자)

해당 내용을 확인하기 위해서 `StaticTestExample.java` 코드를 실행해보면

![init.png](img/init.png)

다음 사진과 같은 출력 결과를 확인할 수 있다.

### 2. static 필드 초기화와 lazy loading의 관계

> 📌 Lazy Loading: 리소스, 클래스, 객체 등을 사용될 때까지 생성하지 않고 미뤄두는 전략 

static 초기화는 기본적으로 `Eager(즉시 초기화)` 이다.

```java
class Singleton {
    private Singleton() {}

    private static class Holder {
        static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return Holder.INSTANCE;
    }
}
```

- `Holder` 클래스는 `getInstance()` 가 호출될 때 까지 로딩되지 않음
- JVM의 클래스 로더가 런타임 시점에 해당 클래스를 로딩할 지 결정함

## 📢 꼬리 질문

static 필드가 여러 스레드에 의해 동시에 수정될 가능성이 있을 때, 어떤 문제가 생길 수 있으며, 이를 방지하기 위한 기법이 있을까?
