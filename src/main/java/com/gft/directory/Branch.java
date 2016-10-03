package com.gft.directory;


import java.util.List;

public interface Branch {
    void addSubBranch(Branch subBranch);
    void addSubLeaf(Leaf subLeaf);
    void addSubLeaf(Leaf leafOne, Leaf leafTwo);
    List<Branch> getBranches();
    List<Leaf> getLeafs();
}
