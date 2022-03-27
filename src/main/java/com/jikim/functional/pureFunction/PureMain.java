package com.jikim.functional.pureFunction;

public class PureMain {

	public static void main(String[] args) {
		Pure pure = (number) -> {
			return number + 10;
		};

		System.out.println(pure.doIt(10));
		System.out.println(pure.doIt(10));

		Pure nonPure = (number) -> {
			int baseNumber = 10;
			// 바뀔 우려가 있는 baseNumber
			return number + baseNumber;
		};
	}
}
