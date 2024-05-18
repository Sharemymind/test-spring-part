package org.spring.framework.beans.factory;

import org.spring.framework.beans.BeanException;

/**
 * BeanFactory
 */
public interface BeanFactory {

    Object getBean(String beanName) throws BeanException;
}
