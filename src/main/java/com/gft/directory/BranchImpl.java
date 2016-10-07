package com.gft.directory;

import java.util.LinkedList;

/**
 * Created by jbki on 10/3/2016.
 */
public class BranchImpl implements Branch{

    private LinkedList<Branch> branches = new LinkedList<>();
    private LinkedList<Leaf> leafs = new LinkedList<>();
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

    public LinkedList<Branch> getBranches() {
        return branches;
    }

    public LinkedList<Leaf> getLeafs() {
        return leafs;
    }

    public String getBranchName() {
        return branchName;
    }
}
