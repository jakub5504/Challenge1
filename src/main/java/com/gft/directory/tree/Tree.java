package com.gft.directory.tree;

import java.io.File;


/**
 * Created by jbki on 9/30/2016.
 */
public class Tree {

    public static void showFiles(File[] files){

        for(File file : files ){
            if(file.isDirectory()){
                System.out.println("Directory: " + file.getName());
                showFiles(file.listFiles());
            } else {
                System.out.println("File: " + file.getName());
            }
        }
    }

}
