package com.threecat.springboot.commons.util;

import com.threecat.springboot.commons.constant.CommonConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class CookieUtils
{
	private static Logger logger = LoggerFactory.getLogger(CookieUtils.class);

	/**
	 * 获取cookie值
	 *
	 * @param request
	 * @param cookieName
	 */
	public static void getCookieValue(HttpServletRequest request, String cookieName)
	{
		getCookieValue(request, cookieName, true, CommonConstant.UTF_8);
	}

	/**
	 * 获取cookie值
	 *
	 * @param request    http请求
	 * @param cookieName cookie名称
	 * @param isDecode   是否解码
	 * @param charset    字符集
	 * @return
	 */
	public static String getCookieValue(HttpServletRequest request, String cookieName, boolean isDecode, String charset)
	{
		Cookie[] cookies = request.getCookies();
		if (CommonUtils.isEmpty(cookies) || CommonUtils.isEmpty(cookieName))
		{
			return null;
		}

		String value = null;
		try
		{
			for (Cookie cookie : cookies)
			{
				if (cookieName.equals(cookie.getName()))
				{
					value = isDecode ? URLDecoder.decode(cookie.getValue(), charset) : cookie.getValue();
					break;
				}
			}
		}
		catch (UnsupportedEncodingException e)
		{
			logger.error("CookieUtils.getCookieValue:" + e);
		}

		return value;
	}

	/**
	 * 设置cookie
	 *
	 * @param request  request请求
	 * @param response response答复
	 * @param name     cookie name
	 * @param value    cookie value
	 * @param maxAge   cookie存活时间
	 * @param isEncode 是否编码
	 * @param charset  字符集
	 * @return
	 */
	private static void doSetCookie(HttpServletRequest request, HttpServletResponse response, String name, String value,
			int maxAge, boolean isEncode, String charset)
	{
		if (CommonUtils.isEmpty(name))
		{
			logger.error("CookieUtils.setCookie: empty cookie name!");
			return;
		}
		if (CommonUtils.isEmpty(value))
		{
			value = "";
		}
		try
		{
			value = isEncode ? URLEncoder.encode(value, charset) : value;
		}
		catch (UnsupportedEncodingException e)
		{
			logger.error("CookieUtils.setCookie:" + e);
			return;
		}
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(maxAge);
		String domain = getDomain(request);
		cookie.setDomain(domain);
		cookie.setPath("/");
		response.addCookie(cookie);

	}

	/**
	 * 删除指定cookie
	 * @param request
	 * @param response
	 * @param cookieName
	 */
	public static void delCookie(HttpServletRequest request, HttpServletResponse response, String cookieName)
	{
		doSetCookie(request, response, cookieName, "", -1, false, null);
	}

	/**
	 * 设置cookie
	 * @param request
	 * @param response
	 * @param cookieName
	 * @param cookieValue
	 * @param maxAge
	 */
	public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName,
             String cookieValue, int maxAge)
	{
		doSetCookie(request, response, cookieName, cookieValue, maxAge, true, CommonConstant.UTF_8);
	}

	public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName,
			String cookieValue, int maxAge, String charset)
	{
		doSetCookie(request, response, cookieName, cookieValue, maxAge, true, charset);
	}



	/**
	 * 获取域名
	 *
	 * @param request
	 * @return
	 */
	private static String getDomain(HttpServletRequest request)
	{
		String domain = null;
		String serverUrl = request.getRequestURL().toString();

		// TODO debug流程
		if (!CommonUtils.isEmpty(serverUrl))
		{
			serverUrl = serverUrl.toLowerCase().substring(7);
			int end = serverUrl.indexOf("/");
			serverUrl = serverUrl.substring(0, end);
			String[] domains = serverUrl.split("\\.");
			int len = domains.length;
			if (len > 3)
			{
				// www.xxx.com.cn
				domain = "." + domains[len - 3] + "." + domains[len - 2] + "." + domains[len - 1];
			}
			else if (len <= 3 && len > 1)
			{
				// xxx.com or xxx.cn
				domain = "." + domains[len - 2] + "." + domains[len - 1];
			}
			else
			{
				domain = serverUrl;
			}
		}
		else
		{
			domain = "";
		}
		return domain;
	}
}
