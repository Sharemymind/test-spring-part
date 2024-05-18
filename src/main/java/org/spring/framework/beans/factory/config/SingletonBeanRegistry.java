package org.spring.framework.beans.factory.config;

/**
 * SingletonBeanRegistry
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);
}
