package com.threecat.springcloud.ribbon.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

    @Autowired
    private ServiceChoose serviceChoose;

    @GetMapping("/ribbon")
    public void goRibbonSource() {
        serviceChoose.chooseHostAndVisit("hostName", "serviceUrl");
    }
}
