import com.gft.directory.*;
import com.google.common.collect.Lists;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * Created by jbki on 10/3/2016.
 */
public class DirectoryIteratorTest {


    @Ignore
    @Test
    public void shouldReturnAllLeafsFromRootandSubroots(){
        Branch root = new BranchImpl("Root");
        Leaf leafOne = new LeafImpl("LeafOne");
        Leaf leafTwo = new LeafImpl("LeafTwo");
        Leaf leafThree = new LeafImpl("LeafThree");
        Leaf leafFour = new LeafImpl("LeafFour");
        Branch branchOne = new BranchImpl("BranchOne");
        Branch branchTwo = new BranchImpl("BranchTwo");
        Branch branchThree = new BranchImpl("BranchThree");
        Branch branchFour = new BranchImpl("BranchFour");
        root.addSubBranch(branchOne);
        root.addSubBranch(branchTwo);
        root.addSubBranch(branchThree);
        branchOne.addSubLeaf(leafOne);
        branchTwo.addSubLeaf(leafTwo);
        branchThree.addSubBranch(branchFour);
        branchFour.addSubLeaf(leafThree,leafFour);
        DirectoryIterable dirIterable = new DirectoryIterable(root);
        DirectoryIterator dirIterator = dirIterable.iterator();
        List<Leaf> leafs = Lists.newArrayList(dirIterator);
        for (Leaf leaf : leafs ) {System.out.println(leaf.getLeafName());}
        assertThat(leafs,containsInAnyOrder(leafOne,leafTwo,leafThree,leafFour));
    }

    @Test
    public void shouldReturnAllLeafsFromMoreThenTwoBranchesInRoot(){
        Branch root = new BranchImpl("Root");
        Leaf leafOne = new LeafImpl("LeafOne");
        Leaf leafTwo = new LeafImpl("LeafTwo");
        Leaf leafThree = new LeafImpl("LeafThree");
        Branch branchOne = new BranchImpl("BranchOne");
        Branch branchTwo = new BranchImpl("BranchTwo");
        Branch branchThree = new BranchImpl("BranchThree");
        root.addSubBranch(branchOne);
        root.addSubBranch(branchTwo);
        root.addSubBranch(branchThree);
        branchOne.addSubLeaf(leafOne);
        branchTwo.addSubLeaf(leafTwo);
        branchThree.addSubLeaf(leafThree);
        DirectoryIterable dirIterable = new DirectoryIterable(root);
        DirectoryIterator dirIterator = dirIterable.iterator();
        List<Leaf> leafs = Lists.newArrayList(dirIterator);
        assertThat(leafs,containsInAnyOrder(leafOne,leafTwo,leafThree));

    }
    @Test
    public void shouldReturnLeafsFromTwoBranchesInRoot(){
        Branch root = new BranchImpl("Root");
        Leaf leafOne = new LeafImpl("LeafOne");
        Leaf leafTwo = new LeafImpl("LeafTwo");
        Branch BranchOne = new BranchImpl("BranchOne");
        Branch BranchTwo = new BranchImpl("BranchTwo");
        root.addSubBranch(BranchOne);
        root.addSubBranch(BranchTwo);
        BranchOne.addSubLeaf(leafTwo);
        BranchTwo.addSubLeaf(leafOne);
        DirectoryIterable dirIterable = new DirectoryIterable(root);
        DirectoryIterator dirIterator = dirIterable.iterator();
        List<Leaf> leafs = Lists.newArrayList(dirIterator);
        System.out.println(leafs.toString());
        assertThat(leafs,containsInAnyOrder(leafOne,leafTwo));
    }
    @Test
    public void shouldReturnEmptyListForRootDirectoryWithoutLeafsAndBranches(){
        Branch root = new BranchImpl("Root");
        DirectoryIterable dirIterable = new DirectoryIterable(root);
        DirectoryIterator dirIterator = dirIterable.iterator();
        List<Leaf> leafs = Lists.newArrayList(dirIterator);
        assertThat(leafs.isEmpty(),equalTo(true));
    }
    @Test
    public void shouldReturnNewlyCreatedLeaf(){
        Branch root = new BranchImpl("Root");
        Leaf leafOne = new LeafImpl("LeafOne");
        root.addSubLeaf(leafOne);
        DirectoryIterable dirIterable = new DirectoryIterable(root);
        DirectoryIterator dirIterator = dirIterable.iterator();
        List<Leaf> leafs = Lists.newArrayList(dirIterator);
        assertThat(leafs.get(0), equalTo(leafOne));
        assertThat(leafs.get(0), is(leafOne));
        assertThat(leafs.get(0), is(equalTo(leafOne)));
    }
    @Test
    public void shouldReturnAllLeafsFromRootDirectory(){
        Branch root = new BranchImpl("Root");
        Leaf leafOne = new LeafImpl("LeafOne");
        Leaf leafTwo = new LeafImpl("LeafTwo");
        root.addSubLeaf(leafOne,leafTwo);
        DirectoryIterable dirIterable = new DirectoryIterable(root);
        DirectoryIterator dirIterator = dirIterable.iterator();
        List<Leaf> leafs = Lists.newArrayList(dirIterator);
        assertThat(leafs, containsInAnyOrder(leafOne, leafTwo));
    }
    @Test
    public void shoudReturnAllLeafsWhenOneBrancheInRootPresent(){
        Branch root = new BranchImpl("Root");
        Branch BranchOne = new BranchImpl("BranchOne");
        Leaf leafOne = new LeafImpl("LeafOne");
        Leaf leafTwo = new LeafImpl("LeafTwo");
        Leaf leafThree = new LeafImpl("LeafThree");
        BranchOne.addSubLeaf(leafThree);
        root.addSubLeaf(leafOne,leafTwo);
        root.addSubBranch(BranchOne);
        DirectoryIterable dirIterable = new DirectoryIterable(root);
        DirectoryIterator dirIterator = dirIterable.iterator();
        List<Leaf> leafs = Lists.newArrayList(dirIterator);
        assertThat(leafs, containsInAnyOrder(leafOne, leafTwo, leafThree));
    }
    @Test
    public void shouldReturnExpectedValueAfterIteration(){
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
        DirectoryIterable dirIterable = new DirectoryIterable(root);
        DirectoryIterator dirIterator = dirIterable.iterator();
        List<Leaf> leafs = Lists.newArrayList(dirIterator);
        for (Leaf leaf : leafs ) {System.out.println(leaf.getLeafName());}
        assertThat(leafs, containsInAnyOrder(leafOne,leafTwo,leafThree,leafFour,leafFive));
    }
}
