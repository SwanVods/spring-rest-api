package com.feirasoft.authservice.dto;

import com.feirasoft.authservice.model.UserRoles;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private ProfileDto profile;
    private UserRoles role;
    private boolean active;
}
