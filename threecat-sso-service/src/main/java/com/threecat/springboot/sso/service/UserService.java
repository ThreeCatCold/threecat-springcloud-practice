package com.threecat.springboot.sso.service;

import com.threecat.springboot.sso.entity.User;

public interface UserService
{
	User login(User user);
}
