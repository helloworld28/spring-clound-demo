package com.powerjun.springdemo.factorybeandemo;

import com.powerjun.springdemo.factorybeandemo.foo.FooFactoryBeanRegister;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(FooFactoryBeanRegister.class)
public class FactoryBeanDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FactoryBeanDemoApplication.class, args);
    }

}
