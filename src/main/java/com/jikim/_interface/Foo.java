package com.jikim._interface;

public interface Foo {
	void printName();

	/** 기본 메소드 (Default methods)
	 * 인터페이스에 메소드 선언이 아니라 구현체를 제공하는 바업ㅂ
	 * 해당 인터페이스를 구현한 클래스를 깨뜨리지 않고 새 기능을 추가할 수 있다.
	 * 기본 메소드는 구현체가 모르게 추가된 기능으로 그만큼 리스크가 있다.
	 * 반드시 문서화 할것 (@implSpec 자바독 태그 사용)
	 *
	 * @implSpec 이 구현체는 getName()으로 가져온 문자열을 대문자로 바꿔 출력한다.
	 */
	default void printNameUpperCase() {
		System.out.println(getName().toUpperCase());
	}

	// 스태틱 메소드
	// 해당 타입 관련 유틸리티 메소드를 제공할 때 인터페이스에 스태틱 메소드를 제공할 수 이싿.
	static void printAnything() {
		System.out.println("FOO");
	}

	String getName();
}
