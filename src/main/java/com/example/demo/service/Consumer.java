package com.example.demo.service;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.io.IOException;

//import org.springframework.kafka.annotation.KafkaListener;

@Slf4j
@Service
public class Consumer {
    @Autowired
    Gson gson;
    private final String GROUP_ID = "ONELYNK_GROUP";

    //@KafkaListener(topics = "ONELYNK1", groupId = GROUP_ID)
//    @KafkaListener(topics = "ONELYNK1")
//    public void consume1(String message) throws IOException {
//        log.info("Consume1 Message: {}", message);
//    }
//
//    //@KafkaListener(topics = "ONELYNK2", groupId = GROUP_ID)
//    @KafkaListener(topics = "ONELYNK2")
//    public void consume2(String message) throws IOException {
//        log.info("Consume2 Message: {}", message);
//    }
}
