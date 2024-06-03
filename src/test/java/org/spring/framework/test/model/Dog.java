package org.spring.framework.test.model;

public class Dog {
    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public Dog() {
        System.out.println("Dog 无参构造");
    }

    public Dog(String name, Integer age) {
        this.name = name;
        this.age = age;
        System.out.println("Dog 有参构造");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
