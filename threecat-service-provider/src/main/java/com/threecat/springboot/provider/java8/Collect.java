package com.threecat.springboot.provider.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Collect
{
	public static void main(String[] args)
	{
		List<String> strList = new ArrayList<>(Arrays.asList(new String[]{"1", "1", "2", "3"}));
		Map<Integer, List<String>> map = strList.stream().collect(Collectors.groupingBy(Integer::valueOf));
		map.forEach((k, v)->{
			v.forEach(v1 -> {
				System.out.println(k + "," + v1);
			});
		});
	}
}
