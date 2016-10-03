package com.gft.calendar.directory;

import java.util.Iterator;

/**
 * Created by jbki on 10/3/2016.
 */
public class DirectoryIterable implements Iterable<Leaf>{

    private Branch root;

    public DirectoryIterable(Branch root) {
        this.root = root;
    }

    @Override
    public Iterator iterator() {
        return new DirectoryIterator(root);
    }
}
