package com.gft.nodes;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;

public interface Node {
    void addChildNode(Node childNode);
    @NotNull
    LinkedList<Node> getChildNodes();
}
