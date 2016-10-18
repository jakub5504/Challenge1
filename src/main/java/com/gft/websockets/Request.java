package com.gft.websockets;

public class Request {

    private String name;

    public Request() {
    }

    public Request(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String getName() {

        return name;
    }
}
