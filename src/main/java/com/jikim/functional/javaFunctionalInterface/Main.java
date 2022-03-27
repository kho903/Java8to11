package com.jikim.functional.javaFunctionalInterface;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Main {
	public static void main(String[] args) {
		Plus10 plus10 = new Plus10();
		System.out.println(plus10.apply(1));

		// Function<T, R>
		// T 타입을 받아서 R 타입을 리턴하는 함수 인터페이스
		// R apply(T t);
		Function<Integer, Integer> plus10Lambda = (i) -> i + 10;
		System.out.println(plus10Lambda.apply(1));

		Function<Integer, Integer> multiply2 = (i) -> i * 2;
		System.out.println(multiply2.apply(3));

		// 함수 조합용 메소드
		// andThen, compose
		Function<Integer, Integer> multi2AndPlus10 = plus10.compose(multiply2);
		System.out.println(multi2AndPlus10.apply(2));

		Function<Integer, Integer> plus10AndThenMulti2 = plus10.andThen(multiply2);
		System.out.println(plus10AndThenMulti2.apply(2));

		// BiFunction<T, U, R>
		BiFunction<Integer, Integer, String> sumString = (a, b) -> "SUM : "+ (a + b);
		System.out.println(sumString.apply(1, 2));

		// Consumer<T>
		// T 타입을 받아서 리턴 X, void
		// 함수 조합용 메소드 : andThen
		Consumer<Integer> printT = (i) -> System.out.println(i);
		printT.accept(10);

		// Supplier<T>
		// T 타입의 값을 제공하는 함수 인터페이스
		Supplier<Integer> get10 = () -> 10;
		System.out.println(get10.get());

		// Predicate<T>
		// T 타입을 받아서 boolean을 리턴하는 함수 인터페이스
		Predicate<String> startsWithKim = (s) ->  s.startsWith("Kim");
		System.out.println(startsWithKim.test("KimJiHun"));

		// UnaryOperator<T>
		// Function<T, R>의 특수한 형태로,
		// 입력값 하나를 받아서 동일한 타입을 리턴하는 함수 인터페이스
		UnaryOperator<Integer> plus5 = (i) -> i + 10;
		UnaryOperator<Integer> multiply3 = (i) -> i * 3;
		System.out.println(plus5.apply(10));
		System.out.println(multiply3.apply(10));

		// BinaryOperator<T>
		// BiFunction<T, U, R>의 특수한 형태로,
		// 동일한 타입의 입력값 두개를 받아 리턴하는 함수 인터페이스
		BinaryOperator<Integer> plus = (a, b) -> a + b;
		System.out.println(plus.apply(2, 3));
	}
}
