package com.example.mq.controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mq")
public class MqController {

    @Autowired
    private JmsTemplate jmsTemplate;

    public ResponseEntity<String> producer(){
        jmsTemplate.convertAndSend("DEV.QUEUE.1",  "Mensaje");
        return new ResponseEntity<>("Mensaje enviado", HttpStatus.OK);
    }
}
