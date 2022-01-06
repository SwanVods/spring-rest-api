package com.feirasoft.logservice.controller;

import com.feirasoft.logservice.model.Log;
import com.feirasoft.logservice.model.LogDto;
import com.feirasoft.logservice.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/logs")
@RequiredArgsConstructor
public class LogController {

    @Autowired
    private LogService service;

    @PostMapping
    public ResponseEntity<LogDto> store(@RequestBody String message){
        LogDto logDto = new LogDto();
        logDto.setData(message);
        return ResponseEntity.ok(service.storeLog(logDto));
    }

    @GetMapping
    public ResponseEntity<Collection<Log>> retrieveLogs() {
        return ResponseEntity.ok(service.retrieveLogs());
    }

}
