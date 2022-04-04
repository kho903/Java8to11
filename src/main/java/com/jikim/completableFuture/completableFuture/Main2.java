package com.jikim.completableFuture.completableFuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

/**
 * 조합하기
 * - thenCompose() : 두 작업이 서로 이어서 실행하도록 조합
 * - thenCombine() : 두 작업을 독립적으로 실행하고 둘 다 종료 했을 때 콜백 실행
 * - allOf() : 여러 작업을 모두 실행하고 모든 작업 결과에 콜백 실행
 * - anyOf() : 여러 작업 중에 가장 빨리 끝난 하나의 결과에 콜백 실행
 *
 * 예외 처리
 * - exceptionally(Function)
 * - handle(BiFunction)
 */
public class Main2 {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
			System.out.println("Hello" + Thread.currentThread().getName());
			return "Hello";
		});

		// CompletableFuture<String> future = hello.thenCompose(Main2::getWorld);
		// System.out.println(future.get());

		CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
			System.out.println("World " + Thread.currentThread().getName());
			return "World";
		});

		// CompletableFuture<String> future2 = hello.thenCombine(world, (h, w) -> h + " " + w);
		// System.out.println(future2.get());

		List<CompletableFuture<String>> futures = Arrays.asList(hello, world);
		CompletableFuture[] futuresArray = futures.toArray(new CompletableFuture[futures.size()]);
		CompletableFuture<List<String>> results = CompletableFuture.allOf(futuresArray)
			.thenApply(v -> futures.stream()
				.map(CompletableFuture::join)
				.collect(Collectors.toList()));

		// results.get().forEach(System.out::println);

		CompletableFuture<Void> future3 = CompletableFuture.anyOf(hello, world)
			.thenAccept((s) -> System.out.println(s));
		future3.get();


		boolean throwError = true;

		CompletableFuture<String> hello2 = CompletableFuture.supplyAsync(() -> {
			if (throwError) {
				throw new IllegalStateException();
			}
			System.out.println("Hello" + Thread.currentThread().getName());
			return "Hello";
		})/*.exceptionally(ex -> {
			System.out.println(ex);
			return "Error!";
		});*/
		.handle((result, ex) -> {
			if (ex != null) {
				System.out.println(ex);
				return "ERROR!";
			}
			return result;
		});

		System.out.println(hello2.get());

	}

	private static CompletableFuture<String> getWorld(String message) {
		return CompletableFuture.supplyAsync(() -> {
			System.out.println("World " + Thread.currentThread().getName());
			return message + " World";
		});
	}
}
