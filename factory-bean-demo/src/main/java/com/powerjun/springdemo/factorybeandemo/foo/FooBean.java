package com.powerjun.springdemo.factorybeandemo.foo;

/**
 * @author Jim
 * @date 2020/1/18
 */
@FooAnnotation
public class FooBean {
    public String echoMessage(String message) {
        return "ECHO:" + message;
    }
}
