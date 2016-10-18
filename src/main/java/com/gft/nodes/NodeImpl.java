package com.gft.nodes;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.LinkedList;


public class NodeImpl implements Node {
    private LinkedList<Node> children = new LinkedList<>();

    public NodeImpl() {

    }

    public void addChildNode(Node childNode) {
        children.add(childNode);
    }


    @Override
    @NotNull
    public Iterator<Node> getChildNodes(){
        return children.iterator();
    }

}
