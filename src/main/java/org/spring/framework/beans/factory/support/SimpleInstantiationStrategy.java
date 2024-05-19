package org.spring.framework.beans.factory.support;

import org.spring.framework.beans.BeanException;
import org.spring.framework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * org.springframework.beans.factory.support.SimpleInstantiationStrategy
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(BeanDefinition beanDefinition) throws BeanException {
        Class classes = beanDefinition.getBeanClass();
        try {
            Constructor constructor = classes.getDeclaredConstructor();
            return constructor.newInstance();
        } catch (Exception e) {
            throw new BeanException("Failed to instantiate [" + classes.getName() + "]", e);
        }
    }
}
