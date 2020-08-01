package com.threecat.springboot.provider.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ErrorControllerAdvice
{
	@ExceptionHandler(NoHandlerFoundException.class)
	public String pageNotFound(HttpStatus status, HttpServletRequest request, Throwable t)
	{
		Map<String, Object> errors = new HashMap<>();
		return "/404.html";
	}
}
