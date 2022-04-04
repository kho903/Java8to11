package com.jikim.completableFuture.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** CompletableFuture
 * 자바에서 비동기 (Asynchronous) 프로그래밍을 가능케하는 인터페이스.
 * - Future 를 사용해서도 어느정도 가능했지만 하기 힘든 일들이 많았다.
 *
 * Future 로는 하기 어렵던 작업들
 * - Future 를 외부에서 완료 시킬 수 없다. 취소하거나, get()에 타임아웃을 설정할 수는 있다.
 * - 블로킹 코드 (get())를 사용하지 않고서는 작업이 끝났을 때 콜백을 실행할 수는 없다.
 * - 여러 Future를 조합할 수 없다. 예) Event 정보 가져온 다음 Event에 참석하는 회원 목록 가져오기
 * - 예외 처리용 API를 제공하지 않는다.
 *
 * CompletableFuture
 * - Implements Future
 * - Implements CompletionStage
 *
 * 비동기로 작업 실행하기
 * - 리턴값이 없는 경우 : runAsync()
 * - 리턴값이 있는 경우 : supplyAsync()
 * - 원하는 Executor (쓰레드풀)를 사용해서 실행할 수도 있다. (기본은 ForkJoinPool.commonPool())
 *
 * 콜백 제공하기
 * - thenApply(Function) : 리턴값을 받아서 다른 값으로 바꾸는 콜백
 * - thenAccept(Consumer) : 리턴값을 또 다른 작업을 처리하는 콜백 (리턴없이)
 * - thenRun(Runnable) : 리턴값을 받지 않고 다른 작업을 처리하는 콜백
 * - 콜백 자체를 또 다른 쓰레드에서 실행할 수 있다.
 */
public class Main {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		CompletableFuture<String> future = new CompletableFuture<>();
		future.complete("keesun");

		System.out.println(future.get());

		CompletableFuture<String> future1 = CompletableFuture.completedFuture("keesun");
		System.out.println(future1.get());

		CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
			System.out.println("Hello " + Thread.currentThread().getName());
		});

		future2.get();

		CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
			System.out.println("Hello " + Thread.currentThread().getName());
			return "Hello";
		});
		System.out.println(future3.get());

		CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() -> {
			System.out.println("Hello " + Thread.currentThread().getName());
			return "Hello";
		}).thenApply((s) -> {
			System.out.println(Thread.currentThread().getName());
			return s.toUpperCase();
		});
		System.out.println(future4.get());

		CompletableFuture<Void> future5 = CompletableFuture.supplyAsync(() -> {
			System.out.println("Hello " + Thread.currentThread().getName());
			return "Hello";
		}).thenAccept((s) -> {
			System.out.println(Thread.currentThread().getName());
			System.out.println(s.toUpperCase());
		});
		future5.get();

		CompletableFuture<Void> future6 = CompletableFuture.supplyAsync(() -> {
			System.out.println("Hello " + Thread.currentThread().getName());
			return "Hello";
		}).thenRun(() -> {
			System.out.println(Thread.currentThread().getName());
		});
		future6.get();

		ExecutorService executorService = Executors.newFixedThreadPool(4);
		CompletableFuture<Void> future7 = CompletableFuture.supplyAsync(() -> {
			System.out.println("Hello " + Thread.currentThread().getName());
			return "Hello";
		}, executorService).thenRunAsync(() -> {
			System.out.println(Thread.currentThread().getName());
		}, executorService);
		future7.get();
		executorService.shutdown();
	}
}
