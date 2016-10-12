package com.gft.nodes;


/**
 * Created by jbki on 10/11/2016.
 */
public class NodeIterable implements Iterable<Node> {

    private Node root;

    public NodeIterable(Node root) {
        this.root = root;
    }

    @Override
    public NodeIterator iterator() {
        return new NodeIterator(root);
    }
}
