package com.gft.nodes;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class NodeIterator implements Iterator<Node> {

    private LinkedList<Node> knownDescendants = new LinkedList<>();

    NodeIterator(@NotNull Node root) {
        this.knownDescendants = root.getChildNodes();
    }
    public boolean hasNext() {
        return !knownDescendants.isEmpty();
    }

    public Node next() {
        if (knownDescendants.isEmpty()) {
            throw new NoSuchElementException();
        }
        Node node = knownDescendants.get(0);
        knownDescendants.remove(0);
        knownDescendants.addAll(0, node.getChildNodes());
        return node;
    }

}
