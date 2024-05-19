package org.spring.framework.beans.factory.support;

import org.spring.framework.beans.BeanException;
import org.spring.framework.beans.factory.config.BeanDefinition;

/**
 * org.springframework.beans.factory.support.CglibSubclassingInstantiationStrategy
 *
 */
public class CglibSubclassingInstantiationStrategy extends SimpleInstantiationStrategy{

    @Override
    public Object instantiate(BeanDefinition beanDefinition) throws BeanException {
        return super.instantiate(beanDefinition);
    }
}
