package com.example.mq.component;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerComponent {

    static boolean warned = false;

    @JmsListener(destination = "DEV.QUEUE.1")
    public void receiveMessage(String msg){
        infinityWarning();

        System.out.println("Received message " + msg);
    }

    void infinityWarning(){
        if(!warned){
            warned = true;
        }
    }
}
