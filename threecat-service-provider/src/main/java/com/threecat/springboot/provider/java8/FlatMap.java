package com.threecat.springboot.provider.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 流的扁平化（合并？）
 */
public class FlatMap
{
	public static void main(String[] args)
	{
		//提取下列数组所有的不同字符
		String[] words = {"hello", "hi", "world"};

		Arrays.stream(words)
				// Stream<String[]>
				.map(word -> word.split(""))
				.flatMap(Arrays::stream)
				.distinct()
				.collect(Collectors.toList())
				.forEach(System.out::print);

		//找出下列2个数组中两数相加能被3整除的数对
		Integer[] intArray1 = {1, 3, 5};
		Integer[] intArray2 = {2, 3, 4, 6};

		List<Integer[]> intMap = Arrays.stream(intArray1)
				.flatMap(i -> Arrays.stream(intArray2)
						// Stream<Integer> filter
						.filter(j -> (i + j) % 3 == 0)
						// Stream<Integer[]>
						.map(j -> new Integer[]{i , j})
				).collect(Collectors.toList());
		intMap.forEach(x -> System.out.println(x[0] +"," + x[1]));
	}

}
