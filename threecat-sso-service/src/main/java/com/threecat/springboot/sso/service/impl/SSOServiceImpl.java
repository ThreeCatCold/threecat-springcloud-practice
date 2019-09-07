package com.threecat.springboot.sso.service.impl;

import com.threecat.springboot.sso.service.SSOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class SSOServiceImpl implements SSOService
{
	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@Override
	public boolean checkTokenNew(String token)
	{
		return false;
	}

	@Override public boolean saveToken(String token)
	{
		return false;
	}
}
