package com.gft.nodes;

import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class NodeIterator implements Iterator<Node> {

    private LinkedList<Node> children = new LinkedList<>();

    NodeIterator(Node root) {
        this.children = root.getChildNodes();
    }

    @Override
    public boolean hasNext() {
        return !children.isEmpty();
    }

    @Override
    public Node next() {

        Node returnNode = findAndPushTheDeepestLeaf();
        if (returnNode == null) {
            throw new NoSuchElementException();
        }
        return returnNode;
    }

    @Nullable
    private Node findAndPushTheDeepestLeaf() {
        if (children.isEmpty()) {
            return null;
        }

        Node node = children.get(0);
        children.remove(0);
        children.addAll(0, node.getChildNodes());
        return node;
    }

}
