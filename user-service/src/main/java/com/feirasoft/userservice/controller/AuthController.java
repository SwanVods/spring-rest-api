package com.feirasoft.userservice.controller;

import com.feirasoft.userservice.dto.AccountDto;
import com.feirasoft.userservice.model.user.User;
import com.feirasoft.userservice.service.AuthService;
import com.feirasoft.userservice.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AccountDto usernamePassword) {
        authService.register(usernamePassword);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/token")
    public ResponseEntity<?> generateToken(@RequestBody AccountDto req) {
        return ResponseEntity.ok(authService.generateToken(req));
    }

    @GetMapping("/login")
    public ResponseEntity<?> login() {
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> registerNewUser(@RequestBody User user) {
        return ResponseEntity.ok().build();
    }
}
