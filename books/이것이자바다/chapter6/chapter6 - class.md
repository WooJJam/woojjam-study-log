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
