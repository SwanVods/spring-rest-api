package com.feirasoft.authservice.service;


import com.feirasoft.authservice.model.User;
import com.feirasoft.authservice.payload.TokenResponse;
import com.feirasoft.authservice.payload.UsernamePassword;

public interface AuthService {
    User register(UsernamePassword req);
    TokenResponse generateToken(UsernamePassword req);
}
