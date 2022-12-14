package com.example.demo.controller;

import com.example.demo.service.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ProducerController {

    @Autowired
    private Producer producer;

    @GetMapping(value = "/publish1/{message}")
    public void sendMessageToKafkaTopic1(@RequestParam("message") String message) {
        this.producer.produce1(message);
    }

    @GetMapping(value = "/publish2/{message}")
    public void sendMessageToKafkaTopic2(@RequestParam("message") String message) {
        this.producer.produce2(message);
    }
}
