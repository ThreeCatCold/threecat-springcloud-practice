package com.threecat.springboot.provider.aop.ratelimiter;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Component
@Aspect
@Scope
public class RedisRateLimiterAop
{
	@Autowired
	private HttpServletRequest request;

	@Autowired
	private HttpServletResponse response;

	@Autowired
	private StringRedisTemplate redisTemplate;

	private DefaultRedisScript<List> script;

	@PostConstruct
	public void init()
	{
		script = new DefaultRedisScript<>();
		script.setResultType(List.class);
		script.setScriptSource(new ResourceScriptSource(new ClassPathResource("/lua/ratelimit.lua")));
	}

	@Pointcut("@annotation(RedisRateLimiter)")
	public void pointcut()
	{
	}
}
