package com.threecat.springboot.provider.java8;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
