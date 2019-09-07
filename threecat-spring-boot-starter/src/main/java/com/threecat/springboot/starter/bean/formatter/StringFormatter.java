package com.threecat.springboot.starter.bean.formatter;

public class StringFormatter implements Formatter
{
	@Override public <T> String format(T t)
	{
		return "StringFormatter:" + t.toString();
	}
}
