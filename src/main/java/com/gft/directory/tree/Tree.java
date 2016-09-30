package com.gft.directory.tree;

import com.gft.messaging.WebSocketSubscribe;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;


/**
 * Created by jbki on 9/30/2016.
 */
public class Tree {

    @Autowired
    private static WebSocketSubscribe webSocketSubscribe;

    public static void showFiles(File[] files){

        for(File file : files ){
            if(file.isDirectory()){
                System.out.println("Directory: " + file.getName());
                showFiles(file.listFiles());
            } else {
                System.out.println("File: " + file.getName());
            }
        }
        webSocketSubscribe.sendTreeStructure(files);
    }

}
