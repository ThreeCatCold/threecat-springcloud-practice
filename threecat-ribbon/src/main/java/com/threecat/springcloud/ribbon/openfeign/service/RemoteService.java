package com.threecat.springcloud.ribbon.openfeign.service;

import com.threecat.springboot.commons.dto.BaseReq;
import com.threecat.springboot.commons.dto.BaseResp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("remote-service-name")
public interface RemoteService {

    @GetMapping("remote-api")
    BaseResp<String> remoteApiInvoke(BaseReq<String> request);
}
