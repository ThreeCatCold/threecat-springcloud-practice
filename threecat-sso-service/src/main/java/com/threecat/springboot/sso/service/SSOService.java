package com.threecat.springboot.sso.service;

public interface SSOService
{
	boolean checkTokenNew(String token);

	boolean saveToken(String token);
}
