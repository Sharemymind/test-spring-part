package org.spring.framework.beans.factory.config;

import cn.hutool.core.lang.Assert;
import com.sun.istack.internal.Nullable;

public class BeanDefinitionHolder {

    private final BeanDefinition beanDefinition;

    private final String beanName;

    @Nullable
    private final String[] aliases;


    public BeanDefinitionHolder(BeanDefinition beanDefinition, String beanName) {
        this(beanDefinition, beanName, null);
    }

    public BeanDefinitionHolder(BeanDefinition beanDefinition, String beanName, String[] aliases) {
        Assert.notNull(beanDefinition, "BeanDefinition must not be null");
        Assert.notNull(beanName, "Bean name must not be null");
        this.beanDefinition = beanDefinition;
        this.beanName = beanName;
        this.aliases = aliases;
    }
}
