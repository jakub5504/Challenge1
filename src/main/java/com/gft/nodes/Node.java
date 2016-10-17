package com.gft.nodes;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;

public interface Node {
    @NotNull
    LinkedList<Node> getChildNodes();
}
