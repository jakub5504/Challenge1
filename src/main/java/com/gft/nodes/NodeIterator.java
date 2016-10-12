package com.gft.nodes;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by jbki on 10/11/2016.
 */
public class NodeIterator implements Iterator<Node> {

    private LinkedList<Node> children = new LinkedList<>();

    public NodeIterator(Node root) {
        this.children = root.getChildNodes();
    }

    @Override
    public boolean hasNext() {
        if(!children.isEmpty()){
            return true;
        }
        return false;
    }

    @Override
    public Node next() {
        Node returnNode = children.get(0);
        children.remove(0);
        return returnNode;
    }
}
