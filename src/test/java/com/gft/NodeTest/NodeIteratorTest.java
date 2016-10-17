package com.gft.NodeTest;

import com.gft.nodes.Node;
import com.gft.nodes.NodeImpl;
import com.gft.nodes.NodeIterable;
import com.gft.nodes.NodeIterator;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

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

        // when
        NodeIterable nodeIterable = new NodeIterable(root);
        NodeIterator nodeIterator = nodeIterable.iterator();
        List<Node> nodes = Lists.newArrayList(nodeIterator);
        // then
        //assertThat(nodes.contains(firstNode));
        assertThat(nodes).contains(firstNode,secondNode);
        //assertThat(nodes).hasSize(3);
    }

    @Test
    public void shoudlReturnNoNodeForTreeWithJustEmptyBranchesAndSubbranches2() {
        // given
        Node root = new NodeImpl();
        Node branchOne = new NodeImpl();
        Node branchTwo = new NodeImpl();
        root.addChildNode(branchOne);
        root.addChildNode(branchTwo);
        Node branchThree = new NodeImpl();
        Node branchFour = new NodeImpl();
        Node branchFive = new NodeImpl();
        Node branchSix = new NodeImpl();
        branchOne.addChildNode(branchThree);
        branchOne.addChildNode(branchFour);
        branchTwo.addChildNode(branchFive);
        branchTwo.addChildNode(branchSix);

        // when
        NodeIterable dirIterable = new NodeIterable(root);
        NodeIterator dirIterator = dirIterable.iterator();
        List<Node> Nodes = Lists.newArrayList(dirIterator);

        // then
        assertThat(Nodes).containsOnly(branchOne,branchTwo, branchThree,branchFour,branchFive,branchSix);
    }

    @Test
    public void shouldReturnAllNodesForTwiceHasnext(){
        Node root = new NodeImpl();
        Node nodeOne = new NodeImpl();
        Node nodeTwo = new NodeImpl();
        root.addChildNode(nodeOne);
        root.addChildNode(nodeTwo);
        NodeIterable nodeIterable = new NodeIterable(root);
        NodeIterator nodeIterator = nodeIterable.iterator();
        System.out.println(nodeIterator.next());

        assertThat(nodeIterator.next(),is(equalTo(nodeTwo)));


    }

    @Test
    public void shouldReturnAllNodesFromRootandSubroots(){

        // given
        Node root = new NodeImpl();
        Node branchOne = new NodeImpl();
        Node branchTwo = new NodeImpl();
        Node branchThree = new NodeImpl();
        root.addChildNode(branchOne);
        root.addChildNode(branchTwo);
        root.addChildNode(branchThree);
        Node NodeOne = new NodeImpl();
        Node NodeTwo = new NodeImpl();
        branchOne.addChildNode(NodeOne);
        branchTwo.addChildNode(NodeTwo);
        Node branchFour = new NodeImpl();
        branchThree.addChildNode(branchFour);
        Node NodeThree = new NodeImpl();
        Node NodeFour = new NodeImpl();
        branchFour.addChildNode(NodeThree);
        branchFour.addChildNode(NodeFour);

        // when
        NodeIterable dirIterable = new NodeIterable(root);
        NodeIterator dirIterator = dirIterable.iterator();
        List<Node> Nodes = Lists.newArrayList(dirIterator);

        System.out.println(Nodes.toString());
        // then
        assertThat(Nodes,containsInAnyOrder(branchOne,branchTwo,branchThree,branchFour,NodeOne,NodeTwo,NodeThree,NodeFour));
    }

    @Test
    public void shouldReturnAllNodesFromMoreThenTwoBranchesInRoot(){

        // given
        Node root = new NodeImpl();
        Node branchOne = new NodeImpl();
        Node branchTwo = new NodeImpl();
        Node branchThree = new NodeImpl();
        root.addChildNode(branchOne);
        root.addChildNode(branchTwo);
        root.addChildNode(branchThree);
        Node NodeOne = new NodeImpl();
        Node NodeTwo = new NodeImpl();
        Node NodeThree = new NodeImpl();
        branchOne.addChildNode(NodeOne);
        branchTwo.addChildNode(NodeTwo);
        branchThree.addChildNode(NodeThree);

        // when
        NodeIterable dirIterable = new NodeIterable(root);
        NodeIterator dirIterator = dirIterable.iterator();
        List<Node> Nodes = Lists.newArrayList(dirIterator);

        //then
        assertThat(Nodes,containsInAnyOrder(branchOne,branchTwo,branchThree,NodeOne,NodeTwo,NodeThree));

    }

    @Test
    public void shouldReturnNodesFromTwoBranchesInRoot(){

        // given
        Node root = new NodeImpl();
        Node BranchOne = new NodeImpl();
        Node BranchTwo = new NodeImpl();
        root.addChildNode(BranchOne);
        root.addChildNode(BranchTwo);
        Node NodeOne = new NodeImpl();
        Node NodeTwo = new NodeImpl();
        BranchOne.addChildNode(NodeTwo);
        BranchTwo.addChildNode(NodeOne);

        // when
        NodeIterable dirIterable = new NodeIterable(root);
        NodeIterator dirIterator = dirIterable.iterator();
        List<Node> Nodes = Lists.newArrayList(dirIterator);

        // then
        assertThat(Nodes,containsInAnyOrder(BranchOne, BranchTwo,NodeOne,NodeTwo));
    }

    @Test
    public void shouldReturnEmptyListForRootDirectoryWithoutNodesAndBranches(){

        // given
        Node root = new NodeImpl();

        // when
        NodeIterable dirIterable = new NodeIterable(root);
        NodeIterator dirIterator = dirIterable.iterator();
        List<Node> Nodes = Lists.newArrayList(dirIterator);

        // then
        assertThat(Nodes.isEmpty(),equalTo(true));
    }

    @Test
    public void shouldReturnNewlyCreatedNode(){

        // given
        Node root = new NodeImpl();
        Node NodeOne = new NodeImpl();
        root.addChildNode(NodeOne);

        // when
        NodeIterable dirIterable = new NodeIterable(root);
        NodeIterator dirIterator = dirIterable.iterator();
        List<Node> Nodes = Lists.newArrayList(dirIterator);

        // then
        assertThat(Nodes.get(0), equalTo(NodeOne));
        assertThat(Nodes.get(0), is(NodeOne));
        assertThat(Nodes.get(0), is(equalTo(NodeOne)));
    }

    @Test
    public void shouldReturnAllNodesFromRootDirectory(){

        // given
        Node root = new NodeImpl();
        Node NodeOne = new NodeImpl();
        Node NodeTwo = new NodeImpl();
        root.addChildNode(NodeOne);
        root.addChildNode(NodeTwo);

        // when
        NodeIterable dirIterable = new NodeIterable(root);
        NodeIterator dirIterator = dirIterable.iterator();
        List<Node> Nodes = Lists.newArrayList(dirIterator);

        // then
        assertThat(Nodes, containsInAnyOrder(NodeOne, NodeTwo));
    }

    @Test
    public void nextShouldWorkWithoutHasnext(){

        // given
        Node root = new NodeImpl();
        Node branchOne = new NodeImpl();
        Node branchTwo = new NodeImpl();
        root.addChildNode(branchOne);
        branchOne.addChildNode(branchTwo);
        Node NodeOne = new NodeImpl();
        branchTwo.addChildNode(NodeOne);

        // when
        NodeIterable nodeIterable = new NodeIterable(root);
        NodeIterator NodeIterator = nodeIterable.iterator();

        // then
        assertThat(NodeIterator.next(),is(equalTo(branchOne)));
    }

    @Test
    public void shoudReturnAllNodesWhenOneBrancheInRootPresent(){

        // given
        Node root = new NodeImpl();
        Node BranchOne = new NodeImpl();
        Node NodeOne = new NodeImpl();
        Node NodeTwo = new NodeImpl();
        root.addChildNode(NodeOne);
        root.addChildNode(NodeTwo);
        root.addChildNode(BranchOne);
        Node NodeThree = new NodeImpl();
        BranchOne.addChildNode(NodeThree);

        // when
        NodeIterable dirIterable = new NodeIterable(root);
        NodeIterator dirIterator = dirIterable.iterator();
        List<Node> Nodes = Lists.newArrayList(dirIterator);
        System.out.println(Nodes);


        // then
        //assertThat(Nodes, containsInAnyOrder(BranchOne, NodeOne, NodeTwo, NodeThree));
    }

    @Test
    public void shouldReturnExpectedValueAfterIteration(){

        // given
        Node root = new NodeImpl();
        Node NodeOne = new NodeImpl();
        Node NodeFive = new NodeImpl();
        root.addChildNode(NodeOne);
        root.addChildNode(NodeFive);
        Node branchOne = new NodeImpl();
        root.addChildNode(branchOne);
        Node NodeTwo = new NodeImpl();
        branchOne.addChildNode(NodeTwo);
        Node branchTwo = new NodeImpl();
        branchOne.addChildNode(branchTwo);
        Node NodeThree = new NodeImpl();
        Node NodeFour = new NodeImpl();
        branchTwo.addChildNode(NodeThree);
        branchTwo.addChildNode(NodeFour);

        // when
        NodeIterable dirIterable = new NodeIterable(root);
        NodeIterator dirIterator = dirIterable.iterator();
        List<Node> Nodes = Lists.newArrayList(dirIterator);

        // then
        assertThat(Nodes, containsInAnyOrder(branchOne, branchTwo, NodeOne,NodeTwo,NodeThree,NodeFour,NodeFive));
    }

    @Test
    public void shouldReturnOneNodeFromDoubleEmptyBranch(){
        // given
        Node root = new NodeImpl();
        Node branchOne = new NodeImpl();
        Node branchTwo = new NodeImpl();
        root.addChildNode(branchOne);
        root.addChildNode(branchTwo);
        Node branchThree = new NodeImpl();
        branchTwo.addChildNode(branchThree);
        Node NodeOne = new NodeImpl();
        branchThree.addChildNode(NodeOne);

        // when
        NodeIterable dirIterable = new NodeIterable(root);
        NodeIterator dirIterator = dirIterable.iterator();
        List<Node> Nodes = Lists.newArrayList(dirIterator);

        // then
        assertThat(Nodes, containsInAnyOrder(NodeOne,branchOne,branchThree,branchTwo));
    }

    @Test
    public void shouldReturnBottomNodesFromTrippleSubbranchesAndSomeEmptyBranches(){
        // given
        Node root = new NodeImpl();
        Node branchOne = new NodeImpl();
        Node branchTwo = new NodeImpl();
        root.addChildNode(branchOne);
        root.addChildNode(branchTwo);
        Node branchThree = new NodeImpl();
        Node branchFour = new NodeImpl();
        branchOne.addChildNode(branchThree);
        branchOne.addChildNode(branchFour);
        Node branchFive = new NodeImpl();
        branchTwo.addChildNode(branchFive);
        Node branchSix = new NodeImpl();
        Node branchSeven = new NodeImpl();
        Node branchEight = new NodeImpl();
        branchThree.addChildNode(branchSix);
        branchFour.addChildNode(branchSeven);
        branchFive.addChildNode(branchEight);
        Node NodeOne = new NodeImpl();
        Node NodeTwo = new NodeImpl();
        Node NodeThree = new NodeImpl();
        Node NodeFour = new NodeImpl();
        branchThree.addChildNode(NodeOne);
        branchSeven.addChildNode(NodeTwo);
        branchSeven.addChildNode(NodeThree);
        branchEight.addChildNode(NodeFour);

        // when
        NodeIterable dirIterable = new NodeIterable(root);
        NodeIterator dirIterator = dirIterable.iterator();
        List<Node> Nodes = Lists.newArrayList(dirIterator);

        // then
        assertThat(Nodes, containsInAnyOrder(branchOne,branchTwo, branchThree,branchFour, branchFive, branchSix, branchSeven, branchEight,NodeOne,NodeTwo,NodeThree,NodeFour));
    }

    @Test
    public void shoudlReturnNoNodeForTreeWithJustEmptyBranchesAndSubbranches(){
        // given
        Node root = new NodeImpl();

        // when
        NodeIterable dirIterable = new NodeIterable(root);
        NodeIterator dirIterator = dirIterable.iterator();
        List<Node> Nodes = Lists.newArrayList(dirIterator);

        // then
        assertThat(Nodes.isEmpty(),equalTo(true));

    }

    @Test(expected = NoSuchElementException.class)
    public void shouldReturnNoSuchElementExceptionWhenEmpty(){
        // given
        Node root = new NodeImpl();

        // when
        NodeIterable dirIterable = new NodeIterable(root);
        NodeIterator dirIterator = dirIterable.iterator();

        System.out.println(dirIterator.next());



    }
}
