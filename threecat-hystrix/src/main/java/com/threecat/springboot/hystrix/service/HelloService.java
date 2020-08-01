package com.threecat.springboot.hystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import com.netflix.hystrix.exception.HystrixBadRequestException;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Future;

@Service
public class HelloService
{
	@Autowired
	private RestTemplate restTemplate;

	private String url = "http://service-provider/hello";

	@HystrixCommand(fallbackMethod = "helloFallback", ignoreExceptions = HystrixBadRequestException.class)
	public String hello()
	{
		return restTemplate.getForObject(url, String.class);
	}

	@HystrixCommand
	public Future<String> helloAsync()
	{
		return new AsyncResult<String>()
		{
			@Override public String invoke()
			{
				return restTemplate.getForObject(url, String.class);
			}
		};
	}

	/**
	 * 这里也有可能失败，所以二度降级
	 * @return
	 */
	@HystrixCommand(fallbackMethod = "helloFallback2")
	private String helloFallback(Throwable t)
	{
		return "hello, fallback!" + t.getMessage();
	}

	private String helloFallback2()
	{
		return "hello, fallback2!";
	}
}
