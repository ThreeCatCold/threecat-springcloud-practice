package com.threecat.springboot.sso.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.plugin.liveconnect.SecurityContextHelper;

@RestController
public class PathAuthController
{
	@GetMapping(value = "/path1", produces = "text/plain;charset=UTF-8")
	public String path1()
	{
		return "access path1";
	}

	@GetMapping(value = "/path2", produces = "text/plain;charset=UTF-8")
	public String path2()
	{
		return "access path2";
	}

	private String getUsernameFromSecurityHolder()
	{
		String username = null;
		// 当前认证通过的用户身份
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		// 用户身份
		Object principal = authentication.getPrincipal();

		if (principal == null)
		{
			username = "anonymous user";
		}

		if (principal instanceof UserDetails)
		{
			username = ((UserDetails)principal).getUsername();
		}
		else
		{
			username = principal.toString();
		}

		return username;
	}
}
