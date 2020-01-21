package com.powerjun.springclound.serviceconsumer;

import org.springframework.stereotype.Component;

/**
 * @author Jim
 * @date 2020/1/17
 */
@Component
public class EchoServiceFallbackHandler implements EchoService {


    @Override
    public String echoMessage(String message) {
        System.out.println("time out!!!!!!!!!!!");
        return "this time out fallback!";
    }
}
