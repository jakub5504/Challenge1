package com.gft.directory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by jbki on 10/3/2016.
 */
public class DirectoryIterator implements Iterator<Leaf> {

    List<Branch> branches = new ArrayList<>();
    List<Leaf> leafs= new ArrayList<>();
    int index = 0;

    public DirectoryIterator(Branch root) {
        this.branches = root.getBranches();
        this.leafs = root.getLeafs();
    }

    @Override
    public boolean hasNext() {
        if(!branches.isEmpty()){
            DirectoryIterable dirIterable = new DirectoryIterable(branches.get(0));
            DirectoryIterator dirIterator = dirIterable.iterator();
            dirIterator.hasNext();
        }
        else if (!leafs.isEmpty()){

        }
        return true;
    }

    @Override
    public Leaf next() {

        return leafs.get(index++);

    }
}
