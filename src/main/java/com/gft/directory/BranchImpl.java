package com.gft.directory;

import java.util.LinkedList;

public class BranchImpl implements Branch{

    private LinkedList<Branch> branches = new LinkedList<>();
    private LinkedList<Leaf> leafs = new LinkedList<>();

    public void addSubBranch(Branch subBranch) {

        branches.add(subBranch);
    }


    public void addSubLeaf(Leaf subLeaf) {

            leafs.add(subLeaf);
    }


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

}
