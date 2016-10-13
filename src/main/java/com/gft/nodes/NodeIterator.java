package com.gft.nodes;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Created by jbki on 10/11/2016.
 */
public class NodeIterator implements Iterator<Node> {

    private LinkedList<Node> children = new LinkedList<>();
    private LinkedList<Node> tempChildren = new LinkedList<>();

    public NodeIterator(Node root) {
        this.children = root.getChildNodes();
    }

    @Override
    public boolean hasNext() {
        if (!children.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public Node next() {

            Node returnNode = findAndPushTheDeepestLeaf();
        if(returnNode.equals(null)){
            throw new NoSuchElementException();
        }
            return returnNode;
    }

    public Node findAndPushTheDeepestLeaf() {

        Node tempNode= new NodeImpl();
        if (!children.isEmpty()) {
            if (!children.get(0).getChildNodes().isEmpty()) {
                tempNode = children.get(0);
                tempChildren = children.get(0).getChildNodes();
                children.remove(0);
                children.addAll(0, tempChildren);

            }
            else if (children.get(0).getChildNodes().isEmpty()) {
                Node returnNode = children.get(0);
                children.remove(0);
                return returnNode;
            }
        }
        return tempNode;
    }

}
