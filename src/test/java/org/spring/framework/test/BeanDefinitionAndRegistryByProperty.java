package org.spring.framework.test;

import org.spring.framework.beans.factory.support.DefaultListableBeanFactory;
import org.spring.framework.test.model.Dog;
import org.spring.framework.test.model.Person;
import org.junit.Test;
import org.spring.framework.beans.PropertyValue;
import org.spring.framework.beans.PropertyValues;
import org.spring.framework.beans.factory.config.BeanDefinition;
import org.spring.framework.beans.factory.config.BeanReference;

public class BeanDefinitionAndRegistryByProperty {

    @Test
    public void testBeanDefinitionAndRegistry() {
        DefaultListableBeanFactory def = new DefaultListableBeanFactory();

        PropertyValues propertyValues = new PropertyValues();
        PropertyValue age = new PropertyValue("age", "3");
        PropertyValue name = new PropertyValue("name", "BigDog");

        propertyValues.addPropertyValue(age);
        propertyValues.addPropertyValue(name);

        BeanDefinition beanDefinition = new BeanDefinition(Dog.class,propertyValues);

        def.registerBeanDefinition("dog", beanDefinition);
        Dog dog = (Dog) def.getBean("dog");
        System.out.println(dog);
    }


    @Test
    public void testBeanDefinitionAndRegistry2() {
        DefaultListableBeanFactory  def = new DefaultListableBeanFactory();
        PropertyValues propertyValues = new PropertyValues();
        PropertyValue age = new PropertyValue("age", "3");
        PropertyValue name = new PropertyValue("name", "BigDog");

        propertyValues.addPropertyValue(age);
        propertyValues.addPropertyValue(name);
        BeanDefinition dogBeanDefinition = new BeanDefinition(Dog.class,propertyValues);
        def.registerBeanDefinition("dog", dogBeanDefinition);

        PropertyValues personPropertyValues = new PropertyValues();
        PropertyValue personAge = new PropertyValue("age", "18");
        PropertyValue personName = new PropertyValue("name", "BigPerson");
        PropertyValue personDog = new PropertyValue("dog",new BeanReference("dog"));

        personPropertyValues.addPropertyValue(personAge);
        personPropertyValues.addPropertyValue(personName);
        personPropertyValues.addPropertyValue(personDog);
        BeanDefinition personBeanDefinition = new BeanDefinition(Person.class,personPropertyValues);
        def.registerBeanDefinition("person", personBeanDefinition);
        Person person = (Person) def.getBean("person");
        System.out.println(person);
    }
}
