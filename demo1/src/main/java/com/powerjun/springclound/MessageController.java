package com.powerjun.springclound;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019/12/30.
 */
@RefreshScope
@RestController
public class MessageController {
    @Value("${message2:Hello deault!}")
    private String message2;


    @Value("${message:Hello deault!}")
    private String message;

    @GetMapping("/message")
    public String getMessage() {
        return message;
    }
    @GetMapping("/message2")
    public String getMessage2() {
        return message2;
    }


}
