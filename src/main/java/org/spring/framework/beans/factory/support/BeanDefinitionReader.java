package org.spring.framework.beans.factory.support;

import org.spring.framework.core.AliasRegistry;
import org.spring.framework.core.io.Resource;
import org.spring.framework.core.io.ResourceLoader;

/**
 * org.springframework.beans.factory.support.BeanDefinitionReader
 * 定义BeanDefinition的基类读取接口
 */
public interface BeanDefinitionReader extends AliasRegistry {

    BeanDefinitionRegistry getRegistry();

    int loadBeanDefinitions(String location) throws Exception;

    int loadBeanDefinitions(Resource resource) throws Exception;

    void loadBeanDefinitions(String[] locations) throws Exception;

    ResourceLoader getResourceLoader();
}
