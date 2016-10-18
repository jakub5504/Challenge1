package com.gft.nodes;


import com.google.common.collect.Lists;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public final class NodeIterator implements Iterator<Node> {

    private final  LinkedList<Node> knownDescendants = new LinkedList<>();

    NodeIterator(@NotNull Node root) {
        this.knownDescendants.addAll(Lists.newArrayList(root.getChildNodes()));
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
        knownDescendants.addAll(0, Lists.newArrayList(node.getChildNodes()));
        return node;
    }

}
