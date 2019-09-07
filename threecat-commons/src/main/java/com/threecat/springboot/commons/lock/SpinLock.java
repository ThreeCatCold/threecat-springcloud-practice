package com.threecat.springboot.commons.lock;

import java.util.concurrent.atomic.AtomicReference;

public class SpinLock
{
	private AtomicReference<Thread> ref = new AtomicReference<>();

	public void lock()
	{
		Thread t = Thread.currentThread();
		while(!ref.compareAndSet(null, t)){};
	}

	public void unlock()
	{
		Thread t = Thread.currentThread();
		ref.compareAndSet(t, null);
	}
}
