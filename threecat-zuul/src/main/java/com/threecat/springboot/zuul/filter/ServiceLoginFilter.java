package com.threecat.springboot.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义过滤器
 */
@Component
public class ServiceLoginFilter extends ZuulFilter
{
	/**
	 * 过滤器类型
	 * pre
	 * routing
	 * post
	 * error
	 * @return
	 */
	@Override public String filterType()
	{
		return "pre";
	}

	/**
	 * 指定过滤器执行优先级（顺序），值越小执行优先级越高
	 * @return
	 */
	@Override public int filterOrder()
	{
		return 1;
	}

	/**
	 * 当前过滤器是否生效
	 * @return
	 */
	@Override public boolean shouldFilter()
	{
		return true;
	}

	/**
	 * 执行过滤器中的业务逻辑
	 * @return
	 * @throws ZuulException
	 */
	@Override public Object run() throws ZuulException
	{
		// 获取zuul提供的上下文对象RequestContext
		RequestContext rc = RequestContext.getCurrentContext();

		// 从RequestContext中获取request
		HttpServletRequest request = rc.getRequest();

		// 获取token的请求参数，这里假设token从url里获取，而不是Set-Cookie
		String token = request.getParameter("token");

		// 判断token，token为null与token!=null，分别判断
		if (token == null)
		{
			// 拦截请求
			rc.setSendZuulResponse(false);
			rc.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
		}
		else
		{
			// do check token
		}

		return null;
	}
}
