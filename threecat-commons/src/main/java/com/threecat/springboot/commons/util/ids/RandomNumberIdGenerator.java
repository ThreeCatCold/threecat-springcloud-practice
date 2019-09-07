package com.threecat.springboot.commons.util.ids;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 随机数id生成器
 * 有生成重复id的可能，Pass
 *
 */
@Deprecated
public class RandomNumberIdGenerator
{
	public static final ThreadLocalRandom THREAD_LOCAL_RANDOM = ThreadLocalRandom.current();

	public static String generateId()
	{
		return new SimpleDateFormat("yyyyMMddHHmmssSS").format(new Date())
		+ generateNumber(4);
	}

	private static String generateNumber(int bits)
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < bits; i++)
		{
			sb.append(THREAD_LOCAL_RANDOM.nextInt(9));
		}
		return sb.toString();
	}

	public static void main(String[] args)
	{
		for (int i = 0; i < 10; i++)
		{
			System.out.println(generateId());
		}
	}

}
