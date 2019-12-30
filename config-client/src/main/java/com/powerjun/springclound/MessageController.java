package com.powerjun.springclound;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019/12/30.
 */
@RestController
public class MessageController {

    @GetMapping("/getMessage")
    public String getMessage() {
        return "";
    }

}
