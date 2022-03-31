package com.jikim._interface;

public class DefaultFoo implements Foo {

	String name;

	public DefaultFoo(String name) {
		this.name = name;
	}

	// 인터페이스 구현체가 재정의 할 수도 있다.
	@Override
	public void printNameUpperCase() {
		System.out.println(this.name.toUpperCase());
	}

	@Override
	public void printName() {
		System.out.println(this.name);
	}

	@Override
	public String getName() {
		return this.name;
	}
}
