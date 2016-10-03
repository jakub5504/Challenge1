package com.gft.calendar.directory;


import java.util.List;

public interface Branch {
    void addSubBranch(Branch subBranch);
    void addSubLeaf(Leaf subLeaf);
    List<Branch> getBranches();
    List<Leaf> getLeafs();
}
