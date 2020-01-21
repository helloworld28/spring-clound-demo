package com.powerjun.springdemo.factorybeandemo.foo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author Jim
 * @date 2020/1/18
 */
public class FooFactoryBean implements FactoryBean {

    private static final Logger logger = LoggerFactory.getLogger(FooFactoryBean.class);


    private Class<?> type;

    @Override
    public Object getObject() throws Exception {
        logger.info("FooFactoryBean create foo...");

        return type.newInstance();
    }

    @Override
    public Class<?> getObjectType() {
        return type;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    public Class<?> getType() {
        return this.type;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }

}
