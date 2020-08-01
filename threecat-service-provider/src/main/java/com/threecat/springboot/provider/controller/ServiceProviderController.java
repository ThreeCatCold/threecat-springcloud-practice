package com.threecat.springboot.provider.controller;

import com.threecat.springboot.provider.aop.monitor.PerformanceMonitor;
import com.threecat.springboot.provider.aop.ratelimiter.TokenBucketRateLimiter;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceProviderController
{
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@PerformanceMonitor
	@TokenBucketRateLimiter
	@ApiOperation(value = "hello service", notes = "hello service")
	@GetMapping("/hello")
	public String hello()
	{
		logger.info("hello!");
		return "Hello, provider service.";
	}

	@PerformanceMonitor
	@TokenBucketRateLimiter
	@ApiOperation(value = "task process", notes = "query task process")
	@GetMapping("/task-process/{task-id}")
	public String taskProcess(@PathVariable("task-id") String taskId)
	{
		return "---";
	}
}
