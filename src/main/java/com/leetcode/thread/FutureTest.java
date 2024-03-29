package com.leetcode.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author: wangwu
 * @Date: Created in 18:50 2021/07/13
 * @Description:
 */
public class FutureTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Callable<Long> callable = new Callable<Long>() {
			@Override
			public Long call() throws Exception {

				long start = System.currentTimeMillis();
				Thread.sleep(100);
				long end = System.currentTimeMillis();

				long seed = end - start;
				System.out.println("seed=" + seed);

				return seed;
			}
		};

		List<Callable<Long>> tasks = new ArrayList<>();
		tasks.add(callable);
		tasks.add(callable);
		tasks.add(callable);
		tasks.add(callable);
		tasks.add(callable);
		tasks.add(callable);
		tasks.add(callable);
		tasks.add(callable);
		tasks.add(callable);
		tasks.add(callable);

		int poolSize = Runtime.getRuntime().availableProcessors();
		System.out.println("poolSize=" + poolSize);
		ExecutorService executorService = Executors.newFixedThreadPool(poolSize);
		List<Future<Long>> futures = executorService.invokeAll(tasks);

		long result = 0;
		for (Future<Long> future : futures) {
			result += future.get();
		}
		System.out.println("result=" + result);
		executorService.shutdown();
	}


}
