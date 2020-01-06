package com.powerjun.springclound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2020/1/6.
 */
@RestController
public class ServiceDiscoveryController {

    @Autowired

    org.springframework.cloud.client.discovery.DiscoveryClient discoveryClient;

    @GetMapping("/services")
    public Set<String> services() {
        return new LinkedHashSet<>(discoveryClient.getServices());
    }

    @GetMapping("/services/{serviceName}")
    public List<ServiceInstance> getService(@PathVariable("serviceName") String serviceName) {
        return discoveryClient.getInstances(serviceName);
    }

}
