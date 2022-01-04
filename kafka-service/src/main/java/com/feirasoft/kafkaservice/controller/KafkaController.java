package com.feirasoft.kafkaservice.controller;

import com.feirasoft.kafkaservice.service.Consumer;
import com.feirasoft.kafkaservice.service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KafkaController {

    @Autowired
    private Producer producer;
    @Autowired
    private Consumer consumer;

    @Autowired
    KafkaController(Producer producer, Consumer consumer) {
        this.producer = producer;
        this.consumer = consumer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestBody String message) {
        this.producer.sendMessage(message);
    }

    @GetMapping("/receive")
    public List<String> receive() {
        return Consumer.messages;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }
}
