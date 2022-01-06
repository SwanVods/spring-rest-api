package com.feirasoft.logservice.model;

import org.springframework.stereotype.Component;

@Component
public class LogMapper {
    public static LogDto toLogDto(Log log) {
        return new LogDto().setData(log.getData());
    }
}
