package com.gft.websockets;

public class Response {
    private String content;

    public Response(){
    }

    Response(String content){
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
