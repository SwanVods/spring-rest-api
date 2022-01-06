package com.feirasoft.authservice.dto.mapper;

import com.feirasoft.authservice.dto.ProfileDto;
import com.feirasoft.authservice.dto.UserDto;
import com.feirasoft.authservice.model.User;
import com.feirasoft.authservice.model.UserProfile;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class EntityMapper {
    public static UserDto toUserDto(User user) {
        return new UserDto().setId(user.getId())
                .setUsername(user.getUsername())
                .setEmail(user.getEmail())
                .setRole(user.getRole())
                .setProfile(toProfileDto(user.getProfile()))
                .setActive(user.isActive());
    }

    public static ProfileDto toProfileDto(@Nullable UserProfile userProfile) {
        if(userProfile == null) return null;
        return new ProfileDto()
                .setBio(userProfile.getBio())
                .setDob(userProfile.getDob())
                .setFirstName(userProfile.getFirstName())
                .setLastName(userProfile.getLastName())
                .setImage(userProfile.getImage());
    }
}
