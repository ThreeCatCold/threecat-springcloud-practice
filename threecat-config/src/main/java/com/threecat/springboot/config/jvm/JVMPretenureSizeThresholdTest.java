package com.threecat.springboot.config.jvm;

public class JVMPretenureSizeThresholdTest
{
	private static final int _1MB = 1024 * 1024;

	public static void createObjectBlock()
	{
		byte[] allocation1 = null;
		byte[] allocation2 = null;
		byte[] allocation3 = null;
		byte[] allocation4 = null;
		byte[] allocation5 = null;
		byte[] allocation6 = null;
		byte[] allocation7 = null;

		allocation1 = new byte[1 * _1MB];
		allocation2 = new byte[1 * _1MB];
		allocation3 = new byte[3 * _1MB];
		allocation4 = new byte[1 * _1MB];
		allocation5 = new byte[2 * _1MB];
		allocation6 = new byte[2 * _1MB];
		allocation7 = new byte[2 * _1MB];
	}

	public static void testPretenureSizeThreshold2()
	{
		byte[] allocation1 = null;
		byte[] allocation2 = null;
		byte[] allocation3 = null;
		allocation1 = new byte[1 * _1MB];
		allocation2 = new byte[1 * _1MB];
		allocation3 = new byte[3 * _1MB];
	}

	public static void testPretenureSizeThreshold3()
	{
		byte[] allocation4 = null;
		byte[] allocation5 = null;
		allocation4 = new byte[1 * _1MB];
		allocation5 = new byte[2 * _1MB];
	}

	public static void testPretenureSizeThreshold4()
	{
		byte[] allocation6 = null;
		byte[] allocation7 = null;
		allocation6 = new byte[2 * _1MB];
		allocation7 = new byte[2 * _1MB];
	}


	public static void main(String[] args) throws InterruptedException
	{
		System.out.println("Main method started.");
		int i = 1000;
		long startTime = System.currentTimeMillis();
		while(i > 0)
		{
			createObjectBlock();
//			testPretenureSizeThreshold2();
//			testPretenureSizeThreshold3();
//			testPretenureSizeThreshold4();
			--i;
		}
		System.out.println("Use time:" + (System.currentTimeMillis() - startTime) + "ms");
	}
}
