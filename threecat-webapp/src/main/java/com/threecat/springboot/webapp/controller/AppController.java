package com.threecat.springboot.webapp.controller;

import com.threecat.springboot.webapp.feign.ServiceProviderFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController
{
	@Autowired
	private ServiceProviderFeignClient providerFeignClient;

	@GetMapping("/task-process/{task-id}")
	public String queryTaskProcess(@PathVariable("task-id") String taskId)
	{
		return providerFeignClient.queryTaskProcess(taskId);
	}
}
