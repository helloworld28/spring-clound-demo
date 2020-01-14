package com.powerjun.springclound.serviceprivider;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jim
 * @date 2020/1/13
 */
@RestController
public class EchoController {

    @GetMapping("/echoMessage/{message}")
    public String echoMessage(@PathVariable String message) {
        return "ECHO:" + message;
    }
}
