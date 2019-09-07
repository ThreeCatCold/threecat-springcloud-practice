package com.threecat.springboot.provider.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicPerformanceTest
{
	private static AtomicInteger atomicMaxValue = new AtomicInteger(0);

	private static int maxValue = 0;

	public static void recordMaxValueAtomic(int newValue)
	{
		atomicMaxValue.getAndAccumulate(newValue, (left, right) -> {return left > right ? left : right;});
	}

	public synchronized static void recordMaxValue(int newValue)
	{
		maxValue = newValue > maxValue ? newValue : maxValue;
	}

	public static void main(String[] args) throws Exception
	{
		int threadCount = 1000000;
		int threadPoolSize = Runtime.getRuntime().availableProcessors();

		testAtomic(threadCount, threadPoolSize, true);
		testAtomic(threadCount, threadPoolSize, false);
	}

	public static void testAtomic(int threadCount, int poolSize, boolean useAtomic) throws Exception
	{
		CountDownLatch latch = new CountDownLatch(threadCount);
		ExecutorService threadPool = Executors.newFixedThreadPool(poolSize);
		long start = System.currentTimeMillis();
		for (int i = 0; i < threadCount; i++)
		{
			final int temp = i;
			threadPool.submit(()->{
				if (useAtomic)
				{
					recordMaxValueAtomic(temp);
				}
				else
				{
					recordMaxValue(temp);
				}
				latch.countDown();
			});
		}
		latch.await();
		long end = System.currentTimeMillis();

		System.out.println("MaxValue:" + (useAtomic ? atomicMaxValue.get() : maxValue));
		System.out.println("UseAtomic: " + useAtomic);
		System.out.println("ThreadCount: " + threadCount + ", PoolSize: " + poolSize);
		System.out.println("Use Time: " + (end - start) + "ms.");
		System.out.println();
		threadPool.shutdown();
	}
}
