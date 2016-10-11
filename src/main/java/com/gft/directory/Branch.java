package com.gft.directory;


import java.util.LinkedList;


public interface Branch {
    LinkedList<Branch> getBranches();
    LinkedList<Leaf> getLeafs();

}
