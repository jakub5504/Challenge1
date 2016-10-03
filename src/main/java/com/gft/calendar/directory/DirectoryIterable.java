package com.gft.calendar.directory;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by jbki on 10/3/2016.
 */
public class DirectoryIterable implements Iterable<File>{

    private Path path = Paths.get("C:\\test");

    @Override
    public DirectoryIterator iterator() {
        return new DirectoryIterator(path);
    }
}
