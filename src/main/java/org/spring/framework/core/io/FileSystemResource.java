package org.spring.framework.core.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileSystemResource extends AbstractResource {

    private final String path;

    public FileSystemResource(String path) {
        this.path = path;
    }


    @Override
    public InputStream getInputStream() throws IOException {
        Path filePath = new File(this.path).toPath();
        return Files.newInputStream(filePath);
    }

}
