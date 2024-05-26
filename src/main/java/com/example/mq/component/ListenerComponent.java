package com.example.mq.component;

import com.example.mq.config.ConfigMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class ListenerComponent {

    static boolean warned = false;

    private final ConfigMap configMap;

    @Autowired
    public ListenerComponent(ConfigMap configMap){
        System.out.println("Value queue queue.in " + configMap.getQueueIn());
        this.configMap = configMap;
    }


    @JmsListener(destination = "${queue.in}")
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
