package com.gft.calendar.directory;

import java.util.List;

/**
 * Created by jbki on 10/3/2016.
 */
public class BranchImpl implements Branch{

    List<Branch> branches;
    List<Leaf> leafs;

    @Override
    public void addSubBranch(Branch subBranch) {

        branches.add(subBranch);
    }

    @Override
    public void addSubLeaf(Leaf subLeaf) {

            leafs.add(subLeaf);
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public List<Leaf> getLeafs() {
        return leafs;
    }
}
