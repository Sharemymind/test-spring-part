package org.spring.framework.beans.factory.support;

import org.spring.framework.beans.BeanException;
import org.spring.framework.beans.factory.config.BeanDefinition;

/**
 *  org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    /**
     * AbstractAutowireCapableBeanFactory.createBean
     * @param beanName
     * @param beanDefinition
     * @return
     * @throws BeanException
     */
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeanException {

        return doCreateBean(beanName, beanDefinition);
    }


    /**
     * AbstractAutowireCapableBeanFactory.doCreateBean
     * @param beanName
     * @param beanDefinition
     * @return
     */
    protected Object doCreateBean(String beanName, BeanDefinition beanDefinition) {
        Class beanClass = beanDefinition.getBeanClass();

        Object bean = null;
        try {
            bean = beanClass.newInstance();
        } catch (Exception e) {
            throw new BeanException("new instance bean failed", e);
        }

        addSingleton(beanName, bean);
        return bean;
    }

}
