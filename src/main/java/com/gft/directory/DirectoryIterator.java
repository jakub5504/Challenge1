package com.gft.directory;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jbki on 10/3/2016.
 */
public class DirectoryIterator implements Iterator<Leaf> {

    private LinkedList<Branch> branches = new LinkedList<>();
    private LinkedList<Leaf> leafs = new LinkedList<>();


    public DirectoryIterator(Branch root) {
        this.branches = root.getBranches();
        this.leafs = root.getLeafs();
    }

    @Override
    public boolean hasNext() {
        if (!leafs.isEmpty()) {
            return true;
        } else {
            if (!branches.isEmpty()) {
                if (!branches.get(0).getLeafs().isEmpty() && !branches.get(0).getBranches().isEmpty()) {
                    LinkedList<Leaf> tempLeafList = branches.get(0).getLeafs();
                    LinkedList<Branch> tempBranchList = branches.get(0).getBranches();
                    branches.remove(0);
                    branches.addAll(0, tempBranchList);
                    leafs.addAll(0, tempLeafList);
                    return true;
                } else if (!branches.get(0).getBranches().isEmpty() && branches.get(0).getLeafs().isEmpty()) {
                    LinkedList<Branch> tempBranchList = branches.get(0).getBranches();
                    branches.remove(0);
                    branches.addAll(0, tempBranchList);
                    if (this.hasNext()) {
                        return true;
                    }
                } else if (branches.get(0).getBranches().isEmpty() && !branches.get(0).getLeafs().isEmpty()) {
                    LinkedList<Leaf> tempLeafList = branches.get(0).getLeafs();
                    branches.remove(0);
                    leafs.addAll(0, tempLeafList);
                    return true;
                } else if (branches.get(0).getBranches().isEmpty() && branches.get(0).getBranches().isEmpty()){
                    branches.remove(0);
                    if (this.hasNext()) {
                        return true;
                    }
                }
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public Leaf next() {

        Leaf returnLeaf = leafs.get(0);
        leafs.remove(0);
        return returnLeaf;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public List<Leaf> getLeafs() {
        return leafs;
    }
}
