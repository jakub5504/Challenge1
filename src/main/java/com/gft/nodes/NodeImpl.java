package com.gft.nodes;

import java.util.LinkedList;

/**
 * Created by jbki on 10/11/2016.
 */
public class NodeImpl implements Node {

    public NodeImpl() {

    }

    @Override
    public void addChildNode(Node childNode) {
        children.add(childNode);
    }

    @Override
    public LinkedList<Node> getChildNodes(){
        return children;
    }

}
