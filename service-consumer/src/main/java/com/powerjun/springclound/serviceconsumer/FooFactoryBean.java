package com.powerjun.springclound.serviceconsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author Jim
 * @date 2020/1/18
 */
public class FooFactoryBean implements FactoryBean {

    private static final Logger logger = LoggerFactory.getLogger(FooFactoryBean.class);

    @Override
    public Object getObject() throws Exception {
        logger.info("FooFactoryBean create foo...");

        return new FooBean();
    }

    @Override
    public Class<?> getObjectType() {
        return FooBean.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }


}
