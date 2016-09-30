package com.gft.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.core.MessageSendingOperations;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * Created by jbki on 9/30/2016.
 */

@Component
public class WebSocketSubscribeImp implements WebSocketSubscribe{

    @Autowired
    private MessageSendingOperations<String> messageSendingOperations;
    public void sendTreeStructure(File[] files) {

        for (File file : files){
            messageSendingOperations.convertAndSend("/hello");
        }
    }
}
