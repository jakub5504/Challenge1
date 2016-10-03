package com.gft.calendar.directory;

import java.util.Iterator;
import java.util.List;

/**
 * Created by jbki on 10/3/2016.
 */
public class DirectoryIterator implements Iterator<Leaf> {

    List<Branch> branches;
    List<Leaf> leafs;

    public DirectoryIterator(Branch root) {
        this.branches = root.getBranches();
        this.leafs = root.getLeafs();
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Leaf next() {
        return null;
    }
}
