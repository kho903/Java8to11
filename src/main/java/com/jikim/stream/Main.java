package com.jikim.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream
 * - sequence of elements supporting sequential and parallel aggregate operations
 * - 데이터를 담고 있는 저장소 (컬렉션)이 아니다.
 * - Functional in nature 스트림이 처리하는 데이터 소스를 변경하지 않는다.
 * - 무제한일 수도 있다. (Short Circuit 메소드를 사용해서 제한할 수 있다.)
 * - 중개 오퍼레이션은 근본적으로 lazy 하다.
 * - 손쉽게 병렬 처리할 수 있다.
 */

/**
 * 스트림 파이프라인
 * - 0 또는 다수의 중개 오퍼레이션 (intermediate operation)과 한 개의 종료 오퍼레이션(terminal operation)으로 구성한다.
 * - 스트림의 데이터 소스는 오직 터미널 오퍼레이션을 실행할 때에만 처리한다.
 */
public class Main {
	public static void main(String[] args) {

		List<String> names = new ArrayList<>();
		names.add("kim");
		names.add("lee");
		names.add("park");
		names.add("choi");

		// Stream<String> stringStream = names.stream().map(String::toUpperCase);
		// names.forEach(System.out::println);

		/**
		 * 중개 오퍼레이션
		 * - Stream을 리턴한다.
		 * - Stateless / Stateful 오퍼레이션으로 더 상세하게 구분할 수도 있다. (대부분은 Stateless 지만,
		 *   distinct나 sorted 처럼 이전 소스 데이터를 참조해야 하는 오퍼레이션은 Stateful 오퍼레이션이다.)
		 * - filter, map, limit, skip, sorted ...
		 */
		names.stream().map((s) -> {
			System.out.println(s);
			return s.toUpperCase();
		});// 중개 오퍼레이션 ->  출력 X

		/**
		 * 종료 오퍼레이션
		 * - Stream을 리턴하지 않는다.
		 * - collect, allMatch, count, forEach, min, max ...
		 */
		List<String> collect = names.stream().map((s) -> {
			System.out.println(s);
			return s.toUpperCase();
		}).collect(Collectors.toList());

		collect.forEach(System.out::println);

		System.out.println("==============");
		// 병렬적으로 처리
		List<String> collect1 = names.parallelStream().map((s) -> {
			System.out.println(s + " " + Thread.currentThread().getName());
			return s.toUpperCase();
		}).collect(Collectors.toList());
		collect1.forEach(System.out::println);
	}
}
