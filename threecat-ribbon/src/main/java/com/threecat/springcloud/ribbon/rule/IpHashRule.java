package com.threecat.springcloud.ribbon.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

public class IpHashRule extends AbstractLoadBalancerRule {
    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {

    }

    @Override
    public Server choose(Object key) {
        return doChoose(getLoadBalancer(), key);
    }

    private Server doChoose(ILoadBalancer lb, Object key) {
        // 可以参考其他的负载均衡算法，实现自定义算法

        return null;
    }
}
