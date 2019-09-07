package com.threecat.springboot.redpacket.test;

import com.threecat.springboot.redpacket.util.IdGenerator;

public class IdGeneratorTest
{
	public static void main(String[] args)
	{
		long start = System.currentTimeMillis();

		int count = 1000;
		for (int i = 0; i < count; i++)
		{
			System.out.println(IdGenerator.nextId());
		}

		long end = System.currentTimeMillis();
		System.out.println("count:" + count);
		System.out.println("use:" + (end - start) + "ms");
	}
}
