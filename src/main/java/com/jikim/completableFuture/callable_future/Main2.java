package com.jikim.completableFuture.callable_future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main2 {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newSingleThreadExecutor();

		Callable<String> hello = () -> {
			Thread.sleep(2000L);
			return "Hello";
		};

		Callable<String> java = () -> {
			Thread.sleep(3000L);
			return "Java";
		};

		Callable<String> keesun = () -> {
			Thread.sleep(1000L);
			return "Keesun";
		};

		List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello, java, keesun));
		for (Future<String> f : futures) {
			System.out.println(f.get());
		}

		String s = executorService.invokeAny(Arrays.asList(hello, java, keesun));
		System.out.println(s);

		executorService.shutdown();

	}
}
