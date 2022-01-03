package com.feirasoft.userservice.service;

import com.feirasoft.userservice.dto.AccountDto;
import com.feirasoft.userservice.dto.TokenResponseDto;
import com.feirasoft.userservice.model.user.User;

public interface AuthService {

    User login(AccountDto user);
    User register(AccountDto req);

    TokenResponseDto generateToken(AccountDto req);
}
