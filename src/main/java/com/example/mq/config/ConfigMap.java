package com.example.mq.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigMap {

    @Value("${queue.in}")
    private String queueIn;

    public String getQueueIn() {
        return queueIn;
    }

    public void setQueueIn(String queueIn) {
        this.queueIn = queueIn;
    }
}
