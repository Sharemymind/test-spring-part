package org.spring.framework.core.io;


import java.net.MalformedURLException;
import java.net.URL;

public class DefaultResourceLoader implements ResourceLoader {
    private final String CLASS_PATH_RESOURCE_PREFIX = "classpath:";

    @Override
    public Resource getResource(String location) {
        if (location.startsWith(CLASS_PATH_RESOURCE_PREFIX)) {
            return new ClassPathResource(location.substring(CLASS_PATH_RESOURCE_PREFIX.length()));
        } else {
            try {
                URL url = new URL(location);
                return new URLResource(url);
            } catch (MalformedURLException e) {
                return new FileSystemResource(location);
            }
        }
    }
}
