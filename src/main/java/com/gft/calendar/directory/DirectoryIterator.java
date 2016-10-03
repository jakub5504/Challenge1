package com.gft.calendar.directory;

import java.io.File;
import java.nio.file.Path;
import java.util.Iterator;

/**
 * Created by jbki on 10/3/2016.
 */
public class DirectoryIterator implements Iterator<File> {

    public DirectoryIterator(Path path) {
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public File next() {
        return null;
    }
}
