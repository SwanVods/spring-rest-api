package com.feirasoft.userservice.service.impl;

import com.feirasoft.userservice.dto.AccountDto;
import com.feirasoft.userservice.dto.TokenResponseDto;
import com.feirasoft.userservice.model.user.User;
import com.feirasoft.userservice.repository.UserRepository;
import com.feirasoft.userservice.security.JwtProvider;
import com.feirasoft.userservice.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository repository;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User login(AccountDto user) {
        return null;
    }

    @Override
    public User register(AccountDto req) {
        User user = new User();
        user.setUsername(req.getUsername());
        user.setPassword(passwordEncoder.encode(req.getPassword()));
        return repository.save(user);
    }

    @Override
    public TokenResponseDto generateToken(AccountDto req) {
        try{
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtProvider.generateToken(authentication);
            TokenResponseDto tokenResponse = new TokenResponseDto();
            tokenResponse.setToken(jwt);
            return tokenResponse;

        } catch (BadCredentialsException e) {
            log.error("Bad Credential", e);
            throw new RuntimeException(e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}

