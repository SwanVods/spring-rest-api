package com.feirasoft.userservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AuthController {

    public ResponseEntity<?> login() {
        return ResponseEntity.ok().build();
    }
}
