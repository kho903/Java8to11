package com.jikim._interface;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;

public class Main2 {
	public static void main(String[] args) {
		List<String> name = new ArrayList<>();
		name.add("kim");
		name.add("lee");
		name.add("park");
		name.add("choi");

		name.forEach((s) -> {
			System.out.println(s);
		});
		name.forEach(System.out::println);

		System.out.println("===========");
		Spliterator<String> spliterator = name.spliterator();
		Spliterator<String> spliterator1 = spliterator.trySplit();
		while (spliterator.tryAdvance(System.out::println));
		System.out.println("===========");
		while (spliterator1.tryAdvance(System.out::println));

		System.out.println("===========");
		long k = name.stream().map(String::toUpperCase)
			.filter(s -> s.startsWith("K"))
			.count();
		System.out.println(k);

		System.out.println("===========");
		// name.removeIf(s -> s.startsWith("k"));
		// name.forEach(System.out::println);

		System.out.println("===========");
		name.sort(String::compareToIgnoreCase);
		name.forEach(System.out::println);

		System.out.println("===========");
		Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
		name.sort(compareToIgnoreCase.reversed());
		name.forEach(System.out::println);

		System.out.println("===========");
		name.sort(compareToIgnoreCase.reversed());
		name.forEach(System.out::println);

	}
}
