package com.threecat.springboot.sso.controller;

import com.threecat.springboot.commons.dto.BaseResult;
import com.threecat.springboot.sso.entity.User;
import com.threecat.springboot.sso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController
{
	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public BaseResult<User> login(@RequestHeader("Referer") String url, Model model, @RequestBody User user)
	{
		BaseResult<User> result = new BaseResult<>();

		// 登录成功页面回跳
//		model.addAttribute("redirect", url);
		return result;
	}
}
