package com.jikim.completableFuture.callable_future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Callable / Future
 * Callable
 * - Runnable 과 유사하지만, 작업의 결과를 받을 수 있다.
 * Future
 * - 비동기적인 작업의 현재 상태를 조회하거나 결과를 가져올 수 있다.
 *
 * 결과를 가져오기 get()
 * - 블록킹 콜이다.
 * - 타임아웃(최대한으로 기다릴 시간)을 설정할 수 있다.
 *
 * 작업 상태 확인하기 isDone()
 * - 완료했으면 true, 아니면 false 리턴
 *
 * 작업 취소하기 cancel()
 * - 취소했으면 true, 못했으면 false를 리턴한다.
 * - parameter 로 true 를 전달하면 현재 진행중인 쓰레드를 interrupt 하고
 *   그러지 않으면 현재 진행중인 작업이 끝날 때까지 기다린다.
 *
 * 여러 작업 동시에 실행하기 invokeAll()
 * - 동시에 실행한 작업 중에 제일 오래 걸리는 작업 만큼 시간이 걸린다.
 *
 * 여러 작업 중에 하나라도 먼저 응답이 오면 끝내기 invokeAny()
 * - 동시에 실행한 작업 중에 제일 짧게 걸리는 작업 만큼 시간이 걸린다.
 * - 블록킹 콜이다.
 */
public class Main {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ExecutorService executorService = Executors.newSingleThreadExecutor();

		Callable<String> hello = () -> {
			Thread.sleep(2000L);
			return "Hello";
		};

		Future<String> helloFuture = executorService.submit(hello);
		System.out.println(helloFuture.isDone());

		System.out.println("Started!");

		// helloFuture.get(); // 블로킹 콜, 타임아웃(최대한으로 기다릴 시간)을 설정할 수 있다.
		helloFuture.cancel(false); // 취소

		System.out.println(helloFuture.isDone());

		helloFuture.get(); // 취소 후에 예외

		System.out.println("End!");

		executorService.shutdown();
	}
}
