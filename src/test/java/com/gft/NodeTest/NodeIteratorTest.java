package com.gft.NodeTest;

import com.gft.nodes.Node;
import com.gft.nodes.NodeImpl;
import com.gft.nodes.NodeIterable;
import com.gft.nodes.NodeIterator;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by jbki on 10/11/2016.
 */
public class NodeIteratorTest {

    @Test
    public void shouldReturnFirstNode(){

        // given
        Node root = new NodeImpl();
        Node firstNode = new NodeImpl();
        Node secondNode = new NodeImpl();
        root.addChildNode(secondNode);
        root.addChildNode(firstNode);
        Node thirdNode = new NodeImpl();
        firstNode.addChildNode(thirdNode);

        // when
        NodeIterable nodeIterable = new NodeIterable(root);
        NodeIterator nodeIterator = nodeIterable.iterator();
        List<Node> nodes = Lists.newArrayList(nodeIterator);
        System.out.println(nodes.toString());
        // then
        assertThat(nodes.contains(firstNode));
        assertThat(nodes).contains(firstNode,thirdNode,secondNode);
        assertThat(nodes).hasSize(3);
    }
}
