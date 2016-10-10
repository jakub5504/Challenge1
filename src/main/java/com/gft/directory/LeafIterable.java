package com.gft.directory;

/**
 * Created by jbki on 10/3/2016.
 */
public class LeafIterable implements Iterable<Leaf>{

    private Branch root;

    public LeafIterable(Branch root) {
        this.root = root;
    }

    @Override
    public LeafIterator iterator() {
        return new LeafIterator(root);
    }
}
