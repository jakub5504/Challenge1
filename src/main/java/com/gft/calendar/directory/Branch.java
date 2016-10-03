package com.gft.calendar.directory;


public interface Branch {
    void addSubBranch(Branch subBranch);
    void addSubLeaf(Leaf subLeaf);
}
