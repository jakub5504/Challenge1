package com.gft.messaging;

import java.io.File;

/**
 * Created by jbki on 9/30/2016.
 */
public interface WebSocketSubscribe {

    void sendTreeStructure(File[] files);
}
