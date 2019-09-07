package com.threecat.springboot.provider.test;

public class IntegerMaxLoopTest
{
	public static void main(String[] args)
	{
		int start = Integer.MAX_VALUE - 10;
		int end = Integer.MAX_VALUE;
		int count = 0;
		for (int i = start; i <= end; i++)
		{
			count++;
		}
		System.out.println(count);
	}
}
