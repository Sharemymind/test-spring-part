package org.spring.framework.test;

import org.junit.Test;
import org.spring.framework.beans.factory.config.BeanDefinition;
import org.spring.framework.beans.factory.support.DefaultListableBeanFactory;

public class BeanDefinitionAndRegistry {


    @Test
    public void testBeanDefinitionAndRegistry() {
        DefaultListableBeanFactory beanFactroy = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(TestSimpleBeanFactory.class);
        beanFactroy.registerBeanDefinition("testSimpleBeanFactory", beanDefinition);
        TestSimpleBeanFactory testSimpleBeanFactory = (TestSimpleBeanFactory) beanFactroy.getBean("testSimpleBeanFactory");
        testSimpleBeanFactory.testCreateBean();
    }

}
