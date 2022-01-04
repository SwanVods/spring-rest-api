package com.feirasoft.authservice.service;

import com.feirasoft.authservice.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collection;
import java.util.List;

public interface UserService extends UserDetailsService {
    UserDto getUserDetails(String username);
    Collection<UserDto> retrieveAllUsers(String username);
}
