package org.spring.framework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import org.spring.framework.beans.BeanException;
import org.spring.framework.beans.PropertyValue;
import org.spring.framework.beans.factory.config.BeanDefinition;
import org.spring.framework.beans.factory.config.BeanReference;

/**
 *  org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    //创建bean实例
    private InstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }


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

        Object bean = null;
        try {
            //修改获取实例的方式
            bean = createBeanInstance(beanDefinition);
            //初始化填充属性
            applayPropertyValues(beanDefinition, bean, beanName);
        } catch (Exception e) {
            throw new BeanException("new instance bean failed", e);
        }
        //添加到单例
        addSingleton(beanName, bean);
        return bean;
    }

    protected void applayPropertyValues(BeanDefinition beanDefinition, Object bean,String beanName){
        for (PropertyValue propertyValue : beanDefinition.getPropertyValue().getPropertyValues()) {

            String name = propertyValue.getName();
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference) {
                BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getBeanName());
            }

            BeanUtil.setFieldValue(bean, name, value);
        }
    }


    protected Object createBeanInstance(BeanDefinition beanDefinition){
       return getInstantiationStrategy().instantiate(beanDefinition);
    }

}
