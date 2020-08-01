package com.threecat.springcloud.ribbon.demo;

import com.threecat.springboot.commons.dto.BaseResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceChoose {

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    /**
     * @param hostName
     */
    public BaseResp<String> chooseHostAndVisit(String hostName, String serviceUrl) {
//        ServiceInstance serviceInstance = loadBalancerClient.choose(hostName);
//        String url = String.format("http://%s:%s" + serviceUrl, serviceInstance.getHost(), serviceInstance.getPort());
        return restTemplate.getForObject("spring-cloud-order-service", BaseResp.class);
    }
}
