package com.threecat.springboot.starter.bean.formatter;

public interface Formatter
{
	<T> String format(T t);
}
