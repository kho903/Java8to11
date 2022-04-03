package com.jikim.optional;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

/** Optional
 * - 자바 프로그래밍에서 NullPointerException을 종종 보게 되는 이유
 * 		- null을 리턴하니까, null 체크를 깜빡했을 때
 * - 메소드에서 작업 중 특별한 상황에서 값을 제대로 리턴할 수 없는 겨웅 선택할 수 있는 방법
 * 		- 예외를 던진다. (비싸다. stack trace를 찍어두니까)
 * 		- null을 리턴한다. (코드를 사용하는 클라이언트가 주의해서 사용해야 한다.)
 * 		- (자바 8부터) Optional을 리턴한다. (클라이언트의 코드에게 명시적으로 빈 값일 수도 있다는 것을
 * 			알려주고, 빈 값인 경우에 대한 처리를 강제한다.)
 *
 * - Optional
 * 		- 오직 값 한 개가 들어있을 수도 없을 수도 있는 컨테이너.
 * - 주의점
 * 		- 리턴값으로만 쓰기를 권장한다. (메소드 매개변수 타입, 맵의 키 타입, 인스턴스 필드 타입으로 쓰지 말자)
 * 		- Optional을 리턴하는 메소드에서 null을 리턴하지 말자.
 * 		- Primitive 타입용 Optional은 따로 있다. (OptionalInt, OptionalLong ...)
 * 		- Collection, Map, Stream Array, Optional은 Optional로 감싸지 말 것.
 */
public class Main {
	public static void main(String[] args) {

		List<OnlineClass> springClasses = new ArrayList<>();
		springClasses.add(new OnlineClass(1, "spring boot", true));
		springClasses.add(new OnlineClass(2, "spring data jpa", true));
		springClasses.add(new OnlineClass(3, "spring mvc", false));
		springClasses.add(new OnlineClass(4, "spring core", false));
		springClasses.add(new OnlineClass(5, "rest api development", false));

		OnlineClass springBoot = new OnlineClass(1, "spring boot", true);
		// Duration studyDuration = springBoot.getProgress().getStudyDuration(); // null pointer exception
		// System.out.println(studyDuration);

		// 자바8 이전 Optional 이 없을 때
		// Progress progress = springBoot.getProgress();
		// if (progress != null)
		// 	System.out.println(progress.getStudyDuration());

		// primitive 타입용 Optional은 따로 있다.
		OptionalInt.of(10);

	}
}
