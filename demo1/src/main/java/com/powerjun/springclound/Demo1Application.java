package com.powerjun.springclound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.lang.annotation.*;
import java.util.Map;

@SpringBootApplication
public class Demo1Application implements ApplicationRunner {

    @Autowired
    private Map<String, String> allStrings;


    //加了Qulifier注解后，就只会取@Qualifier注解的Bean
    @Autowired
    @Qualifier
    private Map<String, String> subStrings;

    @Autowired
    @MyTag
    private Map<String, String> myTagStrings;

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }


    @Bean
    public String buildStringA() {
        return "String-A";
    }

    @Bean
    @Qualifier
    public String buildStrinB() {
        return "String - B";
    }

    @Bean
    @Qualifier
    public String buildStringC() {
        return "String - C";
    }

    @Bean
    @MyTag
    public String buildStringD() {
        return "String - D";
    }

    @Bean
    @MyTag
    public String buildStringE() {
        return "String - E";
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("allStrings->" + allStrings);
        System.out.println("subStrings->" + subStrings);
        System.out.println("myTagStrings->" + myTagStrings);
    }


    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Inherited
    @Qualifier
    public @interface MyTag {
        String value() default "";
    }
}
