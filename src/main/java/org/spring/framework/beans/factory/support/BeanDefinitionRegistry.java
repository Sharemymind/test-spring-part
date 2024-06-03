package org.spring.framework.beans.factory.support;

import org.spring.framework.beans.factory.config.BeanDefinition;

/**
 * org.springframework.beans.factory.support.BeanDefinitionRegistry
 */
public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    boolean containsBeanDefinition(String beanName);
}
