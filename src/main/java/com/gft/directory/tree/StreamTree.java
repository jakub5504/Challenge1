package com.gft.directory.tree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by jbki on 9/30/2016.
 */
public class StreamTree {

        public static void main(String[] args) {
            try (Stream<Path> paths = Files.walk(Paths.get("/test"))) {
                paths.forEach(System.out::println);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}

