package org.spring.framework.core.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class URLResource implements Resource{

    private final URL url;

    public URLResource(URL url) {
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection connection = this.url.openConnection();
        try {
          return   connection.getInputStream();
        }catch (IOException e) {
            throw e;
        }
    }

}
