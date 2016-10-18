package com.gft.websockets;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Response greeting(Request request) throws Exception {
        Thread.sleep(1000);
        return new Response("Hello, " + request.getName() + "!");
    }
}
