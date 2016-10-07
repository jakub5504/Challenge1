package com.gft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;


/**
 * Created by jbki on 9/28/2016.
 */
@SpringBootApplication
public class WebApp {

    public static void main(String[] args){

        File[] files = new File("C:/test/").listFiles();
        SpringApplication.run(WebApp.class, args);
        //Tree tree = new Tree();
        //showFiles(files);

        //CalendarIterable date = new CalendarIterable();
        //CalendarIterator dateIterator = date.iterator();



    }
}
