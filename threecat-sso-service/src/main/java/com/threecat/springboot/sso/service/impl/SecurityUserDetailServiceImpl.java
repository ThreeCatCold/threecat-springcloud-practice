package com.threecat.springboot.sso.service.impl;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * spring security从数据库加载用户信息
 */
@Service
public class SecurityUserDetailServiceImpl implements UserDetailsService
{
	@Override public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		System.out.println("Authentication username:" + username);
		// 这里默认返回123密码
		return User.withUsername(username).password("123").authorities("p1").build();
	}
}
