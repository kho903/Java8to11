package com.jikim._interface;

public interface Bar /*extends Foo*/ {

	// // 인터페이스를 상속받는 인터페이스에서 다시 추상 메소드로 변경할 수 있다.
	// void printNameUpperCase();

	// Foo, Bar 둘 다 상속 받은 클래스 내에서
	// 같은 이름의 default 메소드가 있다면 무조건 재정의 해주어야 한다.
	default void printNameUpperCase() {
		System.out.println("BAR");
	}
}
