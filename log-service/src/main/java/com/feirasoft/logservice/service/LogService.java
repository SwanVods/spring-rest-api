package com.feirasoft.logservice.service;

import com.feirasoft.logservice.model.Log;

import java.util.Collection;

public interface LogService {
    Log storeLog(Log log);
    Collection<Log> retrieveLogs();
}
