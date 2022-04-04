package com.jikim.completableFuture;

public class Main {
	public static void main(String[] args) {
		Thread thread = new Thread(() -> {

			// while (true) {
			// 	System.out.println("Thread: " + Thread.currentThread().getName());
			// 	try {
			// 		Thread.sleep(1000L);
			// 	} catch (InterruptedException e) {
			// 		System.out.println("exit!");
			// 		return;
			// 	}
			// }
			System.out.println("Thread: " + Thread.currentThread().getName());
			try {
				Thread.sleep(1000L);
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
		});
		thread.start();

		System.out.println("Hello: " + Thread.currentThread().getName());
		// Thread.sleep(3000L);
		// thread.interrupt();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(thread + " is finished");
	}

}

/**
 * Concurrent 소프트웨어
 * - 동시에 여러 작업을 할 수 있는 소프트웨어
 *
 * 자바에서 지원하는 컨터런트 프로그래밍
 * - 멀티 프로세싱 (ProcessBuilder)
 * - 멀티 쓰레드
 *
 * 자바 멀티쓰레드 프로그래밍
 * - Thread / Runnable
 *
 * 쓰레드 주요 기능
 * - 현재 쓰레드 멈춰두기 (sleep)
 * 		- 다른 쓰레드가 처리할 수 있도록 기회를 주지만 그렇다고 락을 놔주진 않는다. (잘못하면 데드락)
 * - 다른 쓰레드 깨우기 (interrupt)
 * 		- 다른 쓰레드를 꺠워서 interruptedException을 발생시킨다.
 * 		- 그 에러가 발생했을 때 할 일은 코딩하기 나름. 종료 or 하던 일 게속
 * - 다른 쓰레드 기다리기 (join) : 다른 쓰레드가 끝날 때까지 기다린다.
 */
