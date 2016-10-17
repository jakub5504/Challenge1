package com.gft.directory;

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
