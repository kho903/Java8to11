package com.jikim.completableFuture.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Executors
 * 고수준 (High-Level) Concurrency 프로그래밍
 * - 쓰레드를 만들고 관리하는 작업을 애플리케이션에서 분리
 * - 그런 기능을 Executors 에게 위임
 *
 * Executors 가 하는 일
 * - 쓰레드 만들기 : 애플리케이션이 사용할 쓰레드 풀을 만들어 관리한다.
 * - 쓰레드 관리 : 쓰레드 생명 주기를 관리한다.
 * - 작업 처리 및 실행 : 쓰레드로 실행할 작업을 제공할 수 있는 API 를 제공한다.
 *
 * 주요 인터페이스
 * - Executor : execute(Runnable)
 * - ExecutorService : Executor 상속 받은 인터페이스로, Callable 도 실행할 수 있으며,
 * 	 Executor 를 종료시키거나, 여러 Callable 을 동시에 실행하는 등의 기능을 제공한다.
 * - ScheduledExecutorService : ExecutorService 를 상속 받은 인터페이스로 특정 시간
 *   이후에 또는 주기적으로 작업을 실행할 수 있다.
 *
 * Fork / Join 프레임워크
 * - ExecutorService 의 구현체로 손쉽게 멀티 프로세서를 활용할 수 있게끔 도와준다.
 *
 */
public class Main {
	public static void main(String[] args) {
		/*
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		// executorService.execute(() -> {
		// 	System.out.println("Thread " + Thread.currentThread().getName())
		// });
		executorService.submit(() -> {
			System.out.println("Thread " + Thread.currentThread().getName())
		});
		// executorService.shutdown();
		executorService.shutdownNow();*/

		/*ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.submit(getRunnable("Hello"));
		executorService.submit(getRunnable("Keesun"));
		executorService.submit(getRunnable("The"));
		executorService.submit(getRunnable("Java"));
		executorService.submit(getRunnable("Thread"));*/

		ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
		executorService.schedule(getRunnable("Hello"), 3, TimeUnit.SECONDS);
		// executorService.scheduleAtFixedRate(getRunnable("Hello"), 1, 2, TimeUnit.SECONDS); // shutdown 빼고

		executorService.shutdown();

	}

	private static Runnable getRunnable(String message) {
		return () -> {
			System.out.println(message + Thread.currentThread().getName());
		};
	}
}
