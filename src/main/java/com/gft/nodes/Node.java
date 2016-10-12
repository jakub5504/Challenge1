package com.gft.nodes;

import java.util.LinkedList;

/**
 * Created by jbki on 10/11/2016.
 */
public interface Node {
    LinkedList<Node> children = new LinkedList<>();
    void addChildNode(Node childNode);
    LinkedList<Node> getChildNodes();
}
