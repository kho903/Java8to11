package com.jikim.parallelSort;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/** 배열 Parallel 정렬
 * Arrays.parallelSort()
 * - Fork / Join 프레임워크를 사용해서 배열을 병렬로 정렬하는 기능을 제공한다.
 *
 * 병렬 정렬 알고리즘
 * - 배열을 둘로 계속 쪼갠다.
 * - 합치면서 정렬한다.
 *
 * sort(), parallelSort() 비교
 * - 알고리즘 효율성은 같다. 시간 O(n log N), 공간 O(n)
 */
public class Main {
	public static void main(String[] args) {
		int size = 1500;
		int[] numbers = new int[size];
		Random random = new Random();
		IntStream.range(0, size).forEach(i -> numbers[i] = random.nextInt());

		long start = System.nanoTime();
		Arrays.sort(numbers);
		System.out.println("serial sorting took " + (System.nanoTime() - start));

		IntStream.range(0, size).forEach(i -> numbers[i] = random.nextInt());
		start = System.nanoTime();
		Arrays.parallelSort(numbers);
		System.out.println("parallel sorting took " + (System.nanoTime() - start));
	}
}
