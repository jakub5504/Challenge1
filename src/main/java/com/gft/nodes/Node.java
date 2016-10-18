package com.gft.nodes;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public interface Node {
    @NotNull
    Iterator<Node> getChildNodes();
}
