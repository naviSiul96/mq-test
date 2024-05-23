package com.example.mq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mq")
public class MqController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${queue.in}")
    private String queueIn;

    @PostMapping("/send")
    public ResponseEntity<String> producer(){
        jmsTemplate.convertAndSend(queueIn,  "Mensaje");
        return new ResponseEntity<>("Mensaje enviado", HttpStatus.OK);
    }
}
