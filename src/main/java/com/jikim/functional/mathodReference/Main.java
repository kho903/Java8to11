package com.jikim.functional.mathodReference;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Main {

	// 메소드 레퍼런스
	// - 람다가 하는 일이 기존 메소드 또는 생성자를 호출하는 거라면, 메소드 레퍼런스를 사용해서 매우 간결하게 표현 가능
	public static void main(String[] args) {
		// UnaryOperator<String> hi = (s) -> "hi " + s;
		// 위와 같은 코드에서 같은 일을 하는 클래스 내의 메소드 사용
		UnaryOperator<String> hi = Greeting::hi;
		System.out.println(hi.apply("Jikim"));

		Greeting greeting = new Greeting();
		UnaryOperator<String> hello = greeting::hello;
		System.out.println(hello.apply("Jikim"));

		Supplier<Greeting> newGreeting = Greeting::new;
		Greeting gr = newGreeting.get();

		Function<String, Greeting> kimGreeting = Greeting::new;
		Greeting kim = kimGreeting.apply("kim");
		System.out.println(kim.getName());
		Supplier<Greeting> newGreeting2 = Greeting::new;

		String[] names = {"Park", "Kim", "Lee"};
		Arrays.sort(names, String::compareToIgnoreCase);
		System.out.println(Arrays.toString(names));
	}
}
