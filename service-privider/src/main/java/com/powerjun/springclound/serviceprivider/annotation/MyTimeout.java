package com.powerjun.springclound.serviceprivider.annotation;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2020/2/8.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
@Documented
public @interface MyTimeout {
    long value();

    TimeUnit timeUnit() default TimeUnit.MICROSECONDS;

    String fallbackMethod() default "";
}
