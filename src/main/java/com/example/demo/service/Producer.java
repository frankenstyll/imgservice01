package com.example.demo.service;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class Producer {

     @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

     @Autowired
    Gson gson;

    private static String TOPIC1 = "ONELYNK1";
    private static String TOPIC2 = "ONELYNK2";

    private int global_counter = 1;

    public void produce1(String data) {
        log.info("Produce Topic: {} - Message: {}", TOPIC1, data);
        Map<String, Object> req = new HashMap<>();
        req.put("code", global_counter++);
        req.put("message", "fail");
        req.put("method", "produce1");

        log.info("req {}", gson.toJson(req) );
        this.kafkaTemplate.send(TOPIC1, gson.toJson(req));
    }

    public void produce2(String data) {
        log.info("Produce Topic: {} - Message: {}", TOPIC2, data);

        List<Map<String,Object>> lst = new ArrayList<>();
        int i =0;
        while (i< 10){
            Map<String, Object> m = new HashMap<>();
            m.put("round" + (i+1), "data round " + (i+1));
            lst.add(m);
            i++;
        }

        Map<String, Object> req = new HashMap<>();
        req.put("code", global_counter++);
        req.put("message", "success");
        req.put("method", "produce2");
        req.put("data", lst);
        log.info("req {}", gson.toJson(req) );
        this.kafkaTemplate.send(TOPIC2, gson.toJson(req) );
    }

}
