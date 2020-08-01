package com.threecat.springcloud.ribbon.ping;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.Server;

public class HeartbeatPing implements IPing {
    @Override
    public boolean isAlive(Server server) {
        System.out.println("心跳ping发送");
        return true;
    }
}
