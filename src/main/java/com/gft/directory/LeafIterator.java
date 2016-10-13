package com.gft.directory;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by jbki on 10/3/2016.
 */
public class LeafIterator implements Iterator<Leaf> {

    public static State DirectoryState = State.BRANCHES_EMPTY_LEAFS_EMPTY;
    private static LinkedList<Leaf> tempLeafList = new LinkedList<>();
    private static LinkedList<Branch> tempBranchList = new LinkedList<>();
    private LinkedList<Branch> branches = new LinkedList<>();
    private LinkedList<Leaf> leafs = new LinkedList<>();

    public LeafIterator(Branch root) {
        this.branches = root.getBranches();
        this.leafs = root.getLeafs();
    }

    public boolean checkNext(){
        // Checks if root has some leafs
        if (!leafs.isEmpty()) {
            return true;
        }
        // Checks if root has some branches
        if (branches.isEmpty()) {
            return false;
        }
        // True if first deeper branch has some branches and leafs inside
        if (!branches.get(0).getLeafs().isEmpty() && !branches.get(0).getBranches().isEmpty()) {
            tempLeafList = branches.get(0).getLeafs();
            tempBranchList = branches.get(0).getBranches();
            DirectoryState = State.BRANCHES_NOT_EMPTY_LEAFS_NOT_EMPTY;
            modifyDirectory(DirectoryState);
            return true;
        }
        //  True if first deeper branch has some branches and doesn't have any leafs inside
        if (!branches.get(0).getBranches().isEmpty() && branches.get(0).getLeafs().isEmpty()) {
            tempBranchList = branches.get(0).getBranches();
            DirectoryState = State.BRANCHES_NOT_EMPTY_LEAFS_EMPTY;
            modifyDirectory(DirectoryState);
            if (this.checkNext()) {
                return true;
            }
        }
        // True if first deeper branch doesn't have any branches but has some leafs inside
        else if (branches.get(0).getBranches().isEmpty() && !branches.get(0).getLeafs().isEmpty()) {
            tempLeafList = branches.get(0).getLeafs();
            DirectoryState = State.BRANCHES_EMPTY_LEAFS_NOT_EMPTY;
            modifyDirectory(DirectoryState);
            return true;
        }
        // True if first deeper branch dosn't have any branches and leafs inside
        else if (branches.get(0).getBranches().isEmpty() && branches.get(0).getBranches().isEmpty()) {
            DirectoryState = State.BRANCHES_EMPTY_LEAFS_EMPTY;
            modifyDirectory(DirectoryState);
            if (this.checkNext()) {
                return true;
            }
        }
        // Returns false if first
        return false;
    }
    @Override
    public boolean hasNext() {
        // Checks if root has some leafs
        if (!leafs.isEmpty()) {
            return true;
        }
        // Checks if root has some branches
        if (branches.isEmpty()) {
            return false;
        }
        // True if first deeper branch has some branches and leafs inside
        if (!branches.get(0).getLeafs().isEmpty() && !branches.get(0).getBranches().isEmpty()) {
            tempLeafList = branches.get(0).getLeafs();
            tempBranchList = branches.get(0).getBranches();
            DirectoryState = State.BRANCHES_NOT_EMPTY_LEAFS_NOT_EMPTY;
            modifyDirectory(DirectoryState);
            return true;
        }
        //  True if first deeper branch has some branches and doesn't have any leafs inside
        if (!branches.get(0).getBranches().isEmpty() && branches.get(0).getLeafs().isEmpty()) {
            tempBranchList = branches.get(0).getBranches();
            DirectoryState = State.BRANCHES_NOT_EMPTY_LEAFS_EMPTY;
            modifyDirectory(DirectoryState);
            if (this.hasNext()) {
                return true;
            }
        }
        // True if first deeper branch doesn't have any branches but has some leafs inside
        else if (branches.get(0).getBranches().isEmpty() && !branches.get(0).getLeafs().isEmpty()) {
            tempLeafList = branches.get(0).getLeafs();
            DirectoryState = State.BRANCHES_EMPTY_LEAFS_NOT_EMPTY;
            modifyDirectory(DirectoryState);
            return true;
        }
        // True if first deeper branch dosn't have any branches and leafs inside
        else if (branches.get(0).getBranches().isEmpty() && branches.get(0).getBranches().isEmpty()) {
            DirectoryState = State.BRANCHES_EMPTY_LEAFS_EMPTY;
            modifyDirectory(DirectoryState);
            if (this.hasNext()) {
                return true;
            }
        }
        // Returns false if first
        return false;
    }

    @Override
    public Leaf next() {
        // Checks and returns Leaf if there is any in a tree
        if(this.checkNext()){
                Leaf returnLeaf = leafs.get(0);
                leafs.remove(0);
                return returnLeaf;
        }
        // Returns null if there is no Leaf in a tree
        return null;
    }


    public void modifyDirectory(State state) {
        switch (state) {
            case BRANCHES_EMPTY_LEAFS_EMPTY:
                branches.remove(0);
                break;
            case BRANCHES_NOT_EMPTY_LEAFS_NOT_EMPTY:
                branches.remove(0);
                branches.addAll(0, tempBranchList);
                leafs.addAll(0, tempLeafList);
                break;
            case BRANCHES_NOT_EMPTY_LEAFS_EMPTY:
                branches.remove(0);
                branches.addAll(0, tempBranchList);
                break;
            case BRANCHES_EMPTY_LEAFS_NOT_EMPTY:
                branches.remove(0);
                leafs.addAll(0, tempLeafList);
                break;
        }
    }

    private enum State {
        BRANCHES_NOT_EMPTY_LEAFS_NOT_EMPTY,
        BRANCHES_NOT_EMPTY_LEAFS_EMPTY,
        BRANCHES_EMPTY_LEAFS_NOT_EMPTY,
        BRANCHES_EMPTY_LEAFS_EMPTY
    }

}
