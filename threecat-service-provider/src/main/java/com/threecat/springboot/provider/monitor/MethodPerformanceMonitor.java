package com.threecat.springboot.provider.monitor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class MethodPerformanceMonitor
{
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Pointcut("@annotation(com.threecat.springboot.provider.monitor.PerformanceMonitor)")
	public void pointcut()
	{
	}

	@Around("pointcut()")
	public void doMonitoring(ProceedingJoinPoint joinPoint)
	{
		//springboot别这样用，springmvc这样用可以?
		//ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
		//		.currentRequestAttributes();

		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();

		String monitorMethod =
				joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
		if (logger.isDebugEnabled())
		{
			logger.debug("url:" + request.getRequestURL().toString());
			logger.debug("http method:" + request.getMethod());
			logger.debug("ip:" + request.getRemoteAddr());
			logger.debug(
					"class method:" + monitorMethod);
			logger.debug("args:" + Arrays.toString(joinPoint.getArgs()));
		}
		long startTime = System.currentTimeMillis();
		try
		{
			joinPoint.proceed();
		}
		catch (Throwable throwable)
		{
			logger.error(throwable.getCause().getMessage());
		}
		long endTime = System.currentTimeMillis();
		logger.info("monitorMethod {} use {} ms.", monitorMethod, (startTime - endTime));
	}
}
