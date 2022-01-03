package com.feirasoft.userservice.service;

import com.feirasoft.userservice.dto.UserDto;
import com.feirasoft.userservice.model.user.User;

public interface UserService {

    UserDto register(UserDto userDto);
    UserDto findUserByEmail(String email);
    UserDto updateProfile(UserDto userDto);
    UserDto changePassword(UserDto userDto, String newPassword);
}
