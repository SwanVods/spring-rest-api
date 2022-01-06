package com.feirasoft.postservice.service.impl;

import com.feirasoft.postservice.service.KafkaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaServiceImpl implements KafkaService {

    private static String TOPIC = "logs";
    private static final Logger logger = LoggerFactory.getLogger(KafkaServiceImpl.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendLog(String message) {
        logger.info(String.format("#### -> Producing message -> %s", message));
        this.kafkaTemplate.send(TOPIC, message);
    }
}
