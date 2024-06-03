package org.spring.framework.test;

import cn.hutool.core.io.IoUtil;
import org.junit.Test;
import org.spring.framework.core.io.DefaultResourceLoader;
import org.spring.framework.core.io.Resource;

import java.io.InputStream;

public class TestResourceLoader {
    @Test
    public void test() throws Exception {
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:TestClassPath");
        InputStream inputStream = resource.getInputStream();
        String s = IoUtil.readUtf8(inputStream);
        System.out.println(s);

        resource = resourceLoader.getResource("src/test/resources/TestClassPath");
        inputStream = resource.getInputStream();
        String testSource = IoUtil.readUtf8(inputStream);
        System.out.println(testSource);

        resource = resourceLoader.getResource("https://www.baidu.com");
        inputStream = resource.getInputStream();
        String testSource2 = IoUtil.readUtf8(inputStream);
        System.out.println(testSource2);
    }
}
