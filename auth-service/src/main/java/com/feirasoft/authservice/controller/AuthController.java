package com.feirasoft.authservice.controller;

import com.feirasoft.authservice.dto.AuthDto;
import com.feirasoft.authservice.model.User;
import com.feirasoft.authservice.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid AuthRequest req) {
        AuthDto authDto = new AuthDto().setUsername(req.getUsername())
                .setEmail(req.getEmail())
                .setPassword(req.getPassword());

        User user = authService.register(authDto);

        if(user == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/token")
    public ResponseEntity<?> generateToken(@RequestBody AuthDto req) {
        return ResponseEntity.ok(authService.generateToken(req));
    }
}
