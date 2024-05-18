package org.spring.framework.beans.factory.support;

import org.spring.framework.beans.BeanException;
import org.spring.framework.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 *org.springframework.beans.factory.support.DefultListableBeanFactroy
 */
public class DefultListableBeanFactroy extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    /**
     * private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256);
     */
    private final Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws BeanException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new BeanException("No bean named '" + beanName + "' is defined");
        }
        return beanDefinition;
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }
}
