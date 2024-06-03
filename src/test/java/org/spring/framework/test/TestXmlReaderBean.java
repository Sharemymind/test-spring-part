package org.spring.framework.test;

import org.junit.Test;
import org.spring.framework.beans.factory.support.DefaultListableBeanFactory;
import org.spring.framework.beans.factory.support.XmlBeanDefinitionReader;
import org.spring.framework.test.model.Dog;
import org.spring.framework.test.model.Person;

public class TestXmlReaderBean {

    @Test
    public void testXmlReaderBean(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        try {
            int i = beanDefinitionReader.loadBeanDefinitions("classpath:spring.xml");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        Person person = (Person) beanFactory.getBean("person");
        System.out.println(person.getName());
        System.out.println(person.getAge());
        System.out.println(person.getDog());

        Dog dog = (Dog) beanFactory.getBean("dog");
        System.out.println(dog.getName());
        System.out.println(dog.getAge());
    }
}
