package com.threecat.springcloud.ribbon.openfeign;

import com.threecat.springboot.commons.dto.BaseReq;
import com.threecat.springcloud.ribbon.openfeign.service.RemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    private RemoteService remoteService;

    @GetMapping("/remote-invoke")
    public String remoteApiInvoke() {
        return remoteService.remoteApiInvoke(new BaseReq<>()).getData();
    }
}
