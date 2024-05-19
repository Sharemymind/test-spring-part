package org.spring.framework.beans.factory.config;


import org.spring.framework.beans.PropertyValues;

/**
 * org.springframework.beans.factory.config.BeanDefinition
 */
public class BeanDefinition {

    private Class beanClass;

    private PropertyValues propertyValue;

    public BeanDefinition(Class beanClass) {
        this(beanClass, null);
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValue) {
        this.beanClass = beanClass;
        this.propertyValue = propertyValue;
    }

    public PropertyValues getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(PropertyValues propertyValue) {
        this.propertyValue = propertyValue;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
