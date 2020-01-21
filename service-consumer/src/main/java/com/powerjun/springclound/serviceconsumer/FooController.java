package com.powerjun.springclound.serviceconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jim
 * @date 2020/1/19
 */
@RestController
@RequestMapping("/foo")
public class FooController {

    @Autowired
    private FooBean fooBean;

    @GetMapping("/{message}")
    public String bar(@PathVariable String message) {
        return fooBean.echoMessage(message);
    }

}
