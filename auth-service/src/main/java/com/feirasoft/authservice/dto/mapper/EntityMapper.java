package com.feirasoft.authservice.dto.mapper;

import com.feirasoft.authservice.dto.AuthDto;
import com.feirasoft.authservice.dto.UserDto;
import com.feirasoft.authservice.model.User;
import org.springframework.stereotype.Component;

@Component
public class EntityMapper {
    public static UserDto toUserDto(User user) {
        return new UserDto().setId(user.getId())
                .setUsername(user.getUsername())
                .setEmail(user.getEmail())
                .setRole(user.getRole())
                .setProfile(user.getProfile())
                .setActive(user.isActive());
    }

    public static AuthDto toAuthDto(User user) {
        return new AuthDto().setEmail(user.getEmail())
                .setEmail(user.getEmail())
                .setPassword(user.getPassword());
    }
}
