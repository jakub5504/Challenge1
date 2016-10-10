package com.gft.directorytest;

import com.gft.directory.*;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Created by jbki on 10/3/2016.
 */
public class LeafIteratorTest {


    @Test
    public void shouldReturnAllLeafsFromRootandSubroots(){

        // given
        Branch root = new BranchImpl("Root");
        Branch branchOne = new BranchImpl("BranchOne");
        Branch branchTwo = new BranchImpl("BranchTwo");
        Branch branchThree = new BranchImpl("BranchThree");
        root.addSubBranch(branchOne);
        root.addSubBranch(branchTwo);
        root.addSubBranch(branchThree);
        Leaf leafOne = new LeafImpl("LeafOne");
        Leaf leafTwo = new LeafImpl("LeafTwo");
        branchOne.addSubLeaf(leafOne);
        branchTwo.addSubLeaf(leafTwo);
        Branch branchFour = new BranchImpl("BranchFour");
        branchThree.addSubBranch(branchFour);
        Leaf leafThree = new LeafImpl("LeafThree");
        Leaf leafFour = new LeafImpl("LeafFour");
        branchFour.addSubLeaf(leafThree,leafFour);

        // when
        LeafIterable dirIterable = new LeafIterable(root);
        LeafIterator dirIterator = dirIterable.iterator();
        List<Leaf> leafs = Lists.newArrayList(dirIterator);

        // then
        assertThat(leafs,containsInAnyOrder(leafOne,leafTwo,leafThree,leafFour));
    }

    @Test
    public void shouldReturnAllLeafsFromMoreThenTwoBranchesInRoot(){

        // given
        Branch root = new BranchImpl("Root");
        Branch branchOne = new BranchImpl("BranchOne");
        Branch branchTwo = new BranchImpl("BranchTwo");
        Branch branchThree = new BranchImpl("BranchThree");
        root.addSubBranch(branchOne);
        root.addSubBranch(branchTwo);
        root.addSubBranch(branchThree);
        Leaf leafOne = new LeafImpl("LeafOne");
        Leaf leafTwo = new LeafImpl("LeafTwo");
        Leaf leafThree = new LeafImpl("LeafThree");
        branchOne.addSubLeaf(leafOne);
        branchTwo.addSubLeaf(leafTwo);
        branchThree.addSubLeaf(leafThree);

        // when
        LeafIterable dirIterable = new LeafIterable(root);
        LeafIterator dirIterator = dirIterable.iterator();
        List<Leaf> leafs = Lists.newArrayList(dirIterator);

        //then
        assertThat(leafs,containsInAnyOrder(leafOne,leafTwo,leafThree));

    }
    @Test
    public void shouldReturnLeafsFromTwoBranchesInRoot(){

        // given
        Branch root = new BranchImpl("Root");
        Branch BranchOne = new BranchImpl("BranchOne");
        Branch BranchTwo = new BranchImpl("BranchTwo");
        root.addSubBranch(BranchOne);
        root.addSubBranch(BranchTwo);
        Leaf leafOne = new LeafImpl("LeafOne");
        Leaf leafTwo = new LeafImpl("LeafTwo");
        BranchOne.addSubLeaf(leafTwo);
        BranchTwo.addSubLeaf(leafOne);

        // when
        LeafIterable dirIterable = new LeafIterable(root);
        LeafIterator dirIterator = dirIterable.iterator();
        List<Leaf> leafs = Lists.newArrayList(dirIterator);

        // then
        assertThat(leafs,containsInAnyOrder(leafOne,leafTwo));
    }
    @Test
    public void shouldReturnEmptyListForRootDirectoryWithoutLeafsAndBranches(){

        // given
        Branch root = new BranchImpl("Root");

        // when
        LeafIterable dirIterable = new LeafIterable(root);
        LeafIterator dirIterator = dirIterable.iterator();
        List<Leaf> leafs = Lists.newArrayList(dirIterator);

        // then
        assertThat(leafs.isEmpty(),equalTo(true));
    }
    @Test
    public void shouldReturnNewlyCreatedLeaf(){

        // given
        Branch root = new BranchImpl("Root");
        Leaf leafOne = new LeafImpl("LeafOne");
        root.addSubLeaf(leafOne);

        // when
        LeafIterable dirIterable = new LeafIterable(root);
        LeafIterator dirIterator = dirIterable.iterator();
        List<Leaf> leafs = Lists.newArrayList(dirIterator);

        // then
        assertThat(leafs.get(0), equalTo(leafOne));
        assertThat(leafs.get(0), is(leafOne));
        assertThat(leafs.get(0), is(equalTo(leafOne)));
    }

    @Test
    public void shouldReturnAllLeafsFromRootDirectory(){

        // given
        Branch root = new BranchImpl("Root");
        Leaf leafOne = new LeafImpl("LeafOne");
        Leaf leafTwo = new LeafImpl("LeafTwo");
        root.addSubLeaf(leafOne,leafTwo);

        // when
        LeafIterable dirIterable = new LeafIterable(root);
        LeafIterator dirIterator = dirIterable.iterator();
        List<Leaf> leafs = Lists.newArrayList(dirIterator);

        // then
        assertThat(leafs, containsInAnyOrder(leafOne, leafTwo));
    }

    @Test
    public void nextShouldWorkWithoutHasnext(){

        // given
        Branch root = new BranchImpl("Root");
        Branch branchOne = new BranchImpl("BranchOne");
        Branch branchTwo = new BranchImpl("BranchTwo");
        root.addSubBranch(branchOne);
        branchOne.addSubBranch(branchTwo);
        Leaf leafOne = new LeafImpl("LeafOne");
        branchTwo.addSubLeaf(leafOne);

        // when
        Iterable<Leaf> leafIterable = new LeafIterable(root);
        Iterator<Leaf> leafIterator = leafIterable.iterator();

        // then
        assertThat(leafIterator.next(),is(equalTo(leafOne)));

    }

    @Test
    public void shoudReturnAllLeafsWhenOneBrancheInRootPresent(){

        // given
        Branch root = new BranchImpl("Root");
        Branch BranchOne = new BranchImpl("BranchOne");
        Leaf leafOne = new LeafImpl("LeafOne");
        Leaf leafTwo = new LeafImpl("LeafTwo");
        root.addSubLeaf(leafOne,leafTwo);
        root.addSubBranch(BranchOne);
        Leaf leafThree = new LeafImpl("LeafThree");
        BranchOne.addSubLeaf(leafThree);

        // when
        LeafIterable dirIterable = new LeafIterable(root);
        LeafIterator dirIterator = dirIterable.iterator();
        List<Leaf> leafs = Lists.newArrayList(dirIterator);

        // then
        assertThat(leafs, containsInAnyOrder(leafOne, leafTwo, leafThree));
    }
    @Test
    public void shouldReturnExpectedValueAfterIteration(){

        // given
        Branch root = new BranchImpl("Root");
        Leaf leafOne = new LeafImpl("LeafOne");
        Leaf leafFive = new LeafImpl("LeafFive");
        root.addSubLeaf(leafOne);
        root.addSubLeaf(leafFive);
        Branch branchOne = new BranchImpl("BranchOne");
        root.addSubBranch(branchOne);
        Leaf leafTwo = new LeafImpl("LeafTwo");
        branchOne.addSubLeaf(leafTwo);
        Branch branchTwo = new BranchImpl("BranchTwo");
        branchOne.addSubBranch(branchTwo);
        Leaf leafThree = new LeafImpl("LeafThree");
        Leaf leafFour = new LeafImpl("LeafFour");
        branchTwo.addSubLeaf(leafThree,leafFour);

        // when
        LeafIterable dirIterable = new LeafIterable(root);
        LeafIterator dirIterator = dirIterable.iterator();
        List<Leaf> leafs = Lists.newArrayList(dirIterator);

        // then
        assertThat(leafs, containsInAnyOrder(leafOne,leafTwo,leafThree,leafFour,leafFive));
    }
    @Test
    public void shouldReturnOneLeafFromDoubleEmptyBranch(){
        // given
        Branch root = new BranchImpl("Root");
        Branch branchOne = new BranchImpl("BranchOne");
        Branch branchTwo = new BranchImpl("BranchTwo");
        root.addSubBranch(branchOne);
        root.addSubBranch(branchTwo);
        Branch branchThree = new BranchImpl("BranchThree");
        branchTwo.addSubBranch(branchThree);
        Leaf leafOne = new LeafImpl("LeafOne");
        branchThree.addSubLeaf(leafOne);

        // when
        LeafIterable dirIterable = new LeafIterable(root);
        LeafIterator dirIterator = dirIterable.iterator();
        List<Leaf> leafs = Lists.newArrayList(dirIterator);

        // then
        assertThat(leafs, contains(leafOne));
    }
    @Test
    public void shouldReturnBottomLeafsFromTrippleSubbranchesAndSomeEmptyBranches(){
        // given
        Branch root = new BranchImpl("Root");
        Branch branchOne = new BranchImpl("BranchOne");
        Branch branchTwo = new BranchImpl("BranchTwo");
        root.addSubBranch(branchOne);
        root.addSubBranch(branchTwo);
        Branch branchThree = new BranchImpl("BranchThree");
        Branch branchFour = new BranchImpl("BranchFour");
        branchOne.addSubBranch(branchThree);
        branchOne.addSubBranch(branchFour);
        Branch branchFive = new BranchImpl("BranchFive");
        branchTwo.addSubBranch(branchFive);
        Branch branchSix = new BranchImpl("BranchSix");
        Branch branchSeven = new BranchImpl("BranchSeven");
        Branch branchEight = new BranchImpl("BranchEight");
        branchThree.addSubBranch(branchSix);
        branchFour.addSubBranch(branchSeven);
        branchFive.addSubBranch(branchEight);
        Leaf leafOne = new LeafImpl("LeafOne");
        Leaf leafTwo = new LeafImpl("LeafTwo");
        Leaf leafThree = new LeafImpl("LeafThree");
        Leaf leafFour = new LeafImpl("LeafFour");
        branchThree.addSubLeaf(leafOne);
        branchSeven.addSubLeaf(leafTwo,leafThree);
        branchEight.addSubLeaf(leafFour);

        // when
        LeafIterable dirIterable = new LeafIterable(root);
        LeafIterator dirIterator = dirIterable.iterator();
        List<Leaf> leafs = Lists.newArrayList(dirIterator);

        // then
        assertThat(leafs, containsInAnyOrder(leafOne,leafTwo,leafThree,leafFour));
    }
    @Test
    public void shoudlReturnNoLeafForTreeWithJustEmptyBranchesAndSubbranches(){
        // given
        Branch root = new BranchImpl("Root");
        Branch branchOne = new BranchImpl("BranchOne");
        Branch branchTwo = new BranchImpl("BranchTwo");
        root.addSubBranch(branchOne);
        root.addSubBranch(branchTwo);
        Branch branchThree = new BranchImpl("BranchThree");
        Branch branchFour = new BranchImpl("BranchFour");
        Branch branchFive = new BranchImpl("BranchFive");
        Branch branchSix = new BranchImpl("BranchSix");
        branchOne.addSubBranch(branchThree);
        branchOne.addSubBranch(branchFour);
        branchTwo.addSubBranch(branchFive);
        branchTwo.addSubBranch(branchSix);

        // when
        LeafIterable dirIterable = new LeafIterable(root);
        LeafIterator dirIterator = dirIterable.iterator();
        List<Leaf> leafs = Lists.newArrayList(dirIterator);

        // then
        assertThat(leafs.isEmpty(),equalTo(true));

    }
}
