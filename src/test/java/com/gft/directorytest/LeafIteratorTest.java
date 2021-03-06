package com.gft.directorytest;

import com.gft.directory.*;
import com.google.common.collect.Lists;
import org.junit.Test;
import java.util.Iterator;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LeafIteratorTest {


    @Test
    public void shouldReturnAllLeafsFromRootandSubroots(){

        // given
        BranchImpl root = new BranchImpl();
        BranchImpl branchOne = new BranchImpl();
        BranchImpl branchTwo = new BranchImpl();
        BranchImpl branchThree = new BranchImpl();
        root.addSubBranch(branchOne);
        root.addSubBranch(branchTwo);
        root.addSubBranch(branchThree);
        Leaf leafOne = new LeafImpl();
        Leaf leafTwo = new LeafImpl();
        branchOne.addSubLeaf(leafOne);
        branchTwo.addSubLeaf(leafTwo);
        BranchImpl branchFour = new BranchImpl();
        branchThree.addSubBranch(branchFour);
        Leaf leafThree = new LeafImpl();
        Leaf leafFour = new LeafImpl();
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
        BranchImpl root = new BranchImpl();
        BranchImpl branchOne = new BranchImpl();
        BranchImpl branchTwo = new BranchImpl();
        BranchImpl branchThree = new BranchImpl();
        root.addSubBranch(branchOne);
        root.addSubBranch(branchTwo);
        root.addSubBranch(branchThree);
        Leaf leafOne = new LeafImpl();
        Leaf leafTwo = new LeafImpl();
        Leaf leafThree = new LeafImpl();
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
        BranchImpl root = new BranchImpl();
        BranchImpl BranchOne = new BranchImpl();
        BranchImpl BranchTwo = new BranchImpl();
        root.addSubBranch(BranchOne);
        root.addSubBranch(BranchTwo);
        Leaf leafOne = new LeafImpl();
        Leaf leafTwo = new LeafImpl();
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
        Branch root = new BranchImpl();

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
        BranchImpl root = new BranchImpl();
        Leaf leafOne = new LeafImpl();
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
        BranchImpl root = new BranchImpl();
        Leaf leafOne = new LeafImpl();
        Leaf leafTwo = new LeafImpl();
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
        BranchImpl root = new BranchImpl();
        BranchImpl branchOne = new BranchImpl();
        BranchImpl branchTwo = new BranchImpl();
        root.addSubBranch(branchOne);
        branchOne.addSubBranch(branchTwo);
        Leaf leafOne = new LeafImpl();
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
        BranchImpl root = new BranchImpl();
        BranchImpl BranchOne = new BranchImpl();
        Leaf leafOne = new LeafImpl();
        Leaf leafTwo = new LeafImpl();
        root.addSubLeaf(leafOne,leafTwo);
        root.addSubBranch(BranchOne);
        Leaf leafThree = new LeafImpl();
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
        BranchImpl root = new BranchImpl();
        Leaf leafOne = new LeafImpl();
        Leaf leafFive = new LeafImpl();
        root.addSubLeaf(leafOne);
        root.addSubLeaf(leafFive);
        BranchImpl branchOne = new BranchImpl();
        root.addSubBranch(branchOne);
        Leaf leafTwo = new LeafImpl();
        branchOne.addSubLeaf(leafTwo);
        BranchImpl branchTwo = new BranchImpl();
        branchOne.addSubBranch(branchTwo);
        Leaf leafThree = new LeafImpl();
        Leaf leafFour = new LeafImpl();
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
        BranchImpl root = new BranchImpl();
        BranchImpl branchOne = new BranchImpl();
        BranchImpl branchTwo = new BranchImpl();
        root.addSubBranch(branchOne);
        root.addSubBranch(branchTwo);
        BranchImpl branchThree = new BranchImpl();
        branchTwo.addSubBranch(branchThree);
        Leaf leafOne = new LeafImpl();
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
        BranchImpl root = new BranchImpl();
        BranchImpl branchOne = new BranchImpl();
        BranchImpl branchTwo = new BranchImpl();
        root.addSubBranch(branchOne);
        root.addSubBranch(branchTwo);
        BranchImpl branchThree = new BranchImpl();
        BranchImpl branchFour = new BranchImpl();
        branchOne.addSubBranch(branchThree);
        branchOne.addSubBranch(branchFour);
        BranchImpl branchFive = new BranchImpl();
        branchTwo.addSubBranch(branchFive);
        BranchImpl branchSix = new BranchImpl();
        BranchImpl branchSeven = new BranchImpl();
        BranchImpl branchEight = new BranchImpl();
        branchThree.addSubBranch(branchSix);
        branchFour.addSubBranch(branchSeven);
        branchFive.addSubBranch(branchEight);
        Leaf leafOne = new LeafImpl();
        Leaf leafTwo = new LeafImpl();
        Leaf leafThree = new LeafImpl();
        Leaf leafFour = new LeafImpl();
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
        BranchImpl root = new BranchImpl();
        BranchImpl branchOne = new BranchImpl();
        BranchImpl branchTwo = new BranchImpl();
        root.addSubBranch(branchOne);
        root.addSubBranch(branchTwo);
        Branch branchThree = new BranchImpl();
        Branch branchFour = new BranchImpl();
        Branch branchFive = new BranchImpl();
        Branch branchSix = new BranchImpl();
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

    @Test
    public void shoudlFindLeafInAnotherCombination() {
        // given
        BranchImpl root = new BranchImpl();
        BranchImpl branchOne = new BranchImpl();
        root.addSubBranch(branchOne);
        BranchImpl branchTwo = new BranchImpl();
        root.addSubBranch(branchTwo);
        LeafImpl leaf = new LeafImpl();
        branchTwo.addSubLeaf(leaf);

        // when
        LeafIterable leafIterable = new LeafIterable(root);
        LeafIterator leafIterator = leafIterable.iterator();
        List<Leaf> leafs = Lists.newArrayList(leafIterator);

        // then
        assertThat(leafs, containsInAnyOrder(leaf));
    }

    @Test
    public void shouldReturnAllLeafsInDifferentCombination(){
        // given
        BranchImpl root = new BranchImpl();
        BranchImpl branchOne = new BranchImpl();
        BranchImpl branchTwo = new BranchImpl();
        BranchImpl branchThree = new BranchImpl();
        BranchImpl branchFour = new BranchImpl();
        BranchImpl branchFive = new BranchImpl();
        root.addSubBranch(branchOne);
        root.addSubBranch(branchTwo);
        branchOne.addSubBranch(branchThree);
        branchOne.addSubBranch(branchFour);
        branchFour.addSubBranch(branchFive);
        LeafImpl leafOne = new LeafImpl();
        LeafImpl leafTwo = new LeafImpl();
        branchTwo.addSubLeaf(leafOne);
        branchFive.addSubLeaf(leafTwo);

        // when
        LeafIterable leafIterable = new LeafIterable(root);
        LeafIterator leafIterator = leafIterable.iterator();
        List<Leaf> leafs = Lists.newArrayList(leafIterator);

        // then
        assertThat(leafs, containsInAnyOrder(leafOne,leafTwo));
    }

    @Test
    public void shouldReturnLeafsInVerticalCombination(){
        // given
        BranchImpl root = new BranchImpl();
        BranchImpl branchOne = new BranchImpl();
        BranchImpl branchTwo = new BranchImpl();
        BranchImpl branchThree = new BranchImpl();
        BranchImpl branchFour = new BranchImpl();
        root.addSubBranch(branchOne);
        root.addSubBranch(branchTwo);
        branchTwo.addSubBranch(branchThree);
        branchThree.addSubBranch(branchFour);
        LeafImpl leafOne = new LeafImpl();
        LeafImpl leafTwo = new LeafImpl();
        branchTwo.addSubLeaf(leafOne);
        branchFour.addSubLeaf(leafTwo);

        // when
        LeafIterable leafIterable = new LeafIterable(root);
        LeafIterator leafIterator = leafIterable.iterator();
        List<Leaf> leafs = Lists.newArrayList(leafIterator);

        // then
        assertThat(leafs, containsInAnyOrder(leafOne,leafTwo));
    }
}
