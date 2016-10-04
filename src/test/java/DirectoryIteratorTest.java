import com.gft.directory.*;
import com.google.common.collect.Lists;
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
        assertThat(leafs.get(0),is(equalTo(leafOne)));
    }
    @Test
    public void shouldReturnTwoLeafsInRootDirectory(){
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
        assertThat(leafs, containsInAnyOrder(leafOne, leafFive, leafThree, leafFour, leafTwo));
//        dirIterator.hasNext();
//        System.out.println(dirIterator.next().getLeafName());
//        dirIterator.hasNext();
//        System.out.println(dirIterator.next().getLeafName());
//        dirIterator.hasNext();
//        System.out.println(dirIterator.next().getLeafName());
//        dirIterator.hasNext();
//        System.out.println(dirIterator.next().getLeafName());
//        dirIterator.hasNext();
//        System.out.println(dirIterator.next().getLeafName());
    }
}
