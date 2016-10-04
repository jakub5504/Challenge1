package com.gft.directory;


import java.util.LinkedList;

public interface Branch {
    void addSubBranch(Branch subBranch);
    void addSubLeaf(Leaf subLeaf);
    void addSubLeaf(Leaf leafOne, Leaf leafTwo);
    LinkedList<Branch> getBranches();
    LinkedList<Leaf> getLeafs();
    String getBranchName();
}
