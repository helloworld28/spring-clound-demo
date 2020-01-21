package com.powerjun.springclound.serviceconsumer;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

/**
 * 使用Lookup注解
 * 减少applicationContext到业务代码里去
 *
 * @author Jim
 * @date 2020/1/17
 */
@Component
public abstract class AbstractEchoService {


    public String echoMessage(String message) {
        return getEchoService().echoMessage(message);
    }

    @Lookup
    abstract EchoService getEchoService();
}
