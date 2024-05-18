package org.spring.framework.beans.factory.support;

import org.spring.framework.beans.BeanException;
import org.spring.framework.beans.factory.BeanFactory;
import org.spring.framework.beans.factory.config.BeanDefinition;

/**
 *此处类似：org.springframework.beans.factory.config.AbstractFactoryBean
 * 单例模式获取Bean
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {


    @Override
    public Object getBean(String beanName) throws BeanException {
        Object bean = getSingleton(beanName);
        if (bean != null) {
            return bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(beanName);

        return createBean(beanName, beanDefinition);
    }

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeanException;

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeanException;

}
