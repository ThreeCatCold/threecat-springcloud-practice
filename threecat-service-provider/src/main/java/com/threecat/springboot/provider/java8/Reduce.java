package com.threecat.springboot.provider.java8;

import java.util.Arrays;
import java.util.Optional;

public class Reduce
{
	public static void main(String[] args)
	{
		// 使用流求和
		Integer[] intArray = {1, 2, 3, 7, 8};
		// 其中0为初始值
		int sum1 = Arrays.stream(intArray).reduce(0, (a,b) -> a+b);
		int sum2 = Arrays.stream(intArray).reduce(0, Integer::sum);

		// 求最大值
		Optional<Integer> max = Arrays.stream(intArray).reduce(Integer::max);

	}
}
