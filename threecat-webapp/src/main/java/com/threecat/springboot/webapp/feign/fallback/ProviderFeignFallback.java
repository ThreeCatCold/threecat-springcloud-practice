package com.threecat.springboot.webapp.feign.fallback;

import com.threecat.springboot.webapp.feign.ServiceProviderFeignClient;

public class ProviderFeignFallback implements ServiceProviderFeignClient
{
	@Override public String queryTaskProcess(String taskId)
	{
		return "query task process failed.";
	}
}
