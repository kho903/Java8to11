package com.jikim.functional;

public class Foo {
	public static void main(String[] args) {
		// 자바 8 이전
		// 익명 내부 클래스 (Anonymous inner class)
		RunSomething runSomething = new RunSomething() {
			@Override
			public void doIt() {
				System.out.println("Hello");
			}
		};

		// 자바8~
		// 인터페이스가 1개인 경우, 람다식으로 표현가능
		RunSomething lambdaEx = () -> System.out.println("Hello");

		RunSomething lambdaEx2 = () -> {
			System.out.println("Hello");
			System.out.println("Hello2");
		};
	}
}
