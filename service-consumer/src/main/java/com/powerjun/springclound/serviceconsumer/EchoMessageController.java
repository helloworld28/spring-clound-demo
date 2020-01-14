package com.powerjun.springclound.serviceconsumer;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jim
 * @date 2020/1/13
 */
@RestController
public class EchoMessageController {


    @Autowired
    private EchoService echoService;


    @RequestMapping("/echoMessage/{message}")
    String echoMessage(@PathVariable String message) {
        return echoService.echoMessage(message);
    }
}
