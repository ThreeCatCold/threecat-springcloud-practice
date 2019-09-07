package com.threecat.springboot.commons.traceid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class TraceIdFilter extends OncePerRequestFilter
{
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
			FilterChain filterChain) throws ServletException, IOException
	{
		try
		{
			response.addHeader("X-TRACE-ID", UUID.randomUUID().toString());
			MDC.put("xtraceid", response.getHeader("X-TRACE-ID"));

			// logging each API call
			logger.info("API call: " + request.getMethod() + ": " + request.getRequestURI());

			// executing the request once the headers and trace-id modifications are done
			filterChain.doFilter(request, response);
		}
		finally
		{
			MDC.clear();
		}
	}
}
