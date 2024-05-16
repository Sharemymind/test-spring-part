package org.spring.framework.beans.factory;

import java.util.HashMap;

public class BeanFactory {

    private HashMap<String,Object> beanMap = new HashMap<>();

    public void registerBean(String name,Object bean){
        beanMap.put(name,bean);
    }

    public Object getBean(String name){
        return beanMap.get(name);
    }
}
