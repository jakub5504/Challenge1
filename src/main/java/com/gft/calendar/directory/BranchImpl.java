package com.gft.calendar.directory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jbki on 10/3/2016.
 */
public class BranchImpl implements Branch{

    List<Branch> branches = new ArrayList<>();
    List<Leaf> leafs = new ArrayList<>();
    private String branchName;

    public BranchImpl(String branchName ) {
        this.branchName = branchName;
    }

    @Override
    public void addSubBranch(Branch subBranch) {

        branches.add(subBranch);
    }

    @Override
    public void addSubLeaf(Leaf subLeaf) {

            leafs.add(subLeaf);
    }

    @Override
    public void addSubLeaf(Leaf leafOne, Leaf leafTwo) {

        leafs.add(leafOne);
        leafs.add(leafTwo);
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public List<Leaf> getLeafs() {
        return leafs;
    }

    public String getBranchName() {
        return branchName;
    }
}
