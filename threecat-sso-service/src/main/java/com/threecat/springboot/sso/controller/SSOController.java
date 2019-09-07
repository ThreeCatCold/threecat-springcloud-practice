package com.threecat.springboot.sso.controller;

import com.threecat.springboot.sso.service.SSOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/sso")
@RestController
public class SSOController
{
	@Autowired
	private SSOService ssoService;

	@PostMapping("/check-token")
	public void checkTokenNew(@RequestBody String token)
	{
			// TODO 1.加解密 2.基于redis的SSO 3.mysql 4.分布式事务
	}
}
