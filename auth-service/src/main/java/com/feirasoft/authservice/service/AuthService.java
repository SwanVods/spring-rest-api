package com.feirasoft.authservice.service;


import com.feirasoft.authservice.model.User;
import com.feirasoft.authservice.dto.TokenDto;
import com.feirasoft.authservice.dto.AuthDto;

public interface AuthService {
    User register(AuthDto req);
    TokenDto generateToken(AuthDto req);
}
