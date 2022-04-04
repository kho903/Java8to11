package com.jikim.optional.optionalApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.jikim.optional.OnlineClass;
import com.jikim.optional.Progress;

public class Main {
	public static void main(String[] args) {

		List<OnlineClass> springClasses = new ArrayList<>();
		springClasses.add(new OnlineClass(1, "spring boot", true));
		springClasses.add(new OnlineClass(5, "rest api development", false));

		Optional<OnlineClass> optional = springClasses.stream()
			.filter(oc -> oc.getTitle().startsWith("spring"))
			.findFirst();

		/**
		 * Optional 에 값이 있는 지 없는 지 확인하기
		 * - isPresent()
		 * - isEmpty() (Java 11 부터 제공)
		 */
		boolean present = optional.isPresent();
		System.out.println(present);

		// Optional 에 있는 값 가져오기
		// OnlineClass onlineClass = optional.get();
		// System.out.println(onlineClass.getTitle());

		// Optional 에 값이 있는 경우에 그 값을 가지고 ~~를 하라.
		optional.ifPresent(oc -> System.out.println(oc.getTitle()));

		// Optional에 값이 있으면 가져오고 없는 경우에 ~~를 리턴하라.
		OnlineClass onlineClass1 = optional.orElse(createNewClass());
		System.out.println(onlineClass1.getTitle());

		// Optional에 값이 있으면 가져오고 없는 경우에 ~~를 하라.
		OnlineClass onlineClass2 = optional.orElseGet(Main::createNewClass);
		System.out.println(onlineClass2.getTitle());

		// Optional에 값이 있으면 가져오고 없는 경우 에러를 던져라.
		// OnlineClass onlineClass3 = optional.orElseThrow(IllegalStateException::new);
		// System.out.println(onlineClass3.getTitle());

		// Optional에 들어있는 값 걸러내기
		Optional<OnlineClass> onlineClass = optional
			.filter(oc -> !oc.isClosed());
		System.out.println(onlineClass.isPresent());

		// Optional에 들어있는 값 변환하기
		Optional<Integer> integer = optional.map(OnlineClass::getId);
		System.out.println(integer.isPresent());

		Optional<Optional<Progress>> progress = optional.map(OnlineClass::getProgress);
		Optional<Progress> progress1 = progress.orElseThrow();
		progress1.orElseThrow();

		// Optional flatMap(Function): Optional 안에 들어있는 인스턴스가 Optional인 경우에
		// 사용하면 편리하다.
		Optional<Progress> progress2 = optional.flatMap(OnlineClass::getProgress);


	}

	private static OnlineClass createNewClass() {
		System.out.println("create new online class");
		return new OnlineClass(10, "New Class", false);
	}
}
