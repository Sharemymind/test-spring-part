package org.spring.framework.beans.factory.support;

import com.sun.istack.internal.Nullable;
import org.spring.framework.core.io.DefaultResourceLoader;
import org.spring.framework.core.io.ResourceLoader;

/**
 * org.springframework.beans.factory.support.AbstractBeanDefinitionReader
 * 提供抽象的BeanDefinitionReader
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private final BeanDefinitionRegistry registry;

    @Nullable
    private ResourceLoader resourceLoader;


    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry,new DefaultResourceLoader());
    }

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }


    @Override
    public BeanDefinitionRegistry getRegistry() {
        return this.registry;
    }

    @Override
    public void loadBeanDefinitions(String[] locations) throws Exception {
        for (String location : locations) {
            loadBeanDefinitions(location);
        }
    }

    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return this.resourceLoader;
    }
}
