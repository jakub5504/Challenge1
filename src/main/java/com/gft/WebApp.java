package com.gft;

import com.gft.calendar.DateIterable;
import com.gft.calendar.DateIterator;
import com.gft.directory.tree.Tree;
import com.gft.messaging.WebSocketSubscribe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

import static com.gft.directory.tree.Tree.showFiles;


/**
 * Created by jbki on 9/28/2016.
 */
@SpringBootApplication
public class WebApp {

    @Autowired
    private WebSocketSubscribe webSocketSubscribe;

    public static void main(String[] args){

        File[] files = new File("C:/test/").listFiles();
        SpringApplication.run(WebApp.class, args);
        Tree tree = new Tree();
        showFiles(files);

        //DateIterable date = new DateIterable();
        //DateIterator dateIterator = date.iterator();



    }
}
