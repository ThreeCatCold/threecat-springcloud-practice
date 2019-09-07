package com.threecat.springboot.webapp.feign;

import com.threecat.springboot.webapp.feign.config.FeignConfig;
import com.threecat.springboot.webapp.feign.fallback.ProviderFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-provider", configuration = FeignConfig.class,
		fallback = ProviderFeignFallback.class)
public interface ServiceProviderFeignClient
{
	@GetMapping("/service-provider/task-process/{task-id}") String queryTaskProcess(
			@PathVariable("task-id") String taskId);
}
