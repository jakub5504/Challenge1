import com.gft.directory.*;
import org.junit.Test;

/**
 * Created by jbki on 10/3/2016.
 */
public class DirectoryIteratorTest {

    @Test
    public void shouldReturnExpectedValueAfterIteration(){
        Branch root = new BranchImpl("Root");
        Leaf leafOne = new LeafImpl("LeafOne");
        root.addSubLeaf(leafOne);
        Branch branchOne = new BranchImpl("BranchOne");
        root.addSubBranch(branchOne);
        Leaf leafTwo = new LeafImpl("LeafTwo");
        branchOne.addSubLeaf(leafTwo);
        Branch branchTwo = new BranchImpl("BranchTwo");
        branchOne.addSubBranch(branchTwo);
        Leaf leafThree = new LeafImpl("LeafThree");
        Leaf leafFour = new LeafImpl("LeafFour");
        branchTwo.addSubLeaf(leafThree,leafFour);

        DirectoryIterable dirIterqable = new DirectoryIterable(root);
        DirectoryIterator dirIterator = dirIterqable.iterator();
        System.out.println(dirIterator.next().getLeafName());
        System.out.println(dirIterator.next().getLeafName());

    }
}
