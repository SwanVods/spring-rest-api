package com.feirasoft.kafkaservice.service;

import com.feirasoft.kafkaservice.model.Log;

public interface ConsumerService {
    void writeLog(String message);
}
