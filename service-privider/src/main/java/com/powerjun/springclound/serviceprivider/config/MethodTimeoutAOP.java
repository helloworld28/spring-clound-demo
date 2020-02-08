package com.powerjun.springclound.serviceprivider.config;

import com.powerjun.springclound.serviceprivider.annotation.MyTimeout;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.*;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2020/2/8.
 */
@Configuration
@Aspect
public class MethodTimeoutAOP {

    ExecutorService executorService = Executors.newCachedThreadPool();

    @Around(" @annotation(com.powerjun.springclound.serviceprivider.annotation.MyTimeout)")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {

        Object[] args = pjp.getArgs();

        String name = pjp.getSignature().getName();

        Class[] classes = Stream.of(pjp.getArgs())
                .map(Object::getClass)
                .toArray(Class[]::new);

        Method method = pjp.getTarget().getClass().getMethod(name, classes);
        MyTimeout annotation = method.getAnnotation(MyTimeout.class);
        if (annotation != null) {
            Future<Object> future = executorService.submit(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    try {
                        return pjp.proceed(args);
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                    return null;
                }
            });
            try {
               return future.get(annotation.value(), annotation.timeUnit());
            } catch (TimeoutException e) {
                return invokeFallBackMethod(pjp.getTarget(), method, annotation.fallbackMethod(), args);
            }

        } else {
            return pjp.proceed();
        }
    }


    private Object invokeFallBackMethod(Object bean, Method method, String fallbackName, Object[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method fallbackMethod = bean.getClass().getMethod(fallbackName, method.getParameterTypes());
        return fallbackMethod.invoke(bean, args);
    }
}
