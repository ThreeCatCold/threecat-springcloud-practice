package com.threecat.springboot.sso.service.impl;

import com.threecat.springboot.commons.util.UUIDUtils;
import com.threecat.springboot.sso.entity.User;
import com.threecat.springboot.sso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@Override
	public User login(User user)
	{
		String sessionId = UUIDUtils.uuid();
		// TODO jackson转换
		String jsonUser = "";
		// TODO 过期时间是maxAge
		int expire = 10;
		ValueOperations<String, String> operation = redisTemplate.opsForValue();
		operation.set(sessionId, jsonUser, expire, TimeUnit.SECONDS);

		return null;
	}
}
