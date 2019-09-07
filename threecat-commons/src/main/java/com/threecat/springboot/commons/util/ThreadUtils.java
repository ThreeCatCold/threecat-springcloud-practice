package com.threecat.springboot.commons.util;

import java.util.concurrent.TimeUnit;

public class ThreadUtils
{
	public static void sleep(long milliseconds)
	{
		try
		{
			TimeUnit.MILLISECONDS.sleep(milliseconds);
		}
		catch (InterruptedException e)
		{
			// do nothing
		}
	}
}
