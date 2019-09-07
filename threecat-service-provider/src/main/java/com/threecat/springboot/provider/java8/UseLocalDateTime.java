package com.threecat.springboot.provider.java8;

import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.Objects;

public class UseLocalDateTime
{
	public static void main(String[] args)
	{
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println(dateTime);
		Objects.isNull("");
	}
}
