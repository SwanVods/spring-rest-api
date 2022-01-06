package com.feirasoft.authservice.service;


import com.feirasoft.authservice.dto.AuthDto;
import com.feirasoft.authservice.dto.TokenDto;
import com.feirasoft.authservice.model.User;

public interface AuthService {
    User register(AuthDto req);
    TokenDto generateToken(AuthDto req);
}
