package com.jikim.functional;

@FunctionalInterface
public interface RunSomething {

	// 추상 메서드 abstract 생략
	// 함수형 인터페이스에서 추상 메서드는 1개만 가지고 있어야 한다.
	// (Single Abstract Method)
	void doIt();

	// 자바8 ~
	// interface 내에 static, default 메서드 정의 가능
	static void printName() {
		System.out.println("Kim Ji Hun");
	}

	default void printAge() {
		System.out.println("27");
	}
}
