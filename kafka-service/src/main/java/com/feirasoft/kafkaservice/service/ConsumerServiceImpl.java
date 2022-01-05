package com.feirasoft.kafkaservice.service;

import com.feirasoft.kafkaservice.model.Log;
import com.feirasoft.kafkaservice.repository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsumerServiceImpl implements ConsumerService {

    private final LogRepository repository;

    @Override
    @KafkaListener(topics = "${app.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void writeLog(String message) {
        repository.save(new Log().setData(message));
    }
}
