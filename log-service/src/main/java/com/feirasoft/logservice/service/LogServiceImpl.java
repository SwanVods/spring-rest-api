package com.feirasoft.logservice.service;

import com.feirasoft.logservice.model.Log;
import com.feirasoft.logservice.model.LogDto;
import com.feirasoft.logservice.model.LogMapper;
import com.feirasoft.logservice.repository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
@RequiredArgsConstructor
public class LogServiceImpl implements LogService{

    private final LogRepository repository;

    @Override
    public LogDto storeLog(LogDto log) {
        Log logModel = new Log().setData(log.getData());
        return LogMapper.toLogDto(repository.save(logModel));
    }

    @Override
    public Collection<Log> retrieveLogs() {
        return new ArrayList<>(repository.findAll());
    }
}
