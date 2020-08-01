package com.threecat.springboot.provider.aop.log;

import com.threecat.springboot.commons.util.IpUtils;
import com.threecat.springboot.provider.config.AppConfig;
import com.threecat.springboot.provider.service.LogRecordService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.net.util.IPAddressUtil;

/**
 * 基于aop的日志记录实现，参考：https://mp.weixin.qq.com/s/bs9vmUSbEbOf44rjd2r7zA
 */
//@Component
@Aspect
@Slf4j
public class OperationLogAop
{
	@Autowired
	private LogRecordService recordService;

	@Autowired
	private AppConfig appConfig;

	private String ip = IpUtils.ip();

	/**
	 * 此处有bug
	 */
	@Pointcut("@annotation(LogRecord) && execution(public * com.threecat.springboot.provider.controller..*.*(..))")
	public void pointcut()
	{
	}

	@Around(value = "pointcut()", argNames = "joinPoint, record")
	public Object around(ProceedingJoinPoint joinPoint, LogRecord record)
	{
		Object result = null;
		try
		{
			result = joinPoint.proceed();
		}
		catch (Throwable throwable)
		{
			throwable.printStackTrace();
		}
		return result;
	}
}
