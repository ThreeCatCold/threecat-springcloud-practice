package com.threecat.springboot.webapp.controller;

import com.alibaba.fastjson.JSONObject;
import com.threecat.springboot.webapp.feign.ServiceProviderFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
public class AppController
{
	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private LoadBalancerClient balancerClient;
	@Autowired
	private ServiceProviderFeignClient providerFeignClient;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/task-process/{task-id}")
	public String queryTaskProcess(@PathVariable("task-id") String taskId)
	{
		return providerFeignClient.queryTaskProcess(taskId);
	}

	@GetMapping("/services")
	public String showServices()
	{
		List<String> services = discoveryClient.getServices();
		return JSONObject.toJSONString(services);
	}

	@GetMapping("/choose/{service}-{path}")
	public String loadBalanceService(@NotNull @PathVariable("service") String service, @NotNull @PathVariable("path") String path)
	{
		ServiceInstance serviceInstance = balancerClient.choose(service);
		String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/" + path;
//		restTemplate.getForObject(url, String.class);
		return url;
	}
}
