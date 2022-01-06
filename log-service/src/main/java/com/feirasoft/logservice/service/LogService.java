package com.feirasoft.logservice.service;

import com.feirasoft.logservice.model.Log;
import com.feirasoft.logservice.model.LogDto;

import java.util.Collection;

public interface LogService {
    LogDto storeLog(LogDto log);
    Collection<Log> retrieveLogs();
}
