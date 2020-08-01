package com.threecat.springboot.provider.aop.ratelimiter;

import com.google.common.util.concurrent.RateLimiter;
import org.apache.commons.io.IOUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 单服务限流，常用算法
 * （1）令牌桶：从桶里拿令牌，可处理突然的流量峰值
 * （2）漏桶：稳定处理，溢出的水（请求）舍弃
 * （3）计数器：一定时间内不超过请求上限
 *
 * 分布式限流：
 * （1）redis+lua
 */
@Component
@Aspect
@Scope
public class TokenBucketRateLimiterAop
{
	@Autowired
	private HttpServletRequest request;

	@Autowired
	private HttpServletResponse response;

	private RateLimiter rateLimiter = RateLimiter.create(5.0);

	/**
	 * 这种方式是直接以注解切入的方式来增加限流功能
	 * 如果想实现更复杂的功能，比如注解里新增一些说明，如超时时间，速率等，就可以以扫某个包下面的方法
	 * 然后读取注解中的配置的方式处理。
	 */
	@Pointcut("@annotation(TokenBucketRateLimiter)")
	public void pointcut()
	{
	}

	@Around("pointcut()")
	public void around(ProceedingJoinPoint joinPoint)
	{
		// 500ms尝试获取令牌，成功执行方法，失败降级处理。
		if (rateLimiter.tryAcquire(500, TimeUnit.MILLISECONDS))
		{
			try
			{
				joinPoint.proceed();
			}
			catch (Throwable throwable)
			{
				throwable.printStackTrace();
			}
			return;
		}

		System.out.println("request refused.");
		output("service rate limited!");
	}

	private void output(String msg)
	{
		response.setContentType("application/json;charset=UTF-8");
		ServletOutputStream os = null;
		try
		{
			os = response.getOutputStream();
			os.write(msg.getBytes());
			os.flush();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			IOUtils.closeQuietly(os);
		}

	}
}
