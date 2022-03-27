package com.jikim.functional.lambdaExpression;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.Supplier;

public class Main {
	public static void main(String[] args) {
		// 람다
		// (인자 리스트) -> {바디}

		// 인자 리스트
		// - 인자가 없을 때 : ()
		// - 인자가 한 개일때 (one) 또는 one
		// - 인자가 여러개 일 때 : (one, two)
		// - 인자의 타입은 생략 가능
		// 		- 컴파일러가 추론(infer) 하지만 명시할 수도 있다.
		Supplier<Integer> get10 = () -> {
			// body
			// 화살표 오른쪽에 함수 본문을 정의
			// 여러 줄인 경우에 {}를 사용해서 묶는다.
			// 한 줄인 경우에 생략 가능, return도 생략 가능
			return 10;
		};
		Supplier<Integer> get10_2 = () -> 10;

		BinaryOperator<Integer> get10_3 = (a, b) -> a + b;

		Main main = new Main();
		main.run();
	}

	private void run() {
		// 변수 캡쳐 (Variable Capture)
		// - 로컬 변수 캡처
		// 		- final이거나 effective final인 경우에만 참조할 수 있다.
		//		- 그렇지 않을 경우 concurrency 문제가 생길 수 있어서 컴파일러가 방지한다.
		// - effective final
		// 		- 이것도 역시 자바 8부터 지원하는 기능으로 사실상 final인 변수
		// 		- final 키워드 사용하지 않는 변수를 익명 클래스 구현체 또는 람다에서 참조할 수 있다.
		// - 익명 클래스 구현체와 달리 '쉐도잉'을 하지 않는다.
		// 		- 익명 클래스는 새로 scope을 만들지만, 람다는 람다를 감싸고 있는 scope과 같다.
		int baseNumber = 10;

		// 로컬 클래스
		class LocalClass {
			void printBaseNumber() {
				int baseNumber = 11;
				System.out.println(baseNumber);
			}
		}

		// 익명 클래스
		Consumer<Integer> integerConsumer = new Consumer<Integer>() {
			@Override
			public void accept(Integer baseNumber) {
				System.out.println(baseNumber);
			}
		};

		// 람다
		IntConsumer printInt = (i) -> {
			System.out.println(i + baseNumber);
		};

		printInt.accept(10);
	}
}
