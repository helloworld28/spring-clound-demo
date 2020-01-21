package com.powerjun.springclound.serviceconsumer;

import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Jim
 * @date 2020/1/13
 */

@FeignClient(value = "service-provider", fallback = EchoServiceFallbackHandler.class)
public interface EchoService {

    @RequestMapping(method = RequestMethod.GET, value = "/echoMessage/{message}")
    String echoMessage(@PathVariable("message") String message);


}


