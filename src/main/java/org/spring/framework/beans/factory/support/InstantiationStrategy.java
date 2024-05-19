package org.spring.framework.beans.factory.support;

import org.spring.framework.beans.BeanException;
import org.spring.framework.beans.factory.config.BeanDefinition;

/**
 * 实例化策略
 *  org.springframework.beans.factory.support.InstantiationStrategy
 *
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition) throws BeanException;
}
