package com.gft.nodes;

import org.jetbrains.annotations.NotNull;

public class NodeIterable implements Iterable<Node> {
    @NotNull
    private Node root;

    public NodeIterable(@NotNull Node root) {
        this.root = root;
    }

    @Override
    public NodeIterator iterator() {
        return new NodeIterator(root);
    }
}
