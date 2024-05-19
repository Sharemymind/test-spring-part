package org.spring.framework.beans.factory.config;

/**
 * org.springframework.beans.factory.config.RuntimeBeanReference
 * 代表对另外一个bean的引用，引用的bean在容器中是存在的，但是在容器中还没有实例化，所以需要一个beanName来引用
 *
 */
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
