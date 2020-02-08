package com.powerjun.springclound.serviceprivider;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.powerjun.springclound.serviceprivider.annotation.MyTimeout;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author Jim
 * @date 2020/1/13
 */
@RestController
public class EchoController {

    @HystrixCommand(
            fallbackMethod = "fallback",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.strategy", value = "THREAD"),
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "50")
            })
    @GetMapping("/echoMessage/{message}")
    public String echoMessage(@PathVariable String message) {

        try {
            Thread.sleep(new Random().nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "ECHO:" + message;
    }

    public String fallback(String message) {
        return "Fallback " + message;
    }

    @MyTimeout(value = 50L, fallbackMethod = "fallback")
    @GetMapping("/foo/{message}")
    public String foo(@PathVariable String message) {
        try {
            Thread.sleep(new Random().nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "foo " + message;
    }
}
