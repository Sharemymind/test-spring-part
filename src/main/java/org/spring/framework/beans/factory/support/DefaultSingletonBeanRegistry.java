package org.spring.framework.beans.factory.support;

import org.spring.framework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * org.springframework.beans.factory.support.DefaultSingletonBeanRegistry
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    /**
     * 	private final Map<String, Object> singletonObjects = new ConcurrentHashMap<>(256);
     */
    private Map<String, Object> beanDefinitionMap = new HashMap<>();

    /**
     *  getSingleton(String beanName)
     * @param beanName
     * @return
     */
    @Override
    public Object getSingleton(String beanName) {
        return beanDefinitionMap.get(beanName);
    }

    /**
     *  addSingleton(String beanName, Object singletonObject)
     * @param beanName
     * @param beanDefinition
     */
    protected void addSingleton(String beanName, Object beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }


}
