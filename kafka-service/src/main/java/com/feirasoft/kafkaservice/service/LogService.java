package com.feirasoft.kafkaservice.service;

import com.feirasoft.kafkaservice.model.Log;

import java.util.Collection;

public interface LogService {
    Log storeLog(Log log);
    Collection<Log> retrieveLogs();
}
