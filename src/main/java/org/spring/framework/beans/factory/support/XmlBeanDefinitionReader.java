package org.spring.framework.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import org.spring.framework.beans.BeanException;
import org.spring.framework.beans.PropertyValue;
import org.spring.framework.beans.PropertyValues;
import org.spring.framework.beans.factory.config.BeanDefinition;
import org.spring.framework.beans.factory.config.BeanReference;
import org.spring.framework.core.io.DefaultResourceLoader;
import org.spring.framework.core.io.Resource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.InputStream;

/**
 * org.springframework.beans.factory.xml.XmlBeanDefinitionReader
 *  将xml文件解析成BeanDefinition,包含类定义和属性定义
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public static final String BEAN_ELEMENT = "bean";
    public static final String PROPERTY_ELEMENT = "property";
    public static final String ID_ATTRIBUTE = "id";
    public static final String NAME_ATTRIBUTE = "name";
    public static final String CLASS_ATTRIBUTE = "class";
    public static final String VALUE_ATTRIBUTE = "value";
    public static final String REF_ATTRIBUTE = "ref";


    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }


    @Override
    public int loadBeanDefinitions(String location) throws Exception {
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        return loadBeanDefinitions(resource);
    }

    @Override
    public int loadBeanDefinitions(Resource resource) throws Exception {
        if (resource != null) {
            InputStream inputStream = resource.getInputStream();

            try {
                doLoadBeanDefinitions(inputStream);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                inputStream.close();
            }
        }
        return 0;
    }


    private int doLoadBeanDefinitions(InputStream inputStream) {
        Document document = XmlUtil.readXML(inputStream);
        Element root = document.getDocumentElement();
        NodeList childNodes = root.getChildNodes();
        if (childNodes.getLength() > 0) {
            for (int i = 0; i < childNodes.getLength(); i++) {
                if (childNodes.item(i) instanceof Element) {
                    if (BEAN_ELEMENT.equals(childNodes.item(i).getNodeName())) {

                        //bean的基础属性
                        Element beanElement = (Element) childNodes.item(i);
                        String id = beanElement.getAttribute(ID_ATTRIBUTE);
                        String name = beanElement.getAttribute(NAME_ATTRIBUTE);
                        String className = beanElement.getAttribute(CLASS_ATTRIBUTE);
                        //反射获取类
                        Class<?> clazz = null;
                        try {
                            clazz = Class.forName(className);
                        } catch (ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        //获取beanName
                        String beanName = StrUtil.isNotEmpty(id) ? id : name;

                        if (StrUtil.isEmpty(beanName)) {
                            beanName = StrUtil.lowerFirst(clazz.getSimpleName());
                        }
                        //创建BeanDefinition
                        BeanDefinition beanDefinition = new BeanDefinition(clazz);
                        //获取属性
                        for (int j = 0; j < beanElement.getChildNodes().getLength(); j++) {
                            if (beanElement.getChildNodes().item(j) instanceof Element) {
                                if (PROPERTY_ELEMENT.equals(beanElement.getChildNodes().item(j).getNodeName())) {
                                    Element propertyElement = (Element) beanElement.getChildNodes().item(j);
                                    String propertyName = propertyElement.getAttribute(NAME_ATTRIBUTE);
                                    String propertyValue = propertyElement.getAttribute(VALUE_ATTRIBUTE);
                                    String propertyRef = propertyElement.getAttribute(REF_ATTRIBUTE);

                                    //获取属性值
                                    Object valueObject = propertyValue;
                                    if (StrUtil.isNotEmpty(propertyRef)) {
                                        valueObject = new BeanReference(propertyRef);
                                    }
                                    PropertyValue propertyValueRef = new PropertyValue(propertyName, valueObject);
                                    PropertyValues propertyValues = beanDefinition.getPropertyValue();
                                    propertyValues.addPropertyValue(propertyValueRef);
                                    beanDefinition.setPropertyValue(propertyValues);
                                }
                            }
                        }
                        //判断bean是否被其他类占用
                        if (getRegistry().containsBeanDefinition(beanName)) {
                            throw new BeanException("Duplicate beanName[" + beanName + "] is not allowed");
                        }
                        //注册bean
                        getRegistry().registerBeanDefinition(beanName, beanDefinition);
                    }

                }

            }
        }
        return 0;
    }

}
