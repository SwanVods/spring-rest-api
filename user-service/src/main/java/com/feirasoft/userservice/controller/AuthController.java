package com.feirasoft.userservice.controller;

import com.feirasoft.userservice.model.user.User;
import com.feirasoft.userservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AuthController {

    private UserService userService;

    @GetMapping("/login")
    public ResponseEntity<?> login() {
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> registerNewUser(@RequestBody User user) {
        userService.
    }
}
