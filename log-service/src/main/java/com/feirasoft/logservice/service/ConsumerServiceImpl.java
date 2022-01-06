package com.feirasoft.logservice.service;

import com.feirasoft.logservice.model.Log;
import com.feirasoft.logservice.model.LogMapper;
import com.feirasoft.logservice.repository.LogRepository;
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
        LogMapper.toLogDto(repository.save(new Log().setData(message)));
    }
}
