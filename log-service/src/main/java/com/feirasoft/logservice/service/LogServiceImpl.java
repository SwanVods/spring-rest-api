package com.feirasoft.logservice.service;

import com.feirasoft.logservice.model.Log;
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
    public Log storeLog(Log log) {
        System.out.println(log);
        return repository.save(log);
    }

    @Override
    public Collection<Log> retrieveLogs() {
        return new ArrayList<>(repository.findAll());
    }
}
