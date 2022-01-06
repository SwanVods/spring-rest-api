package com.feirasoft.authservice.service;

import com.feirasoft.authservice.dto.ProfileDto;
import com.feirasoft.authservice.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collection;

public interface UserService extends UserDetailsService {
    UserDto getUserDetails(String username);
    ProfileDto addUserProfile(ProfileDto profileDto, Long id);
    ProfileDto updateUserProfile(ProfileDto profileDto, Long id);
    Collection<UserDto> retrieveAllUsers(String username);
}
